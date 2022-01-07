/**
 * 
 */
package ec.com.at.product.configuration;

import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * Intercept response for rest controller 
 * 
 * <p>
 * Intercept the method of @{@link org.springframework.web.bind.annotation.RestController}
 * 
 * @author aguato
 *
 */
@RestControllerAdvice
public class RestControllerSuccess implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof IInterceptorMessageError) {
            return body;
        }

        if (body instanceof Map && ((Map) body).get("status") != "200") {
            return body;
        }

        if (!response.getHeaders().containsKey("restyp")) {
            response.getHeaders().set("restyp", "SUCCESS");
        }
        return body;
	}

}
