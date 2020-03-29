package cn.study.domain;

import cn.study.basic.domain.BaseDomain;

import java.util.Date;

public class Tenant extends BaseDomain {
	private String companyName;
	private String companyNum;
	private Date registerTime;
	private Integer state;
	private String address;
	private String logo;

	public Tenant() {
	}

	public Tenant(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Tenant{" +
				"companyName='" + companyName + '\'' +
				", companyNum='" + companyNum + '\'' +
				", registerTime=" + registerTime +
				", state=" + state +
				", address='" + address + '\'' +
				", logo='" + logo + '\'' +
				'}';
	}
}
