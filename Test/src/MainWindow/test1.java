package MainWindow;

import java.awt.*;
import javax.swing.*;


public class test1 extends JFrame{
	JPanel ProductManage;
	int combo;
	String ww;

	public test1(){
		//主页面
		JTabbedPane xxk=new JTabbedPane();

		//产品管理页面
		ProductManage=new JPanel();
		JLabel label1 = new JLabel("这是产品管理界面");
		//设置此选项卡的布局
		ProductManage.setLayout(new FlowLayout());
		ProductManage.add(label1);
		ProductManage.setSize(450,500);
		ProductManage.setVisible(true);

		//供应商管理页面
		JPanel supplier=new JPanel();
		JLabel label2 = new JLabel("这是供应商管理页面");
		supplier.setLayout(null);
		label2.setBounds(30, 30, 100, 100);
		supplier.add(label2);
		
		//产品视图
		JPanel view=new JPanel();
		JLabel label3 = new JLabel("这是产品视图页面");
		view.setLayout(null);
		label3.setBounds(100, 100, 100, 100);
		view.add(label3);

		//功能设置
		JPanel functionPanel=new JPanel();
		JLabel label4 = new JLabel("这是功能设置页面");
		functionPanel.setLayout(null);
		label4.setBounds(30, 30, 100, 100);
		functionPanel.add(label4);
		
		//主界面添加 
		xxk.add(ProductManage,"产品管理");
		xxk.add(supplier,"供应商管理");
		xxk.add(view,"产品视图");
		xxk.add(functionPanel,"功能设置");
		
		//主页设置
		this.add(xxk,BorderLayout.CENTER);
		this.setTitle("仓库管理系统");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(465, 750);
		this.setLocation(530, 80);
	}

	public static void main(String args[]){
		new test1();
	}
}
