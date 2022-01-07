/**
 * 
 */
package ec.com.at.product.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author asguato
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class InterceptorMessageError implements IInterceptorMessageError {

	protected String id;

    protected String type;

    protected String message;

    protected String url;

    /**
     * Constructor.
     *
     * @param type    The type of the message
     * @param message The message
     * @param url     The url
     * @since 2.0.0
     */
    public InterceptorMessageError(String type, String message, String url) {
        this.id = String.valueOf(System.currentTimeMillis());
        this.type = type;
        this.message = message;
        this.url = url;
    }

}
