/**
 * 
 */
package ec.com.at.product.configuration;

import java.util.AbstractMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * @author asguato
 *
 */
public class RestControllerHandleExceptions implements IRestControllerHandleExceptions {
	
	/**
     * Handler for {@link Throwable}.
     *
     * @param exception The exception to handle
     * @return Response Entity of {@link IMessageError}
     * 
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<IInterceptorMessageError> handleThrowableException(HttpServletRequest request, Throwable exception) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        AbstractMap.SimpleImmutableEntry<IInterceptorMessageError, Map<String, String>> entry = this.defaultHandler(exception, request);

        HttpHeaders headers = new HttpHeaders();
        entry.getValue().forEach(headers::set);
        return ResponseEntity.status(httpStatus).headers(headers).body(entry.getKey());
    }

}
