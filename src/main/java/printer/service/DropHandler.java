/**
 * 
 */
package printer.service;

import printer.model.Goods;

/**
 * @author Administrator
 *
 */
public interface DropHandler {
	
	public int getPriority();
	
	public Goods dropGoods(Goods goods);

}
