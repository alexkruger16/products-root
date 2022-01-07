/**
 * 
 */
package ec.com.at.product.repository;

import ec.com.at.product.ProductVO;

/**
 * @author asguato
 *
 */
public interface IProductRepository {
	
	/**
	 * Save product.
	 * @author asguato on <b>2022/01/06.</b>  
	 * 
	 * @param productVO
	 */
	void saveProduct(ProductVO productVO);

}
