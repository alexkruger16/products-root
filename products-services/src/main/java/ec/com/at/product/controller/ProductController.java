/**
 * 
 */
package ec.com.at.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.at.product.ProductVO;
import ec.com.at.product.service.IProductService;

/**
 * @author asguato on <b>2020/04/20</b>
 * @version 1.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/data")
	public String getInitialMessage() {
		return "Respuesta desde spring boot modify";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody ProductVO productVO) throws Exception {
		this.productService.saveProduct(productVO);
		return "save ok";
	}

}
