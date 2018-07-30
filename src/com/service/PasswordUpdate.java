package com.service;

import com.dao.Dao;
import com.dao.impl.ManagerDao;
import com.dao.impl.UsersDao;
import com.po.Management;
import com.po.Users;
import com.util.MD5Util;

public class PasswordUpdate {
	public static boolean passwordUpdate(Users u) {
		if(u == null){
			return false;
		}
		String newUpwd = MD5Util.getMD5(u.getPassWord());
		u.setPassWord(newUpwd);
		Dao uDao = new UsersDao();
		if (uDao.update(u)) {
			return true;
		}
		return false;
	}
	public static boolean passwordUpdateManager(Management m) {

		String newUpwd = MD5Util.getMD5(m.getPassWord());
		m.setPassWord(newUpwd);
		Dao mDao = new ManagerDao();
		if (mDao.update(m)) {
			return true;
		}
		return false;
	}
	
	
}
