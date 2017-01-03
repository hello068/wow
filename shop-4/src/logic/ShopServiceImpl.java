package logic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SaleDao;
import dao.UserDao;
import dao.SaleItemDao;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SaleDao saleDao;
	
	@Autowired
	private SaleItemDao saleItemDao;
	
	
	@Override
	public Long calculateTotalAmount(List<ItemSet> itemList) {

		// itemList 객체에 포함된 ItemSet객체의 상품가격*수량의 합을 계산하기
		
		long total=0;
		ItemSet itemSet;
		for(int i=0; i<itemList.size(); i++){
			itemSet = itemList.get(i);
			total+=itemSet.getQuantity()*itemSet.getItem().getPrice();
		}
		
		return total;
	}

	@Override
	public User getUserByIdPw(User user) {
		return userDao.getUser(user.getUserId(), user.getPassword());
	}

	@Override
	public List<Sale> saleList(String userId) {
		return saleDao.list(userId);
	}

	@Override
	public List<SaleItem> saleItemList(Integer saleId) {
		return saleItemDao.list(saleId);
	}

	@Override
	public void createUser(User user) {
		
		userDao.create(user);
		
	}

	@Override
	public User getUserById(String id) {
		
		return userDao.getUser(id, null);
	}

	@Override
	public List<User> getUser() {

		return userDao.getUser();
	}

	@Override
	public List<User> getUser(String[] idchks) {
		return userDao.getUser(idchks);
	}

	@Override
	public Sale checkEnd(User loginUser, Cart cart) {
		Sale sale = new Sale();
		sale.setSaleId(saleDao.getMaxSaleId());
		sale.setUser(loginUser);
		Timestamp currentTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		sale.setUpdateTime(currentTime);
		List<ItemSet> itemList = cart.getItemList();
		for(int i=0; i<itemList.size(); i++){
			ItemSet itemSet = itemList.get(i);
			int saleItemId = i+1;
			SaleItem saleItem = new SaleItem(sale, saleItemId, itemSet, currentTime);
		}
		
		saleDao.createSale(sale);
		List<SaleItem> saleItemList = sale.getSaleItemList();
		for(SaleItem saleItem : saleItemList){
			saleItemDao.create(saleItem);
		}
			
		return sale;
	}


	

}
