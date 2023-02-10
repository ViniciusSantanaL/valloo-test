package br.com.valloo.cards.infrastructure.exception;

public class CustomLocalDateDeserializerException extends RuntimeException{

    private final static String messageCustom = ": Invalidate Shape for Custom Local Date (MM-yyyy | MM/yyyy)";

    public CustomLocalDateDeserializerException(String fieldMessage) {
        super(fieldMessage + messageCustom);
    }
}
