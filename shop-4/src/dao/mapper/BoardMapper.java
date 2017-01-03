package dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;

public interface BoardMapper {

	@Update("update board set readcnt=#{readcnt}+1 where num=#{num}")
	void readcntadd(Integer num);

	// �Ʒ� *�� �� �ϴ� ������ file1�� alias ó�� ������. �׳� ������ �̸��� �� ����.
	@Select("select num, name, pass, subject, content, readcnt, file1 fileurl, regdate, ref, reflevel, refstep from board where num=#{num}")
	Board detail(Integer num);

	// �Ʒ� 11 ���� �÷�
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
