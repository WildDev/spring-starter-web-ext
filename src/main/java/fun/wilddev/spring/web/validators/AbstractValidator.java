package fun.wilddev.spring.web.validators;

import org.slf4j.Logger;

import org.springframework.validation.*;

/**
 * An abstraction for validator implementations
 */
public abstract class AbstractValidator implements Validator {

    /**
     * Instantiates an implementation class by {@link Logger}
     *
     * @param log - logger reference
     */
    protected AbstractValidator(Logger log) {
        this.log = log;
    }

    /**
     * Logger reference
     */
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
