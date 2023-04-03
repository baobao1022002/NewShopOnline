package vn.projectLTW.model;

import java.io.Serializable;

public class UserRoles implements Serializable{
	private int roleId;
	private String roleName;
	public UserRoles() {
		super();
	}
	public UserRoles(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
