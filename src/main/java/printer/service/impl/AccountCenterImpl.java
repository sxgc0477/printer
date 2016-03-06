package printer.service.impl;

import printer.model.ShoppingCart;
import printer.service.AccountCenterHandler;
import printer.service.ShoppingCartHandler;

public class AccountCenterImpl implements AccountCenterHandler {
	
	private PromotionCenter pc;

	public void injectPromotionCenter(PromotionCenter promotionCenter) {
		
		this.pc = promotionCenter;
	}

	public String calculate(ShoppingCartHandler cart) {
		// TODO Auto-generated method stub
		
		cart.dropByPromotionCenter(pc);
		
		return cart.getMessage();
	}

	public PromotionCenter getPc() {
		return pc;
	}

	public String calculate(ShoppingCart cart) {
		
		cart = pc.dropByPromotionCenter(cart);
		
		return cart.getMessage();
	}
	
	

}
