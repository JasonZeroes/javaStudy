package cn.study.basic.service;

import cn.study.basic.PageList;
import cn.study.basic.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
	/**
	 * 添加一个对象
	 */
	void add(T t);

	/**
	 * 删除一个对象
	 */
	void del(Serializable id);

	/**
	 * 修改一个对象
	 */

	void update(T t);

	/**
	 * 通过id 获取一个对象
	 */

	T getById(Serializable id);

	/**
	 *获取所有对象
	 */

	List<T> getAll();

	/**
	 * 分页列表 + 高级查询
	 * @param query
	 * @return
	 */

	PageList<T> query(BaseQuery query);
}
