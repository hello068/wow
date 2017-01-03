package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import logic.SaleItem;

public interface SaleItemMapper {
	
	@Select("select * from saleitem where saleid=#{saleId}")
	List<SaleItem> list(Integer saleId);
	
	@Insert("insert into saleitem(saleid, saleitemid, itemid, quantity, updatetime) values(#{sale.saleId}, #{saleItemId}, #{item.id}, #{quantity}, #{updateTime})")
	void insert(SaleItem saleItem);

}
