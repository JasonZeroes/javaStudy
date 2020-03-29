package cn.study.web.controller;


import cn.study.basic.AjaxResult;
import cn.study.basic.PageList;
import cn.study.basic.query.BaseQuery;
import cn.study.domain.Employee;
import cn.study.query.EmployeeQuery;
import cn.study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	// 添加租户员工
	@ResponseBody
	@RequestMapping(value = "/tenant", method = RequestMethod.PUT)
	public AjaxResult addTenantEmployee(@RequestBody Employee employee){
		try{
			employeeService.addTenantEmployee(employee);
			return AjaxResult.me();
		}catch (Exception e){
			e.printStackTrace();
			return AjaxResult.me().setMessage("入住失败" + e.getMessage()).setSuccess(false);
		}

	}


	// 创建员工接口 参数,返回值
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	@ResponseBody
	public AjaxResult add(@RequestBody Employee employee) {
		System.out.println("添加成功!");
		return AjaxResult.me();
	}

	// 删除员工接口 参数,返回值
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public AjaxResult del(@PathVariable("id") Long id) {
		System.out.println("删除成功!" + id);
		return AjaxResult.me();
	}

	// 更新员工接口 参数,返回值
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult update(@PathVariable("id") Long id, @RequestBody Employee employee) {
		System.out.println("修改成功!" + id + employee);
		return AjaxResult.me();
	}

	// 查询一个员工
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getByID(@PathVariable("id") Long id) {
		Employee employee = new Employee("zs");
		employee.setId(id);
		return employee;
	}

	// 查询所有
	@ResponseBody
	@RequestMapping(method = RequestMethod.PATCH)
	public List<Employee> list() {
		return employeeService.getAll();
	}

	// 高级查询

	public PageList<Employee> query(BaseQuery query) {
		return employeeService.query(query);
	}
}
