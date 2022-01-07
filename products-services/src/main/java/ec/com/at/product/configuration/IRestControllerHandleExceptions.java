/**
 * 
 */
package ec.com.at.product.configuration;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author aguato
 *
 */
public interface IRestControllerHandleExceptions {
	
	 /**
     * Get the response header.
     *
     * @param request   The request
     * @param throwable The exception to handle
     * @return The response header
     * @since 1.0.0
     */
    @SuppressWarnings("PMD.UseConcurrentHashMap")
    default Map<String, String> getResponseHeader(HttpServletRequest request, Throwable throwable, 
    		IInterceptorMessageError messageError) {
        Map<String, String> header = new HashMap<>();
        header.put("restyp", "ERROR");
        header.put("mes", messageError.getMessage());
        return header;
    }
    
    /**
     * Common Handler.
     *
     * @param exception The exception to handle
     * @param request   The request
     * @return The pair {@link IMessageError}, {@link HttpServletResponse}
     * @since 1.0.0
     */
    @SuppressWarnings("PMD.AvoidCatchingThrowable")
    default AbstractMap.SimpleImmutableEntry<IInterceptorMessageError, Map<String, String>> defaultHandler(Throwable exception, HttpServletRequest request) {
    	IInterceptorMessageError messageError;
        Map<String, String> header = null;
        try {
            messageError = this.getResponseBody(request, exception);
            header = this.getResponseHeader(request, exception, messageError);
            doAfterHandler(exception, request, messageError);
        } catch (Throwable throwable) {
            messageError = new InterceptorMessageError("FATAL_ERROR_IN_HANDLER", throwable.getMessage(), request.getRequestURI());
        }

        return new AbstractMap.SimpleImmutableEntry<>(messageError, header == null ? new HashMap<>() : header);
    }
    
    /**
     * Get the object that represents the body of the response.
     *
     * @param request   The request
     * @param throwable The exception to handle
     * @return The body of the response
     * @since 1.0.0
     */
    default IInterceptorMessageError getResponseBody(HttpServletRequest request, Throwable throwable) {
        return new InterceptorMessageError(throwable.getClass().getSimpleName(), throwable.getMessage(), request.getRequestURI());
    }
    
    /**
     * Do after Handler.
     *
     * @param exception    The exception to handler
     * @param request      The request
     * @param messageError The error message
     * @since 1.0.0
     */
    default void doAfterHandler(Throwable exception, HttpServletRequest request, IInterceptorMessageError messageError) {
        //do nothing
    }

}
