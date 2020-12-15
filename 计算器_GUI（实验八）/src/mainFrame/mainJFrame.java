package mainFrame;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import MenuClick.*;
/**
 * 主界面
 */
public class mainJFrame extends JFrame{
	public mainJFrame(){
		//创建菜单栏
		JMenuBar menuBar = new JMenuBar();//创建菜单栏
		//创建整数加减菜单栏
		JMenu intMenu1 = new JMenu("整数加减");//创建菜单
		JMenuItem intMenu1Add = new JMenuItem("整数加法");//创建整数加法菜单栏
		JMenuItem intMenu1Trp = new JMenuItem("整数减法");//创建整数减法菜单栏
		JMenuItem intMenu1Mix = new JMenuItem("混合运算");//创建混合运算菜单栏
		//创建小数加减菜单栏
		JMenu doubleMenu1 = new JMenu("小数加减");//创建菜单
		JMenuItem doubleMenu1Add = new JMenuItem("小数加法");//创建小数加法菜单栏
		JMenuItem doubleMenu1Trp = new JMenuItem("小数减法");//创建小数减法菜单栏
		JMenuItem doubleMenu1Mix = new JMenuItem("混合运算");//创建混合运算菜单栏
		//创建整数乘除菜单栏
		JMenu intMenu2 = new JMenu("整数乘除");//创建菜单
		JMenuItem intMenu2Mul = new JMenuItem("整数乘法");//创建整数乘法菜单栏
		JMenuItem intMenu2Div = new JMenuItem("整数除法");//创建整数除法菜单栏
		JMenuItem intMenu2Mix = new JMenuItem("混合运算");//创建混合运算菜单栏
		//创建小数乘除菜单栏
		JMenu doubleMenu2 = new JMenu("小数乘除");//创建菜单
		JMenuItem doubleMenu2Mul = new JMenuItem("小数乘法");//创建小数乘法菜单栏
		JMenuItem doubleMenu2Div = new JMenuItem("小数除法");//创建小数除法菜单栏
		JMenuItem doubleMenu2Mix = new JMenuItem("混合运算");//创建混合运算菜单栏
		//创建帮助菜单栏
		JMenu help = new JMenu("帮助");//创建菜单
		JMenuItem helpMenu = new JMenuItem("帮助");//创建帮助菜单项
		
		//将菜单项添加到菜单中
		intMenu1.add(intMenu1Add);
		intMenu1.addSeparator();//添加分隔符
		intMenu1.add(intMenu1Trp);
		intMenu1.addSeparator();//添加分隔符
		intMenu1.add(intMenu1Mix);
		
		doubleMenu1.add(doubleMenu1Add);
		doubleMenu1.addSeparator();//添加分隔符
		doubleMenu1.add(doubleMenu1Trp);
		doubleMenu1.addSeparator();//添加分隔符
		doubleMenu1.add(doubleMenu1Mix);
		
		intMenu2.add(intMenu2Mul);
		intMenu2.addSeparator();//添加分隔符
		intMenu2.add(intMenu2Div);
		intMenu2.addSeparator();//添加分隔符
		intMenu2.add(intMenu2Mix);
		
		doubleMenu2.add(doubleMenu2Mul);
		doubleMenu2.addSeparator();//添加分隔符
		doubleMenu2.add(doubleMenu2Div);
		doubleMenu2.addSeparator();//添加分隔符
		doubleMenu2.add(doubleMenu2Mix);
		
		help.add(helpMenu);
		
		//将菜单添加到菜单栏中
		menuBar.add(intMenu1);
		menuBar.add(doubleMenu1);
		menuBar.add(intMenu2);
		menuBar.add(doubleMenu2);
		menuBar.add(help);
		//将菜单栏添加到JFrame中
		this.setJMenuBar(menuBar);
		
		//屏幕的基本操作
		this.setSize(800, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//创建欢迎界面
		JPanel welcomepanel = new JPanel();
		Label welcomelabel = new Label();
		welcomelabel.setText("欢迎使用Dreamspy计算器");
		welcomelabel.setFont(new Font("宋体", Font.BOLD, 20));
		welcomepanel.add(welcomelabel);
		this.add(welcomepanel);
		
		//创建点击事件
		//单机help事件
		helpMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new helpClick();
			}
		});
		//单机整数加法事件
		intMenu1Add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				JLabel lable = new JLabel("这是一个测试label222");
				panel.add(lable);
				
				welcomepanel.setVisible(false);//清除原来标记
				new intMenu1AddClick(mainJFrame.this);//将该面板传入，方便后续的面板创建
			}
		});
		
		intMenu1Trp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				welcomepanel.setVisible(false);//清除原来标记
				new intMenu1TrpClick(mainJFrame.this);//将该面板传入，方便后续的面板创建
			}
		});
		
		
	}
}
