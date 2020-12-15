package Swing_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class example09 extends JFrame{
	public example09() {
		//创建一个JPopopMenu菜单
		JPopupMenu  popupMenu = new JPopupMenu();
		//创建三个菜单项
		JMenuItem refreshItem = new JMenuItem("refresh");//刷新
		JMenuItem createItem = new JMenuItem("create");//新建
		JMenuItem exitItem = new JMenuItem("exit");//退出
		//把菜单项添加到菜单中
		popupMenu.add(refreshItem);
		popupMenu.addSeparator();//添加菜单项分隔符
		popupMenu.add(createItem);
		popupMenu.addSeparator();//添加菜单项分隔符
		popupMenu.add(exitItem);
		
		//为当前窗体JFrame添加鼠标点击事件
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//如果点击的是鼠标的右键 ，显示弹出菜单
				if(e.getButton() == e.BUTTON3) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//为菜单项添加事件监听器
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	public static void main(String[] args) {
		new example09();
	}

}
