package vn.projectLTW.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserGG implements Serializable {
    private int userGGId;
    private String userName;
    private String email;
    private int roleId;

    private int sellerId;
    private UserRoles roles;
    private Seller sellers;

    public UserGG() {}

    public UserGG(int userGGId, String userName, String email, int roleId, int sellerId, UserRoles roles, Seller sellers) {
        this.userGGId = userGGId;
        this.userName = userName;
        this.email = email;
        this.roleId = roleId;
        this.sellerId = sellerId;
        this.roles = roles;
        this.sellers = sellers;
    }

    public UserGG(int userGGId, String userName, String email, int roleId) {
        this.userGGId = userGGId;
        this.userName = userName;
        this.email = email;
        this.roleId = roleId;
    }

    public UserGG(int userGGId, String userName, String email) {
        this.userGGId = userGGId;
        this.userName = userName;
        this.email = email;
    }

    public UserGG(String userName, String email, int roleId) {
        this.userName = userName;
        this.email = email;
        this.roleId = roleId;
    }

    public int getUserGGId() {
        return userGGId;
    }

    public void setUserGGId(int userGGId) {
        this.userGGId = userGGId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }

    public Seller getSellers() {
        return sellers;
    }

    public void setSellers(Seller sellers) {
        this.sellers = sellers;
    }
}





