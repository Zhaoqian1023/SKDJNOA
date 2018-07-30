package com.dao;

import java.util.List;

public interface Dao {

	public boolean add(Object obj);
	public boolean del(Object obj);
	public Object get(int id);
	public boolean update(Object obj);
	@SuppressWarnings("rawtypes")
	public List query(String hql);
	@SuppressWarnings("rawtypes")
	public List getPage(int page,int count);
	@SuppressWarnings("rawtypes")
	public List getBySQL(String SQL);

}
