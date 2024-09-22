package fun.wilddev.spring.web.validators;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;

import org.springframework.validation.*;

@AllArgsConstructor
public abstract class AbstractValidator implements Validator {

    protected final Logger log;

    /**
     * Logging method for {@link Errors} object debugging
     *
     * @param errors - {@link Errors} object
     */
    protected void logSkippingDueToErrors(Errors errors) {

        if (log.isDebugEnabled())
            log.debug("Validation errors exist: {}", errors.getAllErrors());
    }
}
