package 软工仓库管理系统;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


public class ChanpingView extends JPanel{
	ViewInfo viewinfo1;
	JTable bg3Table;
	int combo;
	String ww;
	public ChanpingView() {
		viewinfo1=new ViewInfo();
		bg3Table=new JTable(viewinfo1);
		JScrollPane gd3=new JScrollPane(bg3Table);
		this.add(gd3);
		JLabel label=new JLabel("按：");
		String string[]={"编号","供货商","高于此价格","低于此价格"};
		final JComboBox<String> comboBox=new JComboBox<String>(string);
		final JTextField wriTextField=new JTextField(10);
		ww=wriTextField.getText();
		combo=comboBox.getSelectedIndex();	
		JButton exportButton=new JButton("导出数据");
		exportButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//导出数据到文本
				selectFromDb();
				JOptionPane.showMessageDialog(null, "导入成功");

			}
		});
		JButton lookButton=new JButton("查询");
		//对查询按钮加监听
		lookButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int combo=comboBox.getSelectedIndex();
				String ss=null;
				if (wriTextField.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "请输入你要查询的数据","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (combo==0) {
					ss="select * from productinfo where id='"+wriTextField.getText()+"'";
				}else if (combo==1) {
					ss="select * from productinfo where supplier='"+wriTextField.getText()+"'";
				}else if (combo==2) {
					//高于此价格
					int ii=Integer.parseInt(wriTextField.getText());
					ss="select * from productinfo where price>'"+ii+"'";
				}else if (combo==3) {
					//低于此价格
					int ii=Integer.parseInt(wriTextField.getText());
					ss="select * from productinfo where price<'"+ii+"'";
				}
				viewinfo1=new ViewInfo(ss);
				bg3Table.setModel(viewinfo1);
			}	
		});

		JPanel mb=new JPanel();
		mb.setLayout(new FlowLayout());
		mb.add(label);mb.add(comboBox);mb.add(wriTextField);mb.add(lookButton);mb.add(exportButton);
		this.add(mb,BorderLayout.SOUTH);
	}
	
	public void selectFromDb(){

		java.sql.Connection connection=null;
		java.sql.Statement statement=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://106.13.180.138/IWMS?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8";
			String userString="july";
			String passwordString="july";
			connection=DriverManager.getConnection(url, userString, passwordString);
			statement=connection.createStatement();
			String sql="select * from productinfo";
			ResultSet resultSet=statement.executeQuery(sql);
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("c.txt"),"UTF-8");
			BufferedWriter bw = new BufferedWriter(output);
		
			while (resultSet.next()) {
				String id=resultSet.getString(1);	
				String name=resultSet.getString(2);
				String price=resultSet.getString(3);
				
				
				bw.write("id="+id+"   "+"name="+name+"    "+"price="+price+"\n");
				
			}
			bw.close();
			output.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
