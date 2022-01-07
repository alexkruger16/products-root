/**
 * 
 */
package ec.com.at.product.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author asguato
 * @version 1.0
 * @since 1.0.0
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getInitialMessageTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/product/data").accept(MediaType.APPLICATION_JSON))
										  .andExpect(status().isOk())
										  .andExpect(content().string(equalTo("Respuesta desde spring boot modify")));
		
	}
	

}
