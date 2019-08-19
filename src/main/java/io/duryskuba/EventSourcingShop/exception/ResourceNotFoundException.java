package io.duryskuba.EventSourcingShop.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> clazz) {
        super("RESOURCE NOT FOUND OF CLASS " + clazz.toString());
    }

    public ResourceNotFoundException(Class<?> clazz, Object id) {
        super("RESOURCE NOT FOUND OF ID: " + id.toString() + " OF CLASS " + clazz.toString());
    }

}
