package dao;

import java.util.List;

import logic.Board;

public interface BoardDao {

	int countAll(String column, String find);
	List<Board> list(Integer pageNum, int limit, String column, String find);
	void readCntAdd(Integer num);
	Board detail(Integer num);
	void insert(Board board);
	int getMaxNum();
	void refStepAdd(Board board);
	void update(Board board);
	String getPass(int num);
	void delete(int num);

}
