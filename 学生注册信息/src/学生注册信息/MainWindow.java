package 学生注册信息;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainWindow implements ActionListener {
	JTextField stuNumber,number,name;
	JRadioButton boy,girl;
	JComboBox<String> province,city,ageBox;
	JButton findBtn,changeBtn,zhuceBtn;
	public MainWindow(){
		//创建主屏幕视图
		JFrame mainWin = new JFrame("学生注册信息");
		mainWin.setSize(550, 330);
		mainWin.setLocationRelativeTo(null);
		
		//设置头部窗口
		JPanel head = new JPanel();
		head.setLayout(new FlowLayout());
		JLabel stuNumberLabel = new JLabel("输入学号:    ");
		stuNumber = new JTextField(15);
		findBtn = new JButton("查询");
		head.add(stuNumberLabel);
		head.add(stuNumber);
		head.add(findBtn);
		mainWin.add(head,BorderLayout.NORTH);
		
		//设置中心部分窗口
		JPanel center = new JPanel();
		center.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.blue));//设置中心窗口的上下边框
		center.setLayout(null);//设定自定义布局
		JLabel numberLb = new JLabel("学号：");
		JLabel nameLb = new JLabel("姓名：");
		JLabel sexLb = new JLabel("性别：");
		JLabel ageLb = new JLabel("年龄：");
		JLabel placeLb = new JLabel("籍贯：");
		number = new JTextField(15);
		name = new JTextField(15);
		ButtonGroup sexgroup = new ButtonGroup();//性别按钮组对象
		boy = new JRadioButton("男");
		girl = new JRadioButton("女");
		sexgroup.add(boy);
		sexgroup.add(girl);
		ageBox = new JComboBox<String>();//年龄下拉列表框
		for (int i = 0; i < 120; i++) {
			String n = String.valueOf(i);
			ageBox.addItem(n);
		}
		province = new JComboBox<String>();//籍贯下拉列表框（山东、河北、河南省份）
		province.addItem("山东");
		province.addItem("河北");
		province.addItem("河南");
		JLabel shenLB = new JLabel("省");
		city = new JComboBox<String>();
		String[] shandong = {"济南市","青岛市","淄博市","枣庄市","东营市","烟台市","潍坊市","济宁市","泰安市","威海市","日照市","滨州市","德州市","聊城市","临沂市","菏泽市"};//各个省份所占有的市
		String[] hebei = {"石家庄市","唐山市","秦皇岛市","邯郸市","邢台市","保定市","张家口市","承德市","沧州市","廊坊市","衡水市"};
		String[] henan = {"郑州市","开封市","洛阳市","平顶山市","焦作市","鹤壁市","新乡市","安阳市","濮阳市","许昌市","漯河市","三门峡市","南阳市","商丘市","信阳市","周口市","驻马店市","济源市"};
		for(String x:shandong){
			city.addItem(x);
		}
		province.addActionListener(new ActionListener() {//为市下拉列表框添加事件
			@Override
			public void actionPerformed(ActionEvent e) {
				if(province.getSelectedItem().toString().equals("山东")) {
					city.removeAllItems();
					for(String x:shandong){
						city.addItem(x);
					}
				}else if(province.getSelectedItem().toString().equals("河北")) {
					city.removeAllItems();
					for(String x:hebei){
						city.addItem(x);
					}
				}else {
					city.removeAllItems();
					for(String x:henan){
						city.addItem(x);
					}
				}
			}
		});
		
		//设置各个组件的位置
		numberLb.setBounds(100, 20, 40, 20);
		nameLb.setBounds(100, 60, 40, 20);
		sexLb.setBounds(100, 100, 40, 20);
		ageLb.setBounds(100, 140, 40, 20);
		placeLb.setBounds(100, 180, 40, 20);
		number.setBounds(150, 20, 100, 20);
		name.setBounds(150, 60, 100, 20);
		girl.setBounds(150, 100, 50, 20);
		boy.setBounds(200, 100, 50, 20);
		ageBox.setBounds(150, 140, 100, 20);
		province.setBounds(150, 180, 70, 20);
		shenLB.setBounds(220, 180, 20, 20);
		city.setBounds(240, 180, 80, 20);
		center.add(numberLb);
		center.add(nameLb);
		center.add(sexLb);
		center.add(ageLb);
		center.add(placeLb);
		center.add(number);
		center.add(name);
		center.add(boy);
		center.add(girl);
		center.add(ageBox);
		center.add(province);
		center.add(shenLB);
		center.add(city);		
		center.setVisible(true);
		mainWin.add(center,BorderLayout.CENTER);
		
		//设置底部窗口
		JPanel button = new JPanel();
		zhuceBtn = new JButton("注册");
		changeBtn = new JButton("修改");
		button.add(zhuceBtn);
		button.add(changeBtn);
		mainWin.add(button,BorderLayout.SOUTH);
		
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setResizable(false);//设置窗口不可拖动
		mainWin.setVisible(true);//设为可见
		
		//添加监听事件
		findBtn.addActionListener(this);
		zhuceBtn.addActionListener(this);
		changeBtn.addActionListener(this);
	}
	public static void main(String[] args) {
		new MainWindow();
	}
	//监听事件
	@Override
	public void actionPerformed(ActionEvent e) {
		//查找事件
		if(e.getSource().equals(findBtn)) {
			String findNumber = stuNumber.getText();
			try {
				//连接数据库
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://106.13.180.138/java_zhuce?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8";
				String user = "kong";
				String password = "kong";
				Connection coon = DriverManager.getConnection(url, user, password);
				Statement stmt = coon.createStatement();
				String sql = "select * from student  where number='"+findNumber+"'";//按学号查找
				ResultSet re = stmt.executeQuery(sql);
				//将获得的值插入center表中
				if(!re.next()) {
					//如果学号不存在
					JOptionPane.showMessageDialog(null, "您查找的学号不存在");
				}else {
					//学号存在，则将各信息上传到相应位置
					number.setText(re.getString("number"));
					name.setText(re.getString("name"));
					if(re.getString("sex").equals("男")) {
						boy.setSelected(true);
					}else {
						girl.setSelected(true);
					}
					ageBox.setSelectedItem(re.getString("age"));
					province.setSelectedItem(re.getString("province"));
					//System.out.println(re.getString("province")+"===="+re.getString("city"));
					city.setSelectedItem(re.getString("city"));
					JOptionPane.showMessageDialog(null, "查询成功");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource().equals(zhuceBtn)) {//注册事件
			String zhuceNumber = number.getText();
			String zhuceName = name.getText();
			String zhuceSex = "";
			if(boy.isSelected()) {
				zhuceSex = "男";
			}else {
				zhuceSex = "女";
			}
			String zhuceAge = (String) ageBox.getSelectedItem();
			String zhuceProvince = (String) province.getSelectedItem();
			String zhuceCity = (String) city.getSelectedItem();
			try {
				//连接数据库
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://106.13.180.138/java_zhuce?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8";
				String user = "kong";
				String password = "kong";
				Connection coon = DriverManager.getConnection(url, user, password);
				Statement stmt = coon.createStatement();
				String sqlString="insert into student(number,name,sex,age,province,city) values('"+zhuceNumber+"','"+zhuceName+"','"+zhuceSex+"','"+zhuceAge+"','"+zhuceProvince+"','"+zhuceCity+"')";
				stmt.executeUpdate(sqlString);
				JOptionPane.showMessageDialog(null, "添加成功");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else {//修改事件
			String zhuceNumber = number.getText();
			String zhuceName = name.getText();
			String zhuceSex = "";
			if(boy.isSelected()) {
				zhuceSex = "男";
			}else {
				zhuceSex = "女";
			}
			String zhuceAge = (String) ageBox.getSelectedItem();
			String zhuceProvince = (String) province.getSelectedItem();
			String zhuceCity = (String) city.getSelectedItem();
			try {
				//连接数据库
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://106.13.180.138/java_zhuce?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8";
				String user = "kong";
				String password = "kong";
				Connection coon = DriverManager.getConnection(url, user, password);
				Statement stmt = coon.createStatement();
				String sqlString="update student set number='"+zhuceNumber+"',name='"+zhuceName+"',"+"sex='"+zhuceSex+"',"+"age='"+zhuceAge+"',"+"province='"+zhuceProvince+"',"+"city='"+zhuceCity+"'where number='"+zhuceNumber+"'";
				stmt.executeUpdate(sqlString);
				JOptionPane.showMessageDialog(null, "修改成功");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
