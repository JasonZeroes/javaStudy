package cn.study.basic.mapper;

import cn.study.basic.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T> {
	/**
	 * 保存一个对象
	 */
	void save(T t);

	/**
	 * 移除一个对象
	 */
	void remove(Serializable id);

	/**
	 * 更新一个对象
	 */

	void update(T t);

	/**
	 * 通过id 加载一个对象
	 */

	T loadById(Serializable id);

	/**
	 *加载所有对象
	 */

	List<T> loadAll();

	/**
	 * 查询分页数据
	 * @param query
	 * @return
	 */

	Long queryCount(BaseQuery query);

	/**
	 * 查询当前页数据
	 * @param query
	 * @return
	 */
	List<T> queryData(BaseQuery query);
}

