package br.com.valloo.cards.infrastructure.errorhandling;

import br.com.valloo.cards.infrastructure.exception.EnityDuplicatedException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class DefaultErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleException(Exception ex, HttpServletRequest request) {
        System.out.println(ex.getMessage());
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MessageResponse> handleNotFound(EntityNotFoundException ex) {
        String message = "Not Found: " + ex.getMessage();
        return buildResponse(HttpStatus.NOT_FOUND,message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorValidationResponse>> handleBeanValidation(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(FieldErrorValidationResponse::new).toList());
    }

    @ExceptionHandler(EnityDuplicatedException.class)
    public ResponseEntity<MessageResponse> handleDuplicatedEntity(EnityDuplicatedException ex) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageResponse> handleJsonConverter(HttpMessageNotReadableException exception) {
        return buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
    private ResponseEntity<MessageResponse> buildResponse(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(new MessageResponse(message, status.value()));
    }

    private record FieldErrorValidationResponse(String field, String message){
        public FieldErrorValidationResponse(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
