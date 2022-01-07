/**
 * 
 */
package ec.com.at.product;

import java.util.Objects;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ec.com.at.product.configuration.RestControllerHandleExceptions;
import ec.com.at.product.configuration.RestControllerSuccess;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asguato on <b>2020/04/16</b>
 * @version 1.0
 * @since 1.0.0
 *
 */
@SpringBootApplication(scanBasePackages= {"ec.com.at.product"})
@Import({RestControllerHandleExceptions.class, RestControllerSuccess.class})
@Slf4j
public class ProductSpringBootApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProductSpringBootApplication.class);
	}
	 
	public static void main(String... args) {
		try {
			SpringApplication app = new SpringApplication(ProductSpringBootApplication.class);
			app.run(args);
		} catch (Exception ex) {
			if (!Objects.equals(ex.getClass().getName(), "org.springframework.boot.devtools.restart.SilentExitExceptionHandler$SilentExitException")
                    && log.isErrorEnabled()) {
                log.error("*************************************Ha ocurrido una exception**********************************");
                log.error("Exception: " + ex.toString());
                log.error("Root Cause: " + ExceptionUtils.getRootCause(ex).toString());
            }
		}
		
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
    }

}
