package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.UserMapper;
import logic.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.UserMapper.";
	
	@Override
	public User getUser(String userId, String password) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("userId", userId);
		param.put("password", password);
		return sqlSession.selectOne(NS+"getUser", param);
	}

	@Override
	public void create(User user) {
		sqlSession.getMapper(UserMapper.class).create(user);
	}

	@Override
	public List<User> getUser() {
		return sqlSession.selectList(NS+"getUser");
	}

	@Override
	public List<User> getUser(String[] idchks) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idchks", idchks);
		
		return sqlSession.selectList(NS+"getUser", map);
	}
	

}