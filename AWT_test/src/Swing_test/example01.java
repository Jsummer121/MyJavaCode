package Swing_test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * JFrame的使用
 */
public class example01 extends JFrame{
	public example01() {
		this.setTitle("JFrameTest");
		this.setSize(250, 300);
		//设置居中显示
		this.setLocationRelativeTo(null);
		//定义一个按钮
		JButton bt = new JButton("按钮");
		//设置流式布局管理器
		this.setLayout(new FlowLayout());
		//添加按钮
		this.add(bt);
		
		//设置点击关闭按钮时，默认操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new example01();
	}

}
