/**  
 * @Title: ClassNameServie.java
 * @Package com.service
 * @Description: TODO
 * @author Victor
 * @date 2017年7月23日
 */
package com.service;

import com.dao.Dao;
import com.dao.impl.ClassNameDao;
import com.po.ClassName;

/**
 * ClassName: ClassNameServie 
 * @Description: TODO
 * @author Victor
 * @date 2017年7月23日
 */
public class ClassNameServie {
	
	public static ClassName getClassNameByCid(String cid){
		ClassName className = null;
		Dao classNameDao = new ClassNameDao();
		className = (ClassName) classNameDao.get(Integer.parseInt(cid));
		return className;
	}
	public static ClassName getClassNameByCname(String cname){
		ClassName className = null;
		ClassNameDao classNameDao = new ClassNameDao();
		className = (ClassName) classNameDao.get(cname);
		return className;
	}

}
