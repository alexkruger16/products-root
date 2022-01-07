/**
 * 
 */
package ec.com.at.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author asguato
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
	private Integer companyCode;
	private String barCode;
	private String description;
	private BigDecimal price;

}
