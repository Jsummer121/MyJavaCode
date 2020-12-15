package Swing_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * JRadioButton组件的使用
 *
 */
public class example06 extends JFrame{
	public example06() {
		final JPanel pallet = new JPanel();//创建一个调色板
		this.add(pallet,BorderLayout.CENTER);//将调色板添加到窗体的中间位置
		
		ButtonGroup group = new ButtonGroup();//单选按钮组对象
		JRadioButton btn1 = new JRadioButton("灰");
		JRadioButton btn2 = new JRadioButton("粉");
		JRadioButton btn3 = new JRadioButton("黄");
		//添加按钮到按钮组中
		group.add(btn1);
		group.add(btn2);
		group.add(btn3);
		JPanel panel = new JPanel();//创建一个面板
		panel.add(btn1);//按钮添加到面板中
		panel.add(btn2);
		panel.add(btn3);
		//添加面板到窗体的下方
		this.add(panel,BorderLayout.SOUTH);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//创建单选按钮的ActionListener监听器
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = null;
				if(btn1.isSelected()) {
					color = Color.GRAY;
				}else if (btn2.isSelected()) {
					color = Color.PINK;
				}else if(btn3.isSelected()) {
					color = Color.YELLOW;
				}
				//为调色板设置背景色
				pallet.setBackground(color);
			}
		};
		//为单选按钮添加监听器
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new example06();
	}

}
