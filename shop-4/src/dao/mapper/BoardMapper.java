package dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;

public interface BoardMapper {

	@Update("update board set readcnt=#{readcnt}+1 where num=#{num}")
	void readcntadd(Integer num);

	// 아래 *로 안 하는 이유가 file1의 alias 처리 때문에. 그냥 꺼내면 이름이 안 맞음.
	@Select("select num, name, pass, subject, content, readcnt, file1 fileurl, regdate, ref, reflevel, refstep from board where num=#{num}")
	Board detail(Integer num);

	// 아래 11 개의 컬럼
	@Insert("insert into board(num, name, pass, subject, content, readcnt, file1, regdate, ref, reflevel, refstep)"
			+ " values(#{num}, #{name}, #{pass}, #{subject}, #{content}, #{readCnt}, #{fileUrl}, sysdate, #{ref}, #{refLevel}, #{refStep})")
	void insert(Board board);

	@Select("select nvl(max(num), 0) from board")
	int maxnum();

	@Update("update board set refstep = refstep + 1 where ref=#{ref} and refstep>#{refStep}")
	void refstepadd(Board board);

	@Update("update board set content=#{content}, subject=#{subject}, file1=#{fileUrl}, name=#{name} where num=#{num}")
	void update(Board board);

	@Select("select pass from board where num=#{num}")
	String getpass(int num);

	
	@Delete("delete from board where num=#{num}")
	void delete(int num);
	

}
