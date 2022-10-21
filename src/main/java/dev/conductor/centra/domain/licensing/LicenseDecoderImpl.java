package dev.conductor.centra.domain.licensing;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.util.DefaultPropertiesPersister;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

@Component
public class LicenseDecoderImpl implements LicenseDecoder {

    public static final byte[] LICENSE_PREFIX = { 13, 14, 12, 10, 15 };

    public License decode(String licenseString) {
        String encodedLicenseTextAndHash = getLicenseContent(removeWhiteSpaces(licenseString));
        byte[] zippedLicenseBytes = checkAndGetLicenseText(encodedLicenseTextAndHash);
        Reader licenseText = unzipText(zippedLicenseBytes);

        Properties properties = loadLicenseConfiguration(licenseText);

        return new License(
                Integer.parseInt(properties.get("NumberOfUsers").toString()),
                properties.get("LicenseEdition").toString(),
                properties.get("LicenseID").toString(),
                Boolean.parseBoolean(properties.get("Evaluation").toString()),
                licenseString);
    }


    private byte[] checkAndGetLicenseText(String licenseContent) {
        try {
            byte[] decodedBytes = Base64.decodeBase64(licenseContent.getBytes());
            ByteArrayInputStream in = new ByteArrayInputStream(decodedBytes);
            DataInputStream dIn = new DataInputStream(in);
            int textLength = dIn.readInt();
            byte[] licenseText = new byte[textLength];
            dIn.read(licenseText);
            byte[] hash = new byte[dIn.available()];
            dIn.read(hash);

            return licenseText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getLicenseContent(String licenseString) {
        String lengthStr = licenseString.substring(licenseString.lastIndexOf('X') + 3);
        try {
            int encodedLicenseLength = Integer.valueOf(lengthStr, 31);
            return licenseString.substring(0, encodedLicenseLength);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Could NOT decode license length <" + lengthStr + ">", e);
        }
    }

    private Reader unzipText(byte[] licenseText) {
        ByteArrayInputStream in = new ByteArrayInputStream(licenseText);
        in.skip(LICENSE_PREFIX.length);
        InflaterInputStream zipIn = new InflaterInputStream(in, new Inflater());

        return new InputStreamReader(zipIn, StandardCharsets.UTF_8);
    }

    private Properties loadLicenseConfiguration(Reader text) {
        try {
            Properties props = new Properties();
            new DefaultPropertiesPersister().load(props, text);

            return props;
        } catch (IOException e) {
            throw new RuntimeException("Could NOT load properties from reader", e);
        }
    }

    private static String removeWhiteSpaces(String licenseData) {
        if ((licenseData == null) || (licenseData.length() == 0)) {
            return licenseData;
        }
        char[] chars = licenseData.toCharArray();
        StringBuilder builder = new StringBuilder(chars.length);
        for (char aChar : chars) {
            if (!Character.isWhitespace(aChar)) {
                builder.append(aChar);
            }
        }

        return builder.toString();
    }
}
