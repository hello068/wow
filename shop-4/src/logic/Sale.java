package logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Sale {
	
	private Integer saleId;
	private User user;
	private Timestamp updateTime;
	private List<SaleItem> saleItemList = new ArrayList<SaleItem>();
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public List<SaleItem> getSaleItemList() {
		return saleItemList;
	}
	public void setSaleItemList(List<SaleItem> saleItemList) {
		this.saleItemList = saleItemList;
	}
	
	
	

}
