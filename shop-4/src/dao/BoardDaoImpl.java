package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.BoardMapper;
import logic.Board;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "dao.mapper.BoardMapper.";
	
	@Override
	public int countAll(String column, String find) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("column", column);
		param.put("find", find);
		return sqlSession.selectOne(NS+"count");
	}

	@Override
	public List<Board> list(Integer pageNum, int limit, String column, String find) {
		
		int startrow = (pageNum - 1) * limit + 1;
		int endrow = startrow + limit - 1;
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("startrow", startrow);
		param.put("endrow", endrow);
		param.put("column", column);
		param.put("find", find);
		return sqlSession.selectList(NS+"list", param);
	}

	@Override
	public void readCntAdd(Integer num) {
		sqlSession.getMapper(BoardMapper.class).readcntadd(num);
	}

	@Override
	public Board detail(Integer num) {
		return sqlSession.getMapper(BoardMapper.class).detail(num);
	}

	@Override
	public void insert(Board board) {
		sqlSession.getMapper(BoardMapper.class).insert(board);
	}

	@Override
	public int getMaxNum() {
		return sqlSession.getMapper(BoardMapper.class).maxnum();
	}

	@Override
	public void refStepAdd(Board board) {
		sqlSession.getMapper(BoardMapper.class).refstepadd(board);
	}

	@Override
	public void update(Board board) {
		sqlSession.getMapper(BoardMapper.class).update(board);
		
	}

	@Override
	public String getPass(int num) {
		return sqlSession.getMapper(BoardMapper.class).getpass(num);
	}

	@Override
	public void delete(int num) {
		sqlSession.getMapper(BoardMapper.class).delete(num);
	}
	

}
