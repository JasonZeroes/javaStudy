package cn.study.service.impl;

import cn.study.domain.Department;
import cn.study.domain.Tenant;
import cn.study.service.IDepartmentService;
import cn.study.service.ITenantService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TenantServiceTest extends BaseTest{
	@Autowired
	private ITenantService tenantService;

	@Test
	public void test() throws Exception{
		for (Tenant tenant : tenantService.getAll()) {
			System.out.println(tenant);
		}
	}

}
