package cn.study.service.impl;

import cn.study.basic.PageList;
import cn.study.domain.Department;
import cn.study.query.DepartmentQuery;
import cn.study.service.IDepartmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceTest extends BaseTest{
	@Autowired
	private IDepartmentService departmentService;

	@Test
	public void test() throws Exception{
		for (Department department : departmentService.getAll()) {
			System.out.println(department);
		}
	}

	@Test
	public void testPage() throws Exception{
		DepartmentQuery query = new DepartmentQuery();
		PageList<Department> pageList = departmentService.query(query);
		for (Department row : pageList.getRows()) {
			System.out.println(row);
		}
	}

}
