/**
 * 
 */
package ec.com.at.product.configuration;

/**
 * @author aguato
 *
 */
public interface IInterceptorMessageError {
	/**
     *
     * @return The id of the error
     */
    String getId();

    /**
     *
     * @return The message
     */
    String getMessage();

    /**
     *
     * @return The type.
     */
    String getType();

    /**
     *
     * @return The url
     */
    String getUrl();

}
