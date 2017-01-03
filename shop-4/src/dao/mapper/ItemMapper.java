package dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Item;

public interface ItemMapper {
	
	@Select("select nvl(max(id),0) from item")
	int itemMaxId();
	
	@Insert("insert into item (id, name, price, description, pictureurl) values(#{id}, #{name}, #{price}, #{description}, #{pictureUrl})")
	void create(Item item);
	
	@Update("update item set name=#{name}, price=#{price}, description=#{description}, pictureurl=#{pictureUrl} where id=#{id}")
	void update(Item item);
	
	@Delete("delete from item where id=#{id}")
	void delete(Integer id);

}