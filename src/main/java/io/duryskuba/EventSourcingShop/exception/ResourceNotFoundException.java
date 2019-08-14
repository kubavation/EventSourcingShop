package io.duryskuba.EventSourcingShop.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> clazz) {
        super("RESOURCE NOT FOUND OF CLASS " + clazz.toString());
    }

}
