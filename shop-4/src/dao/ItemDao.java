package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {

	List<Item> findAll();

	Item itemById(Integer id);

	void create(Item item);

	void update(Item item);

	void delete(Integer id);

}
