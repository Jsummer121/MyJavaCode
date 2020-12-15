package Swing_test;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * JDialog对话框
 */
public class example02 {
	public static void main(String[] args) {
		//建立两个按钮
		JButton btn1 = new JButton("模式对话框");
		JButton btn2 = new JButton("非模式对话框");
		JFrame f = new JFrame("JDialogDemo");
		f.setSize(300, 250);
		f.setLocationRelativeTo(null);//设置居中效果
		f.setLayout(new FlowLayout());//设置布局管理模式
		//添加按钮
		f.add(btn1);
		f.add(btn2);
		//设置点击关闭按钮的默认操作
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//创建JDialog
		final JDialog dialog = new JDialog(f,"Dialog");
		dialog.setSize(220, 150);
		dialog.setLocation(350, 150);//设置对话框显示位置
		dialog.setLayout(new FlowLayout());//设置对话框的布局管理器
		JButton btn3 = new JButton("确定");
		dialog.add(btn3);//在对话框中添加按钮
		final Label label = new Label("标签");
		dialog.add(label);
		
		//为“模式对话框”按钮，添加点击事件
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置对话框的状态设置为模式对话框
				dialog.setModal(true);
				//修改标签的内容
				label.setText("模式对话框，点击确定按钮关闭");
				//显示对话框
				dialog.setVisible(true);
			}
		});
		//为“非模式对话框”按钮，添加点击事件
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置对话框的状态设置为模式对话框
				dialog.setModal(false);
				//修改标签的内容
				label.setText("非模式对话框，点击确定按钮关闭");
				//显示对话框
				dialog.setVisible(true);
			}
		});
		//为对话框中的按钮添加点击事件
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
	}
}
