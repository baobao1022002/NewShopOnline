package vn.projectLTW.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserFb implements Serializable {
    private int userId;
    private String fullName;
    private String images;
    private int roleId;

    private UserRoles roles;


    public UserFb() {

    }

    public UserFb(int userId, String fullName, String images, int roleId, UserRoles roles) {
        this.userId = userId;
        this.fullName = fullName;
        this.images = images;
        this.roleId = roleId;
        this.roles = roles;
    }

    public UserFb(String fullName, String images, int roleId, UserRoles roles) {
        this.fullName = fullName;
        this.images = images;
        this.roleId = roleId;
        this.roles = roles;
    }


    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getImages() {
        return images;
    }

    public int getRoleId() {
        return roleId;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }
}





