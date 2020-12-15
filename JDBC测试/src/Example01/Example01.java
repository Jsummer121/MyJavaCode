package Example01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC使用步骤
 * 1. 加载并注册数据库驱动
 * 2. 通过DriverManager获取数据库连接
 * 3. 通过Connection对象获取Statement对象
 * 4. 使用Statement执行SQL语句
 * 5. 操作ResultSet结果集
 * 6. 关闭连接，释放资源
 */

public class Example01 {
	public static void main(String[] args) throws SQLException {
		Connection coon = null;
		Statement stmt = null;
		ResultSet re = null;
		try {
			// 1. 加载并注册数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 通过DriverManager获取数据库连接
			String url = "dbc:mysql://106.13.180.138/IWMS?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "summer";
			coon = DriverManager.getConnection(url, user, password);
			// 3.通过Connection对象获取Statement对象
			stmt = coon.createStatement();
			
			//4. 使用Statement执行SQL语句
			String sql = "select * from user";
			re = stmt.executeQuery(sql);
			
			// 操作ResultSet结果集
			System.out.println("id  |  name  |  password  |  email  | birthday");
			while(re.next()) {
				//通过列名获取指定字段的值
				int id = re.getInt("id");
				String name = re.getString("name");
				String psd = re.getString("password");
				String email = re.getString("email");
				Date birthday = re.getDate("birthday");
				System.out.println(id + " | " + name + " | " + psd + " | " + email + " | " + birthday);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 关闭连接，释放资源
			if(coon != null) {
				coon.close();
				coon = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(re != null) {
				re.close();
				re = null;
			}
		}

	}

}
