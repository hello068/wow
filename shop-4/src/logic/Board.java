package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Board {
	
	private int num;
	
	@NotEmpty(message="제목을 입력하세요.")
	private String subject;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@NotEmpty(message="글쓴이를 입력하세요.")
	private String name;
	@NotEmpty(message="비밀번호를 입력하세요.")
	private String pass;
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	private int readCnt;
	private String fileUrl;
	private Date regDate;
	private int ref;
	private int refLevel;
	private int refStep;
	private MultipartFile file1;
	public String getDateFormat(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sf.format(regDate);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRefLevel() {
		return refLevel;
	}
	public void setRefLevel(int refLevel) {
		this.refLevel = refLevel;
	}
	public int getRefStep() {
		return refStep;
	}
	public void setRefStep(int refStep) {
		this.refStep = refStep;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", subject=" + subject + ", name=" + name + ", pass=" + pass + ", content="
				+ content + ", readCnt=" + readCnt + ", fileUrl=" + fileUrl + ", regDate=" + regDate + ", ref=" + ref
				+ ", refLevel=" + refLevel + ", refStep=" + refStep + ", file1=" + file1 + "]";
	}
	
	
	
	

}
