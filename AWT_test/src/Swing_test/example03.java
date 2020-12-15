package Swing_test;

import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * 中间容器添加按钮
 */
public class example03 extends JFrame{

	public example03() {
		this.setTitle("PanelDemo");
		this.setLocationRelativeTo(null);
		
		//定义一个JPanel面板
		JPanel panel = new JPanel();
		
		//在pannel面板添加四个按钮
		panel.add(new Button("按钮1"));
		panel.add(new Button("按钮2"));
		panel.add(new Button("按钮3"));
		panel.add(new Button("按钮4"));
		
		//创建一个滚动面板
		JScrollPane scrollpane = new JScrollPane();
		//设置水平滚动条一直显示效果	
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//设置垂直滚动条的显示效果，需要时显示
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//设置panel面板在滚动面板中显示
		scrollpane.setViewportView(panel);
		
		
		//将面板scrollpane添加到窗体中
		this.add(scrollpane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new example03();
	}

}
