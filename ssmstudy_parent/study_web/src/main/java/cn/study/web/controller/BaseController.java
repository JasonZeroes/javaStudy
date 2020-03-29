package cn.study.web.controller;

import cn.study.basic.AjaxResult;
import cn.study.basic.PageList;
import cn.study.basic.query.BaseQuery;

import java.util.List;

public interface BaseController<T> {

	AjaxResult addOrUpdate(T t);


	AjaxResult del(Long id);


	T getByID(Long id);


	List<T> list();


	// PageList<T> query(BaseQuery query);  //query 对象确定不了
}
