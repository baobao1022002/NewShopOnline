package vn.projectLTW.service.Impl;

import vn.projectLTW.Dao.IUserRoleDao;
import vn.projectLTW.Dao.Impl.UserRoleDaoImpl;
import vn.projectLTW.model.UserRoles;
import vn.projectLTW.service.IUserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements IUserRoleService{
	//Truy xuất các hàm Interface của Dao để thực thi các hàm  trong impl userRoleDao 	
	IUserRoleDao userRoleDao = new UserRoleDaoImpl();
	
	@Override
	public List<UserRoles> findAll() {
		// TODO Auto-generated method stub
		return userRoleDao.findAll();
	}

	@Override
	public UserRoles findOne(int id) {
		// TODO Auto-generated method stub
		return userRoleDao.findOne(id);
	}

	@Override
	public void insert(UserRoles role) {
		// TODO Auto-generated method stub
		userRoleDao.insert(role);
	}

	@Override
	public void update(UserRoles role) {
		// TODO Auto-generated method stub
		UserRoles oldRole = userRoleDao.findOne(role.getRoleId());
		oldRole.setRoleName(role.getRoleName());
		
		
		userRoleDao.update(oldRole);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRoleDao.delete(id);
	}

}
