/**
 * 
 */
package ec.com.at.product.entity.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author asguato
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product {

	private Integer companyCode;
	private String barCode;
	private String description;
	//unique price
	private BigDecimal price;
	
	//audit field
	private String userId;
	private Date dateRegister;
	private String userModify;
	private Date dateModify;
	
	
	
	
}
