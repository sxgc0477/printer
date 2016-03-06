/**
 * 
 */
package printer.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import printer.model.Goods;
import printer.model.Promotion;
import printer.model.ShoppingCart;
import printer.service.DropHandler;
import printer.util.ResourceUtil;

/**
 * @author Administrator
 *
 */
public class  PromotionCenter {
	
	
	private static PromotionCenter INSTANCE = null;
	
	//load from promotion dict
	private List<Promotion> promotionList = new ArrayList<Promotion>();
	
	private Properties promotionsHandler;
	
	private PromotionCenter(){
		autoLoading();
	}
	
	public static synchronized PromotionCenter getInstance(){
		
		if(null == INSTANCE){
			INSTANCE = new PromotionCenter();
			INSTANCE.registerHandler();
		}
		return INSTANCE;
	}
	
	public void autoLoading(){
		ResourceUtil util = ResourceUtil.getInstance();
	    promotionsHandler =util.loadPropFile("promotionHandler.properties");
	    promotionList = util.loadPromotionFile("promotions.json");
		
	}
	
	public void registerHandler(){
		Class<DropHandler> clazz;
		try {
		for (Promotion promotion : promotionList) {
				DropHandler handler = null;
			    clazz =  (Class<DropHandler>) Class.forName((String) promotionsHandler.get(promotion.getId()));
				handler = clazz.newInstance();
				promotion.setHandler(handler);
			}
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
  public DropHandler getHandlerByGoods(Goods goods){
	  
	  List<Promotion> promotion4Goods = new ArrayList<Promotion>();
	  for(Promotion promotion: promotionList){
		  if(goods.getId().equals(promotion.getGoodsId())){
			  promotion4Goods.add(promotion);
		  }
	  }
	  
	  promotion4Goods.sort(new Comparator<Promotion>(){

		public int compare(Promotion arg0, Promotion arg1) {
			int flag = 0;
			if(arg0.getPriority()>arg1.getPriority()){
				flag = 1;
			}else if(arg0.getPriority()==arg1.getPriority()){
				flag = 0;
			}else{
				flag = -1;
			}
			return flag;
		}});
	  
	  if(!promotion4Goods.isEmpty()){
		  return promotion4Goods.get(0).getHandler();
	  }
	  
	 return null;
  } 

	
  public ShoppingCart dropByPromotionCenter(ShoppingCart cart){
		
	    DropHandler handler = null;
		for (Goods goods : cart.getGoods()) {
			handler = this.getHandlerByGoods(goods);
			if(null != handler){
			 handler.dropGoods(goods);	
			}
		}
		
		
		return cart;
		
	}
}
	
	
	
