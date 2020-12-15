package Example03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * ResultSet的使用
 */
public class Example03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//得到与数据库连接的对象
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "summer";
		Connection coon = DriverManager.getConnection(url, user, password);
		
		//得到用来执行SQL语句的对象
		//String sql = "select * from users";
		String sql = "select * from users where name='lixi'";
		PreparedStatement ppStmt = coon.prepareStatement(sql);
		
		//执行SQL语句
		ResultSet rs = ppStmt.executeQuery();
		
		//查询结果集ResultSet
//		//将指针定位到结果集第二行数据
//		rs.absolute(2);
//		System.out.println("第二条数据的name值："+rs.getString("name"));
//		//将指针定位到结果集中的第一行数据的前面
//		rs.beforeFirst();
//		rs.next();//将指针向后移动
//		System.out.println("第一条数据的name值："+rs.getString("name"));
//		//将指针定位到结果集中的最后一条数据之后
//		rs.afterLast();
//		rs.previous();//将指针向前移动一条
//		System.out.println("最后一条数据的name的值："+rs.getString("name"));
		if(rs.next()) {
			System.out.println("最后一条数据的name的值："+rs.getString("name"));
		}else {
			System.out.println("null");
		}
	}

}
