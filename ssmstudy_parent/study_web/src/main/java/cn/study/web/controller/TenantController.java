package cn.study.web.controller;

import cn.study.basic.AjaxResult;
import cn.study.basic.PageList;
import cn.study.basic.query.BaseQuery;
import cn.study.domain.Tenant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/tenant")
public class TenantController implements BaseController<Tenant>{
	@Override
	public AjaxResult addOrUpdate(Tenant tenant) {
		return null;
	}

	@Override
	public AjaxResult del(Long id) {
		return null;
	}

	@Override
	public Tenant getByID(Long id) {
		return null;
	}

	@Override
	public List<Tenant> list() {
		return null;
	}

	public PageList<Tenant> query(BaseQuery query) {
		return null;
	}
}
