package br.com.valloo.cards.infrastructure.exception;

public class EnityDuplicatedException extends RuntimeException {

    public EnityDuplicatedException(String entityName, String field) {
        super(entityName + " -> " + field + ": " +
                "Exist Enity with this field!");
    }
}
