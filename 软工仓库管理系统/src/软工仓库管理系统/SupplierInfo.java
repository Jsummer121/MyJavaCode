package 软工仓库管理系统;
import java.sql.*;

import javax.swing.table.*;
import java.util.Vector;
public class SupplierInfo extends AbstractTableModel{
	Vector ziduan,jilu;
	PreparedStatement preparedStatement=null;
	Statement statement=null;
	ResultSet resultSet=null;
	Connection connection=null;
	@Override
	public int getColumnCount() {
		
		return this.ziduan.size();
	}
	public int getRowCount() {
		
		return this.jilu.size();
	}
	public Object getValueAt(int hang, int lie) {
		
		return ((Vector)this.jilu.get(hang)).get(lie);//返回记录的第x行数的第x列
	}
	
	public SupplierInfo()
	{
		this.sqlyj("select * from supplierinfo");
	}
	public SupplierInfo(String ss)
	{
		this.sqlyj(ss);
	}
	public String getColumnName(int e)
	{
		return (String)this.ziduan.get(e);
	}
	 public void sqlyj(String sql){
		 ziduan=new Vector();
		 ziduan.add("供应商");
		 ziduan.add("供应商品");
		 ziduan.add("价格");
		 ziduan.add("联系方式");
		 ziduan.add("供应商住址");
		 
		 
		 jilu=new Vector();
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://106.13.180.138/IWMS?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8&useUnicode=true&characterEncoding=utf8&useUnicode=true&characterEncoding=utf8";
				String user="july";
				String password="july";
				connection=DriverManager.getConnection(url, user, password);
				statement=connection.createStatement();
				preparedStatement=connection.prepareStatement(sql);
				  resultSet=preparedStatement.executeQuery();
				  
				  while(resultSet.next())
				  {
					  Vector hang=new Vector();
						hang.add(resultSet.getString(1));
						hang.add(resultSet.getString(2));
						hang.add(resultSet.getString(3));
						hang.add(resultSet.getString(4));
						hang.add(resultSet.getString(5));
						jilu.add(hang);
				  }
			} catch (Exception e){
				e.printStackTrace();
			}
		    finally
		    {
		    	try {
		    		if(resultSet!=null)
					{
						resultSet.close();
					}
		    		if(preparedStatement!=null)
					{
						preparedStatement.close();
					}
					if(connection!=null)
					{
						connection.close();
					}
					
				} catch (Exception e){
					e.printStackTrace();
				}
		    }
	 }
	
	
}
