package cn.study.mapper;


import cn.study.basic.mapper.BaseMapper;
import cn.study.domain.Employee;


/**
 * 通过继承BaseMapper,拥有了基础的crud,还可以扩展自己
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
}
