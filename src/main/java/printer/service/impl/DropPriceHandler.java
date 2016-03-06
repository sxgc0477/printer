/**
 * 
 */
package printer.service.impl;

import printer.model.Goods;
import printer.service.DropHandler;

/**
 * @author Administrator
 *
 */
public class DropPriceHandler implements DropHandler {
	
	public final static double DROP = 0.95;
	
	public final static double OFF = 0.05;

	/* (non-Javadoc)
	 * @see printer.impl.DropHandler#getPriority()
	 */
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}



	public Goods dropGoods(Goods goods) {
		
		double totalPrice = Math.round(goods.getCount()*goods.getPrice()*DROP);
		double dropPrice = Math.round(goods.getCount()*goods.getPrice()*OFF);
		goods.setDropPrice(dropPrice);
		goods.setTotalPrice(totalPrice);
		
	    return goods;
	}

}
