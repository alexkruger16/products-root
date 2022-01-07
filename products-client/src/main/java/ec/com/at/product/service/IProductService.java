/**
 * 
 */
package ec.com.at.product.service;

import ec.com.at.product.ProductVO;

/**
 * @author asguato
 *
 */
public interface IProductService {
	
	/**
	 * Save product.
	 * @author asguato on <b>2022/01/06.</b>  
	 * 
	 * @param productVO {@link ProductVO} Product vo.
	 * @throws Exception 
	 */
	void saveProduct(ProductVO productVO) throws Exception;

}
