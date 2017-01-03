package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import logic.Board;


public interface BoardService {

	int boardCount(String column, String find);

	List<Board> list(Integer pageNum, int limit, String column, String find);

	void readCntAdd(Integer num);

	Board detail(Integer num);

	void write(Board board, HttpServletRequest request);

	void reply(Board board, HttpServletRequest request);

	void update(Board board, HttpServletRequest request);

	String getPass(int num);

	void delete(int num);

}
