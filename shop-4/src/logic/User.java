package logic;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	@Size(min=3, max=10, message="아이디는 3자 이상, 10자 이하로 입력하세요.")
	private String userId;
	@Size(min=3, max=12, message="비밀번호는 3자 이상, 12자 이하로 입력하세요.")
	private String password;
	private String userName;
	private String phoneNo;
	private String postCode;
	private String address;
	private String Email;
	@Past(message="생일은 과거 날짜만 가능합니다.")
	private Date birthDay;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userName=" + userName + ", phoneNo=" + phoneNo
				+ ", postCode=" + postCode + ", address=" + address + ", Email=" + Email + ", birthDay=" + birthDay
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
