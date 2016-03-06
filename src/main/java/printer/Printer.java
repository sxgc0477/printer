package printer;

import printer.model.ShoppingCart;
import printer.service.AccountCenterHandler;
import printer.service.impl.AccountCenterImpl;
import printer.service.impl.PromotionCenter;

/**
 * @author Administrator
 *
 */
public class Printer {
	
	
	private AccountCenterHandler ac;
	
	private PromotionCenter pc;
	
	private ShoppingCart cart = new ShoppingCart();
	
	
	public String print(){
		
		cart.loading();
		
	    ac = new AccountCenterImpl();
	    
	    pc = PromotionCenter.getInstance();
	    
	    ac.injectPromotionCenter(pc);
		
		return ac.calculate(cart);
		
		
		
	}
	
	public static void main(String[] args) {
		
		Printer printer = new Printer();
		
		System.out.println(printer.print());
	}
	
	

}
