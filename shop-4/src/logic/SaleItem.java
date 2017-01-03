package logic;

import java.sql.Timestamp;

public class SaleItem {
	private Integer saleItemId;
	private Integer itemId;
	private Item item;
	private Timestamp updateTime;
	private Integer quantity;
	private Sale sale;
	public SaleItem(){}
	public SaleItem(Sale sale, int saleItemId, ItemSet itemSet, Timestamp currentTime){
		this.sale=sale;
		this.saleItemId=saleItemId;
		this.item=itemSet.getItem();
		this.updateTime=currentTime;
		this.quantity = itemSet.getQuantity();
		
	}
	public Integer getSaleItemId() {
		return saleItemId;
	}
	public void setSaleItemId(Integer saleItemId) {
		this.saleItemId = saleItemId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
}
