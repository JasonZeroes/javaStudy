package cn.study.service.impl;

import cn.study.basic.PageList;
import cn.study.domain.Employee;
import cn.study.query.EmployeeQuery;
import cn.study.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceTest extends BaseTest{
	@Autowired
	private IEmployeeService employeeService;

	@Test
	public void test() throws Exception{
		for (Employee employee : employeeService.getAll()) {
			System.out.println(employee);
		}
	}

}
