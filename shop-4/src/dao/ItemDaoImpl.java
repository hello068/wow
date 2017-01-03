package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ItemMapper;
import logic.Item;

@Repository // 객체화 + 기능(db 관련 객체)
public class ItemDaoImpl implements ItemDao{
	
	/*
	 * common.xml에서 설정 된 sqlSessionTemplate 객체가 주입
	 * 	sqlSessionTemplate
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="dao.mapper.ItemMapper.";
	
	@Override
	public List<Item> findAll() {
		return sqlSession.selectList(NS+"getItem");
	}

	@Override
	public Item itemById(Integer id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		return sqlSession.selectOne(NS+"getItem", map);
	}

	@Override
	public void create(Item item) {
		int i = sqlSession.getMapper(ItemMapper.class).itemMaxId();
		item.setId(++i);
		sqlSession.getMapper(ItemMapper.class).create(item);
		
	}

	@Override
	public void update(Item item) {
		
		sqlSession.getMapper(ItemMapper.class).update(item);
	}

	@Override
	public void delete(Integer id) {
		
		sqlSession.getMapper(ItemMapper.class).delete(id);
	}

}



















