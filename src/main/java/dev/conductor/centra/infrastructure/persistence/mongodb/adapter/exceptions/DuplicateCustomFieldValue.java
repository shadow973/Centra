package dev.conductor.centra.infrastructure.persistence.mongodb.adapter.exceptions;

public class DuplicateCustomFieldValue extends RuntimeException{
    public DuplicateCustomFieldValue(String message){
        super(message);
    }
}
