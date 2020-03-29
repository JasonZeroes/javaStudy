package cn.study.basic.service.impl;

import cn.study.basic.PageList;
import cn.study.basic.mapper.BaseMapper;
import cn.study.basic.query.BaseQuery;
import cn.study.basic.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

//这里不需要添加@Service,子类继承时添加
//类级别的事务为读事务,在增删改上添加事务
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T> implements IBaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;

	// @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Transactional
	@Override
	public void add(T t) {
		baseMapper.save(t);
	}

	@Transactional
	@Override
	public void del(Serializable id) {
		baseMapper.remove(id);
	}

	@Transactional
	@Override
	public void update(T t) {
		baseMapper.update(t);
	}

	@Override
	public T getById(Serializable id) {
		return baseMapper.loadById(id);
	}

	@Override
	public List<T> getAll() {
		return baseMapper.loadAll();
	}

	@Override
	public PageList<T> query(BaseQuery query) {
		// 通过baseMapper查询总数
		Long total = baseMapper.queryCount(query);
		if (total == 0) {
			return new PageList<>();
		}
		// 查询当前页数据
		List<T> rows = baseMapper.queryData(query);
		return new PageList<>(total, rows);
	}
}
