package cc.aisc.platform.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

/**
 * Created by sjf on 15-11-11.
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        LOGGER.debug("No such element exception: {}", e.getMessage());
        return "404";
    }

    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleForbiddenException(SecurityException e) {
        LOGGER.debug("SECURITY exception: {}", e.getMessage());
        return "403";
    }
}
