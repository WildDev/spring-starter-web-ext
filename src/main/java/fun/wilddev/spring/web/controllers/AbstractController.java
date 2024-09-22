package fun.wilddev.spring.web.controllers;

import org.springframework.util.MultiValueMap;
import org.springframework.validation.ObjectError;

import fun.wilddev.spring.web.controllers.responses.errors.*;

import java.util.*;

import org.springframework.http.*;
import org.springframework.validation.*;

/**
 * Rest controller base class. Encapsulates shared logic
 * and provides convenience methods for http responses.
 */
public abstract class AbstractController {

    /**
     * Checks for global error presence by its code
     *
     * @param errors - {@link Errors} object
     * @param code - error code to check
     * @return {@code true}, if there is global error registered
     */
    protected boolean hasGlobalError(Errors errors, String code) {
        return errors.getGlobalErrors().stream().anyMatch(err -> Objects.equals(err.getCode(), code));
    }

    /**
     * Returns global error text once it is registered
     *
     * @param errors - {@link Errors} object
     * @return global error text
     */
    protected String getGlobalErrorText(Errors errors) {
        return Optional.of(errors)
                .map(Errors::getGlobalError)
                .map(ObjectError::getDefaultMessage)
                .orElse(null);
    }

    /**
     * Checks for field error presence by its code
     *
     * @param errors - {@link Errors} object
     * @param field - field name to check
     * @param code - error code to check
     * @return field error text
     */
    protected boolean hasFieldError(Errors errors, String field, String code) {
        return errors.getFieldErrors().stream().filter(err -> Objects.equals(err.getField(), field))
                .anyMatch(err -> Objects.equals(err.getCode(), code));
    }

    /**
     * Assembles an error response
     *
     * @param errors - {@link Errors} object
     * @param httpStatus - http status
     * @return fully assembled server response
     */
    protected ResponseEntity<?> buildErrorResponse(Errors errors, HttpStatus httpStatus) {

        List<FieldErrorResponse> fieldErrors = errors.getFieldErrors().stream().map(e ->
                new FieldErrorResponse(e.getField(), e.getDefaultMessage())).toList();

        return new ResponseEntity<>(new ErrorResponse(getGlobalErrorText(errors), fieldErrors), httpStatus);
    }

    /**
     * Assembles http 200 OK response without a payload
     *
     * @return server response with the only http status set
     */
    public ResponseEntity<?> ok() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Assembles full http 200 OK response
     *
     * @param body - response payload
     * @return fully assembled server response
     *
     * @param <T> - inferred payload's type
     */
    public <T> ResponseEntity<?> ok(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    /**
     * Assembles full http 200 OK response with headers
     *
     * @param body - response payload
     * @param headers - response headers
     * @return fully assembled server response
     *
     * @param <T> - inferred payload's type
     */
    public <T> ResponseEntity<?> ok(T body, MultiValueMap<String, String> headers) {
        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }

    /**
     * Assembles http 201 CREATED response without a payload
     *
     * @return server response with the only http status set
     */
    public ResponseEntity<?> created() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Assembles full http 201 CREATED response
     *
     * @param body - response payload
     * @return fully assembled server response
     *
     * @param <T> - inferred payload's type
     */
    public <T> ResponseEntity<?> created(T body) {
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    /**
     * Assembles http 204 NO_CONTENT
     *
     * @return server response with the only http status set
     */
    public <T> ResponseEntity<?> noContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Assembles http 400 BAD_REQUEST with error fields
     * set based on the supplied {@link Errors} object
     *
     * @return fully assembled server response
     */
    public ResponseEntity<?> badRequest(Errors errors) {
        return buildErrorResponse(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Assembles http 401 UNAUTHORIZED response
     *
     * @return server response with the only http status set
     */
    public ResponseEntity<?> unauthorized() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Assembles http 404 NOT_FOUND response
     *
     * @return server response with the only http status set
     */
    public ResponseEntity<?> notFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Assembles http 412 PRECONDITION_FAILED with error fields
     * set based on the supplied {@link Errors} object
     *
     * @return fully assembled server response
     */
    public ResponseEntity<?> preconditionFailed(Errors errors) {
        return buildErrorResponse(errors, HttpStatus.PRECONDITION_FAILED);
    }

    /**
     * Assembles http 423 LOCKED response
     *
     * @return server response with the only http status set
     */
    public ResponseEntity<?> locked() {
        return new ResponseEntity<>(HttpStatus.LOCKED);
    }
}
