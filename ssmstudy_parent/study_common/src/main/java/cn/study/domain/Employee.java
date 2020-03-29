package cn.study.domain;
import cn.study.basic.domain.BaseDomain;

import java.util.Date;

public class Employee extends BaseDomain {
	private String username;
	private String realName;
	private String password;
	private String tel;
	private String email;
	private Department dept;
	private Tenant tenant;
	private Date inputTime = new Date();
	private Integer state;
	private Boolean type=false;

	public Employee() {
	}

	public Employee(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"username='" + username + '\'' +
				", realName='" + realName + '\'' +
				", passWord='" + password + '\'' +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", inputTime=" + inputTime +
				", state=" + state +
				'}';
	}
}
