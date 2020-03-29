package cn.study.web.controller;

import cn.study.basic.AjaxResult;
import cn.study.basic.PageList;
import cn.study.domain.Department;
import cn.study.query.DepartmentQuery;
import cn.study.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/department")
public class DepartmentController implements BaseController<Department> {

	@Autowired
	private IDepartmentService departmentService;


	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	@Override
	public AjaxResult addOrUpdate(@RequestBody Department department) {
		try {
			if (department.getId() != null) {
				departmentService.update(department);
			} else {
				departmentService.add(department);
			}
			return AjaxResult.me();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.me().setSuccess(false).setMessage("添加失败" + e.getMessage());
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@Override
	public AjaxResult del(@PathVariable("id") Long id) {
		try {
			departmentService.del(id);
			return AjaxResult.me();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.me().setSuccess(false).setMessage("删除失败" + e.getMessage());
		}
	}


	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	@Override
	public Department getByID(@PathVariable("id") Long id) {
		return departmentService.getById(id);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	@ResponseBody
	@Override
	public List<Department> list() {
		return departmentService.getAll();
	}


	// 不要在baseController添加分页方法,因为query确定不了
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public PageList<Department> query(@RequestBody DepartmentQuery query) {
		return departmentService.query(query);
	}

}
