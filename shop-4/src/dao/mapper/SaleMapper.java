package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.Sale;

public interface SaleMapper {
	
	@Select("select * from sale where userid=#{id}")
	List<Sale> list(String userId);
	
	@Select("select nvl(max(saleid), 0) from sale")
	int maxsaleid();
	
	@Insert("insert into sale(saleid, userid, updatetime) values(#{saleId}, #{user.userId}, #{updateTime})")
	void insert(Sale sale);
	
	
	

}
