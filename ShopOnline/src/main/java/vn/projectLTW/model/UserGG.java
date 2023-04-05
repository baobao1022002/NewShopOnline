package vn.projectLTW.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserGG implements Serializable {
    private int id;
    private String userGGId;
    private String email;
    private int roleId;
    private int status;
    private int sellerId;
    private UserRoles roles;
    private Seller sellers;

    public UserGG() {}

    public UserGG(int id, String userGGId, String email, int roleId,int status, int sellerId, UserRoles roles, Seller sellers) {
        this.id = id;
        this.userGGId = userGGId;
        this.email = email;
        this.roleId = roleId;
        this.status=status;
        this.sellerId = sellerId;
        this.roles = roles;
        this.sellers = sellers;
    }

    public UserGG(int id, String userGGId, String email, int roleId,int status) {
        this.userGGId = userGGId;
        this.id = id;
        this.email = email;
        this.roleId = roleId;
        this.status=status;
    }

    public UserGG(int id, String userGGId, String email,int status) {
        this.userGGId = userGGId;
        this.id = id;
        this.email = email;
        this.status=status;
    }
    public UserGG(String userGGId, String email) {
        this.userGGId = userGGId;
        this.email = email;
    }

    public UserGG(String userGGId, String email, int roleId) {
        this.userGGId = userGGId;
        this.email = email;
        this.roleId = roleId;
    }

    public String getUserGGId() {
        return userGGId;
    }

    public void setUserGGId(String userGGId) {
        this.userGGId = userGGId;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSellers(Seller sellers) {
        this.sellers = sellers;
    }
}





