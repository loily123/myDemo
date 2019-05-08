package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	public boolean queryByUserName(String userName, String password) {
		// TODO Auto-generated method stub
		return adminDao.queryByName(userName, password);
	}

}
