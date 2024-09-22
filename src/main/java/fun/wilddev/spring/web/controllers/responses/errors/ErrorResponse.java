package fun.wilddev.spring.web.controllers.responses.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import lombok.*;

/**
 * Error response schema
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class ErrorResponse {

    @JsonProperty
    private String globalError;

    @JsonProperty
    private List<FieldErrorResponse> fieldErrors;
}
