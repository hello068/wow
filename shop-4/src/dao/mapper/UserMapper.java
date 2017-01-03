package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import logic.User;

public interface UserMapper {
	
	@Insert("insert into useraccount(userid, password, username, postcode, phoneNo, address, email, birthDay) values(#{userId}, #{password}, #{userName}, #{postCode}, #{phoneNo}, #{address}, #{email}, #{birthDay})")
	void create(User user);
	
}
