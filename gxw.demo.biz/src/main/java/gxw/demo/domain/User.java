package gxw.demo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private int age;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	
	private LineitemType lineitemType;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ApiModelProperty(value = "姓名", required = true)
	public String getName() {
		return name;
	}

	@ApiModelProperty(value = "姓名", required = true)
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public LineitemType getLineitemType() {
		return lineitemType;
	}

	public void setLineitemType(LineitemType lineitemType) {
		this.lineitemType = lineitemType;
	}

	public User() {
	}

	public User(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public User(long id, String name, Date birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
}
