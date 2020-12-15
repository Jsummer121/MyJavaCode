import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterTeacher extends JFrame{
	RegisterTeacher(){
		//定义每个组件
		JButton bt1,bt2;//定义注册按钮和确定按钮
		JLabel label1,label2;//定义标签栏
		JTextField text1,text2;//定义两个文本输入框
		JDialog dialog;//定义弹出对话框
	
		//设置窗体的相关参数
		this.setTitle("教师信息注册");//设置标题
		this.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));//设置窗口的布局方式
		this.setSize(400, 300);//设置窗口大小
		this.setLocationRelativeTo(null);//设置屏幕居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//设置不可变动窗口大小
		
		//将教师注册加入窗口
		label1 = new JLabel("教师注册");
		label1.setSize(100,2);
		this.add(label1,BorderLayout.NORTH);
		
		//设置中间的布局
		text1 = new JTextField(12);
		text2 = new JTextField(12);
		
		//设置课程的下拉列表单
		JPanel panel1 = new JPanel();
		final JComboBox<String> comboBox = new JComboBox<String>();//创建一个下拉列表框
		comboBox.addItem("--请选择课程--");//为下拉列表框添加选择
		comboBox.addItem("Java程序设计");
		comboBox.addItem("python");
		comboBox.addItem("web网页设计");
		comboBox.addItem("线性代数");
		comboBox.addItem("离散数学");
		panel1.add(comboBox);//添加组件到面板中
		
		//设置性别复选框
		JPanel panel2 = new JPanel();
		ButtonGroup group = new ButtonGroup();//单选按钮组对象
		JRadioButton sexBtn1 = new JRadioButton("男");
		JRadioButton sexBtn2 = new JRadioButton("女");
		sexBtn1.setSelected(true);//将nan设为默认选择
		group.add(sexBtn1);
		group.add(sexBtn2);
		panel2.add(sexBtn1);
		panel2.add(sexBtn2);
		
		//设置中间界面的面板
		JPanel mainFrame=new JPanel(new GridLayout(4,2,20,10));//选择布局方式为网络布局
		mainFrame.add(new JLabel("姓名:"));
		mainFrame.add(text1);
		mainFrame.add(new JLabel("课程:"));
		mainFrame.add(panel1);
		mainFrame.add(new JLabel("电话:"));
		mainFrame.add(text2);
		mainFrame.add(new JLabel("性别:"));
		mainFrame.add(panel2);
		//将此页面添加到窗口
		this.add(mainFrame,BorderLayout.CENTER);
		//将按钮添加进窗口
		bt1 = new JButton("注册");
		this.add(bt1,BorderLayout.SOUTH);
		this.setVisible(true);
		
		//设置弹出对话框
		dialog = new JDialog(this,"消息");
		dialog.setLocationRelativeTo(null);
		dialog.setSize(150, 100);
		dialog.setLayout(new FlowLayout());
		label2 = new JLabel("注册成功！！");
		bt2 = new JButton("确定");
		dialog.add(label2);
		dialog.add(bt2);
		
		//为注册按钮添加监听事件
		bt1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				String sex,name,phone;
				if("--请选择课程--".equals(item)) {
					label2.setText("请先选择课程");
					dialog.setVisible(true);
				}else {
					if (sexBtn1.isSelected()) {
						sex = "男";
					}else{
						sex = "女";
					}
					name = text1.getText();
					phone = text2.getText();
					//将所有信息写入Teacher.txt
					
					try {
						//创建一个文件字节输入流
						FileOutputStream out = new FileOutputStream("Teacher.txt",true);
						String str = "姓名:  "+name+"\n"+"课程:  "+item+"\n"+"电话:  "+phone+"\n"+"性别:  "+sex+"\r\n\r\n";
						byte[] b = str.getBytes();//将字符串变成字节
						for (int i = 0; i < b.length; i++) {
							try {
								out.write(b[i]);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						try {
							out.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
					dialog.setVisible(true);
				}
			}
		});
		
		//为确定按钮添加监听事件
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();//将窗口关闭
			}
		});
		
	}
	public static void main(String[] args){
		new RegisterTeacher();
	}
}
