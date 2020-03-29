package cn.study.service.impl;

import cn.study.basic.service.impl.BaseServiceImpl;
import cn.study.domain.Employee;
import cn.study.domain.Tenant;
import cn.study.mapper.EmployeeMapper;
import cn.study.mapper.TenantMapper;
import cn.study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService {

	@Autowired
	private TenantMapper tenantMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Transactional
	@Override
	public void addTenantEmployee(Employee employee) {
		Tenant tenant = employee.getTenant();
		// 添加注册时间
		tenant.setRegisterTime(new Date());

		// 设置添加状态
		tenant.setState(0);

		//添加租户 返回租户id tenantMapper添加tenant会自动添加id,然后对象就自己携带id了
		tenantMapper.save(tenant);

		// 把id设置给员工
		employee.setTenant(tenant);

		//租户id这只给员工,然后保存员工
		employee.setRealName(employee.getUsername());

		employeeMapper.save(employee);
	}
}
