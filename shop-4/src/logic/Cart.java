package logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Cart {
	
	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return itemList;
	}

	public void push(ItemSet itemSet) {
		for(ItemSet is : itemList){
			if(is.getItem().getId() == itemSet.getItem().getId()){
				is.setQuantity(is.getQuantity()+itemSet.getQuantity());
				return;
			}
		}
		itemList.add(itemSet);
	}

	public String remove(int index) {
		
		ItemSet itemSet = itemList.remove(index);
		return itemSet.getItem().getName();
	}

	public boolean isEmpty() {
		return (itemList==null || itemList.isEmpty())? true:false;
	}

	public void clearAll(HttpSession session) {
		itemList.clear();
		session.setAttribute("CART", this);
		
	}

}
