package vn.projectLTW.service.Impl;

import java.util.List;

import vn.projectLTW.Dao.IUserDao;
import vn.projectLTW.Dao.Impl.UserDaoImpl;
import vn.projectLTW.model.UserGG;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	IUserDao userDao=new UserDaoImpl();
	
	@Override
	public List<Users> findAll() {
		return userDao.findAll();
	}

	@Override
	public Users findOne(int id) {
		return userDao.findOne(id);
	}

	@Override
	public UserGG findOneGG(int id) {
		return null;
	}

	@Override
	public void insert(Users user) {
		userDao.insert(user);
	}



	@Override
	public void update(Users user) {
		Users oldUser=userDao.findOne(user.getUserId());
		oldUser.setEmail(user.getEmail());
		oldUser.setFullName(user.getFullName());
		oldUser.setUserName(user.getUserName());
		oldUser.setPassWord(user.getPassWord());
		oldUser.setPhone(user.getPhone());
		oldUser.setRoles(user.getRoles());
		oldUser.setStatus(user.getStatus());
		oldUser.setImages(user.getImages());
		userDao.update(user);
		
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
		
	}

	@Override
	public boolean register(String email, String passWord, String userName, String fullName, String code) {
		if(userDao.checkExistEmail(email)) {
				return false;
		}
		if(userDao.checkExistUserName(userName)) {
			return false;
		}
		userDao.insertRegister(new Users(email,userName,fullName, passWord,0,3,code ));
		return true;
	}

	@Override
	public boolean registerGG(String email, String userName) {
		userDao.insertRegisterGG(new UserGG(email,userName,3));
		return true;
	}

	@Override
	public Users login(String userName, String passWord) {
		Users user=this.findOne(userName);
		if (user!=null && passWord.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public UserGG loginGG(int userGG_Id) {
		UserGG userGG=this.findOneGG(userGG_Id);
		if(userGG!=null ) {
			return userGG;
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUserName(String userName) {
		return userDao.checkExistUserName(userName);
	}

	@Override
	public Users findOne(String userName) {
		return userDao.findOne(userName);
	}

	@Override
	public void updateStatus(Users user) {
		userDao.updateStatus(user);
	}

}
