package cn.study.domain;

import java.util.ArrayList;
import java.util.List;

public class Department{
	private Long id;
	private String sn;
	private String name;
	private Employee manager;
	private Department parent;
	private Tenant tenant;
	private List<Department> children = new ArrayList<>();
	private String dirPath;
	private Integer state;


	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}

	public String getDirPath() {
		return dirPath;
	}

	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", sn='" + sn + '\'' +
				", name='" + name + '\'' +
				", dirPath='" + dirPath + '\'' +
				", state=" + state +
				'}';
	}
}
