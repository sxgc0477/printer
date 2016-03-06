/**
 * 
 */
package printer.service;

import printer.model.ShoppingCart;
import printer.service.impl.PromotionCenter;

/**
 * @author Administrator
 *
 */
public interface AccountCenterHandler {
	
	public void injectPromotionCenter(PromotionCenter promotionCenter);
	
	public String calculate(ShoppingCart cart);
	

}
