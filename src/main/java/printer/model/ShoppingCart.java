/**
 * 
 */
package printer.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import printer.service.ShoppingCartHandler;
import printer.service.impl.PromotionCenter;
import printer.util.ResourceUtil;

/**
 * @author Administrator
 *
 */
public class ShoppingCart implements ShoppingCartHandler {
	
	
	private List<Goods> goodsList = new ArrayList<Goods>();
	
	private Map<String,Goods> sortedMap = new HashMap<String,Goods>();
	
	private StringBuffer sb = new StringBuffer();
	
	private double totalPrice;
	
	private double totalDrop;

	/* (non-Javadoc)
	 * @see printer.ShoppingCartHandler#loading()
	 */
	public void loading() {
		ResourceUtil util = ResourceUtil.getInstance();
		List<String> idList = util.loadJsonFile("goods.json");
		List<Goods> metaDict = util.loadGoodsFile("goodsDict.json");
		Goods goods = null;
		for (String id : idList) {
			goods =  new Goods();
			int offset = id.indexOf("-");
			if(offset>0){
				goods.setId(id.substring(0, offset));
				goods.setCount(Integer.parseInt(id.substring(offset+1)));
			}else{
				goods.setCount(1);
				goods.setId(id);
			}
			
			goods = loadMetaFromDict(goods,metaDict);
			goodsList.add(goods);
			if(null == sortedMap.get(goods.getId())){
				sortedMap.put(goods.getId(), goods);
			}else{
				Goods old = sortedMap.get(goods.getId());
				old.setCount(goods.getCount());
				//sortedMap.put(id, value);
			}
			
		}
	}

	private Goods loadMetaFromDict(Goods goods,List<Goods> list) {
		for (Goods meta : list) {
			if(meta.getId().equals(goods.getId())){
				goods.setName(meta.getName());
				goods.setPrice(meta.getPrice());
				goods.setUnit(meta.getUnit());
			}
		}
		return goods;
	}

	/* (non-Javadoc)
	 * @see printer.ShoppingCartHandler#getGoods()
	 */
	public Collection<Goods> getGoods() {
		// TODO Auto-generated method stub
		return this.sortedMap.values();
	}

	/* (non-Javadoc)
	 * @see printer.ShoppingCartHandler#getMessage()
	 */
	public String getMessage() {

		StringBuffer sb1,sb2,sb3;
		sb1 = new StringBuffer();
		sb2 = new StringBuffer();
		sb3 = new StringBuffer();
		sb1.append("***<没钱赚>购物清单*** \n");
		sb3.append("-------------------- \n");
		for (Goods goods : sortedMap.values()) {
			sb1.append("名称:"+goods.getName()+",数量："+goods.getCount()+"("+goods.getUnit()+"), 小计:"+goods.getTotalPrice()+"(元)");
			if(goods.getDropPrice()>0){
				sb1.append(", 节省:"+goods.getDropPrice());
			}
			sb1.append("\n");
			if(goods.getDropCnt()>0){
				sb2.append("名称:"+goods.getName()+",数量："+goods.getDropCnt()+"\n");
			}
		}
		if(sb2.length()>0){
			//sb2.append("买二赠一商品: \n");
			//sb2.append("--------------------\n");
			sb2.insert(0, "--------------------\n");
			sb2.insert(0, "买二赠一商品: \n");
		}
		sb3.append("总计:"+getTotalPrice()+"(元) \n");
		if(getTotalDrop()>0){
			sb3.append("节省:"+"(元) \n");
		}
		sb3.append("****************");
		
		sb.append(sb1);
		sb.append(sb2);
		sb.append(sb3);
		
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see printer.ShoppingCartHandler#dropByPromotionCenter(printer.PromotionCenter)
	 */
	public void dropByPromotionCenter(PromotionCenter pc) {
		
		for (Goods goods : goodsList) {
			pc.getHandlerByGoods(goods).dropGoods(goods);
		}
	}

	public double getTotalPrice() {
		
		for (Goods goods : sortedMap.values()) {
			totalPrice = totalPrice+goods.getTotalPrice();
		}
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		
		this.totalPrice = totalPrice;
	}

	public double getTotalDrop() {
		
		for (Goods goods : goodsList) {
			totalDrop = totalDrop+goods.getDropPrice();
		}
		return totalDrop;
	}

	public void setTotalDrop(double totalDrop) {
		this.totalDrop = totalDrop;
	}
	
	@Override
	public String toString(){
		StringBuffer sc = new StringBuffer();
		for( Goods goods : goodsList){
			sc.append("goodsName:"+goods.getName()+",goodsCount:"+goods.getCount()+",goodsPrice:"+goods.getPrice()+"\n");	
		}
		return sb.toString();
		
		
	}
	
	

}
