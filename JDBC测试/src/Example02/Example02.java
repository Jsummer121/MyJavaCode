package Example02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC使用步骤
 * 1. 加载并注册数据库驱动
 * 2. 通过DriverManager获取数据库连接
 * 3. 通过Connection对象获取Statement对象。指定要执行的SQL语句
 * 4. 使用PreparedStatement执行SQL语句
 * 5. 操作ResultSet结果集
 * 6. 关闭连接，释放资源
 */
public class Example02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// 1. 加载并注册数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 通过DriverManager获取数据库连接
			String url = "jdbc:mysql://localhost/jdbc?serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "summer";
			Connection coon = DriverManager.getConnection(url, user, password);
			
			// 3. 通过Connection对象获取Statement对象。指定要执行的SQL语句
			String sql = "INSERT INTO users(id,name,password,email,birthday) VALUE(?,?,?,?,?)";
			PreparedStatement preStmt = coon.prepareStatement(sql);
			//为sql语句中的参数进行赋值
			preStmt.setInt(1, 4);
			preStmt.setString(2, "zhangsan");
			preStmt.setString(3,"123456");
			preStmt.setString(4, "zhangsan@sina.com");
			preStmt.setString(5, "2000-01-20");
			
			// 4. 使用PreparedStatement执行SQL语句
			int count = preStmt.executeUpdate();
			System.out.println("数据改变了"+count+"条。");
			
			// 6.关闭连接，释放资源
			coon.close();
			preStmt.close();
			
	}
}
