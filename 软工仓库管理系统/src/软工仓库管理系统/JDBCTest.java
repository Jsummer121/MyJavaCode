package 软工仓库管理系统;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCTest {

	public static void main(String[] args) throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. 通过DriverManager获取数据库连接
		String url = "jdbc:mysql://106.13.180.138/IWMS?serverTimezone=UTC&useSSL=false";
		String user = "july";
		String password = "july";
		try {
			Connection coon = DriverManager.getConnection(url, user, password);
			Statement stmt = coon.createStatement();
			String sql = "select * from mima";
			ResultSet re = stmt.executeQuery(sql);
			while(re.next()) {
				String name = re.getString("user");
				String psw = re.getString("password");
				System.out.println(name+"+++"+psw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
