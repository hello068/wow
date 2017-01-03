package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.SaleMapper;
import logic.Sale;

@Repository
public class SaleDaoImpl implements SaleDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="dao.mapper.SaleMapper.";
	
	@Override
	public List<Sale> list(String userId) {
		
		return sqlSession.getMapper(SaleMapper.class).list(userId);
	}

	@Override
	public void createSale(Sale sale) {
		sqlSession.getMapper(SaleMapper.class).insert(sale);
	}

	@Override
	public Integer getMaxSaleId() {
		
		int i = sqlSession.getMapper(SaleMapper.class).maxsaleid();
		return i+1;
	}
	

}
