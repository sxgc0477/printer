/**
 * 
 */
package printer.model;

/**
 * @author Chris
 * 
 * definite kinds of goods
 *
 */
public class Goods {
	
	
	
	
	//bar code
	private String id;
	//the name of goods
	private String name;
	//count number of goods
	private int count;
	//goods unit
	private String unit;
	//price of goods
	private double price;
	//category of goods
	private String category;
	
	private int dropCnt;
	
	private double dropPrice;
	
	private double totalPrice;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count += count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getDropCnt() {
		return dropCnt;
	}

	public void setDropCnt(int dropCnt) {
		this.dropCnt = dropCnt;
	}

	public double getDropPrice() {
		return dropPrice;
	}

	public void setDropPrice(double dropPrice) {
		this.dropPrice = dropPrice;
	}

	public double getTotalPrice() {
		if(totalPrice==0){
			totalPrice = getCount()*getPrice();
		}
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	

}
