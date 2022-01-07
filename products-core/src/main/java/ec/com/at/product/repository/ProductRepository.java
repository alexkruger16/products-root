/**
 * 
 */
package ec.com.at.product.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orientechnologies.orient.core.db.ODatabaseRecordThreadLocal;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.at.product.ProductVO;
import ec.com.at.product.entity.pojo.Product;

/**
 * @author asguato
 *
 */
@SuppressWarnings("deprecation")
@Repository
public class ProductRepository implements IProductRepository {
	
	@Autowired
	private ODatabaseDocumentTx db;

	@Override
	public void saveProduct(ProductVO productVO) {
		ODatabaseRecordThreadLocal.instance().set(db);

		ODocument productDB = db.newInstance(Product.class.getSimpleName());
		productDB.field("barCode", productVO.getBarCode());
		productDB.field("companyCode", productVO.getCompanyCode());
		productDB.field("dateRegister", new Date());
		productDB.field("description", productVO.getDescription());
		productDB.field("price", productVO.getPrice());
		productDB.field("userId", "ADMIN");
		productDB.save();
	}

}
