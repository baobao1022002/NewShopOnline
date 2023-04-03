package vn.projectLTW.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Users implements Serializable{
	private int userId;
	private String userName;
	private String email;
	private String fullName;
	private String passWord;
	private String images;
	private String phone;
	private int status;
	private String code;
	private int roleId;
	private int sellerId;
	private UserRoles roles;
	private Seller sellers;
	
	

	
	public Users() {
		super();
	}



	public Users(int userId, String userName, String email, String fullName, String passWord, String images,
			String phone, int status, String code, int roleId, int sellerId, UserRoles roles, Seller sellers) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
		this.passWord = passWord;
		this.images = images;
		this.phone = phone;
		this.status = status;
		this.code = code;
		this.roleId = roleId;
		this.sellerId = sellerId;
		this.roles = roles;
		this.sellers = sellers;
	}



	public Users(String userName, String email, String fullName, String passWord, int status, int roleId) {
		super();
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
		this.passWord = passWord;
		this.status = status;
		this.roleId = roleId;
	}


	public Users(String email,String userName,  String fullName, String passWord, int status, int roleId, String code) {
		super();
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
		this.passWord = passWord;
		this.status = status;
		this.code = code;
		this.roleId = roleId;
	}





	public Users(String userName, String email, String fullName, String code) {
		super();
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
		this.code = code;
	}



	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public Seller getSellers() {
		return sellers;
	}

	public void setSellers(Seller sellers) {
		this.sellers = sellers;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public UserRoles getRoles() {
		return roles;
	}

	public void setRoles(UserRoles roles) {
		this.roles = roles;
	}
	
	
	
}
