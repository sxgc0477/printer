/**
 * 
 */
package printer.service;

import java.util.Collection;

import printer.model.Goods;
import printer.service.impl.PromotionCenter;

/**
 * @author Administrator
 *
 */
public interface ShoppingCartHandler{

	void loading();

	Collection<Goods> getGoods();
	
	String getMessage();

	void dropByPromotionCenter(PromotionCenter pc);
	
	
	

}
