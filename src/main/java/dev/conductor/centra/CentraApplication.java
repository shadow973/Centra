package dev.conductor.centra;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableMongock
@SpringBootApplication
@EnableCaching
public class CentraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentraApplication.class, args);
	}

	@Configuration
	static class WebConfiguration implements WebMvcConfigurer {

		/**
		 * Ensure client-side paths redirect to index.html because client handles routing. NOTE: Do NOT use @EnableWebMvc or it will break this.
		 */
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/{spring:\\w+}")
					.setViewName("forward:/index.html");
			registry.addViewController("/**/{spring:\\w+}")
					.setViewName("forward:/index.html");
			registry.addViewController("/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}")
					.setViewName("forward:/index.html");
		}
	}

	@Bean
	public ModelMapper modelMapper() {
		class NullModelMapper extends ModelMapper {
			@Override
			public <D> D map(Object source, Class<D> destinationType) {
				if(source == null){
					return null;
				}

				return super.map(source, destinationType);
			}
		}

		return new NullModelMapper();
	}
}
