package com.trainingweb.trainingdiary.domain.exception;

public class DeletingAssociatedEntityException extends RuntimeException {

    public DeletingAssociatedEntityException(Object object) {
        super("Attempt to delete an entity " + object.getClass().getName() + ", which associated with other entities");
    }
}
