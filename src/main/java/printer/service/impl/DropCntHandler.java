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
public class DropCntHandler implements DropHandler {
	
	

	/* (non-Javadoc)
	 * @see printer.impl.DropHandler#getPriority()
	 */
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see printer.impl.DropHandler#dropGoods(printer.model.Goods, java.lang.StringBuffer)
	 */
	public Goods dropGoods(Goods goods) {
		
			
			int dropCnt = goods.getCount()/3;
			double totalPrice = (goods.getCount()-dropCnt)*goods.getPrice();
			//double dropPrice = dropCnt*goods.getPrice();
			goods.setDropCnt(dropCnt);
			//goods.setDropPrice(dropPrice);
			goods.setTotalPrice(totalPrice);
			
		    return goods;
	}

}
