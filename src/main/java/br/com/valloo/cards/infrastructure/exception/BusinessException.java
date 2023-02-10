package br.com.valloo.cards.infrastructure.exception;

public class BusinessException extends  RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
