package logic;

import java.util.List;



public interface ShopService {

	Long calculateTotalAmount(List<ItemSet> itemList);

	User getUserByIdPw(User user);

	List<Sale> saleList(String userId);

	List<SaleItem> saleItemList(Integer saleId);

	void createUser(User user);

	User getUserById(String id);

	List<User> getUser();

	List<User> getUser(String[] idchks);

	Sale checkEnd(User loginUser, Cart cart);

}
