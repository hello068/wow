package dao;

import java.util.List;

import logic.User;

public interface UserDao {
	List<User> getUser();
	
	List<User> getUser(String[] idchks);

	User getUser(String userId, String password);

	void create(User user);


	
}
