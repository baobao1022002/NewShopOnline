package vn.projectLTW.Dao.Impl;

import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.ILogDao;
import vn.projectLTW.model.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogDaoImpl implements ILogDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public void insert(Log log) {
        String sql = "INSERT INTO log(level,userName,src,content,createAt,status)"
                + "VALUES(?,?,?,?,NOW(),?)";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, log.getLevelWithName());
            ps.setString(2, log.getUserName());
            ps.setString(3, log.getSrc());
            ps.setString(4, log.getContent());
            ps.setInt(5, log.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
