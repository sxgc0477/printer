/**
 * 
 */
package printer.model;

import printer.service.DropHandler;

/**
 * @author Administrator
 *
 */
public class Promotion {
	
	private String id;
	
	private String goodsId;
	
	private String name;
	
	private String type;
	
	private int priority;
	
	private DropHandler handler;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public DropHandler getHandler() {
		return handler;
	}

	public void setHandler(DropHandler handler) {
		this.handler = handler;
	}
	
	
	

}
