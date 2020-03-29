package cn.study.service;

import cn.study.basic.service.IBaseService;
import cn.study.domain.Employee;

public interface IEmployeeService extends IBaseService<Employee> {
	/**
	 * 添加租户员工入住
	 * @param employee
	 */
	void addTenantEmployee(Employee employee);
}
