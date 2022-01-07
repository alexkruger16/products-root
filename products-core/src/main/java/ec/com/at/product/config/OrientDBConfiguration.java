/**
 * 
 */
package ec.com.at.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

/**
 * @author asguato
 *
 */
@SuppressWarnings("deprecation")
@Configuration
public class OrientDBConfiguration {
	// The orientdb installation folder
    //private static String orientDBFolder = System.getenv("ORIENTDB_HOME");
    
    /**
     * Connect and build the OrientDB Bean for Document API
     * @return
     */
    @SuppressWarnings({ "resource"})
    @Bean
    public ODatabaseDocumentTx orientDBfactory() {
        return new ODatabaseDocumentTx("plocal:/Applications/orientdb-community-2.2.35/databases/products")
                .open("admin", "admin");
    }

}
