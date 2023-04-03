package vn.projectLTW.Dao;

import vn.projectLTW.model.UserGG;
import vn.projectLTW.model.Users;

import java.util.List;

public interface IUserGGDao {
    List<Users> findAll(); // hàm lấy toàn bộ User

    Users findOne(int id);
    Users findOne(String userName);// hàm lấy 1 đối tượng User theo ID

    void insert(UserGG user); // hàm này thêm dữ liệu mới cho User

    void delete(int id);	//hàm này xóa 1 đối tượng User


}
