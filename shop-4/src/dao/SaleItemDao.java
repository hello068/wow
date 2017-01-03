package dao;

import java.util.List;

import logic.SaleItem;

public interface SaleItemDao {

	List<SaleItem> list(Integer saleId);

	void create(SaleItem saleItem);

}
