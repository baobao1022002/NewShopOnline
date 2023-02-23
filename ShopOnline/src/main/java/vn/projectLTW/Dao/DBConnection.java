package vn.projectLTW.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {
	private final static String serverName="localhost";//., 127.0.0.1
	private final static String dbName="shoponline" ;
	private final static String  portNumber="3306";//8391  ,1433
	private final static String  instance="";//SQL2019,MSQLSERVER
	private final String  user="root";
	private final String  password="Quamon@10diem";


	public Connection getConnection() throws Exception{
		Connection connection=null;
		String connectionURL="jdbc:mysql://"+serverName+":"+portNumber+instance+"/"+dbName;
		 if(instance==null || instance.trim().isEmpty())
			 connectionURL="jdbc:mysql://"+serverName+":"+portNumber+instance+"/"+dbName;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(connectionURL,user,password);
		System.out.println("Ket noi co so du lieu thanh cong");

		return connection;
	}






	public static void main(String[] args) throws SQLException{
		try {
			System.out.println(new DBConnection().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
