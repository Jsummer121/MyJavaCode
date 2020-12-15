package Swing_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class example08 extends JFrame{
	public example08() {
		JMenuBar menuBar = new JMenuBar();//创建菜单栏
		JMenu menu = new JMenu("操作");//创建菜单
		JMenuItem item1 = new JMenuItem("弹出窗口");//创建两个菜单项
		JMenuItem item2 = new JMenuItem("关闭");//创建两个菜单项
		//组建下拉式菜单
		menu.add(item1);
		menu.addSeparator();//添加分隔符
		menu.add(item2);
		menuBar.add(menu);//菜单添加到菜单栏
		this.setJMenuBar(menuBar);//菜单栏添加到窗体
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//为菜单项添加事件的监听器
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(example08.this,true);
				dialog.setTitle("弹出对话框");
				dialog.setSize(200, 200);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		
		item2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		new example08();
	}

}
