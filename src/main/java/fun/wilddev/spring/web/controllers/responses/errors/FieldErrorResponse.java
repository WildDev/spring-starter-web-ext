package fun.wilddev.spring.web.controllers.responses.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

/**
 * Field error response schema
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class FieldErrorResponse {

    @JsonProperty
    private String field;

    @JsonProperty
    private String message;
}
