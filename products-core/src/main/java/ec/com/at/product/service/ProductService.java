/**
 * 
 */
package ec.com.at.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.at.product.ProductVO;
import ec.com.at.product.repository.IProductRepository;

/**
 * @author asguato
 *
 */
@Service
public class ProductService implements IProductService{
	
	@Autowired
	private IProductRepository repository;

	@Override
	public void saveProduct(ProductVO productVO) throws Exception {
		//Validate data
		if (productVO.getBarCode() == null) {
			throw new Exception("Barcode is required");
		}
		
		this.repository.saveProduct(productVO);
		
	}
	
}
