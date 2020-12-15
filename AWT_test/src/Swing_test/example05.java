package Swing_test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JCheckBox组件（复选框）
 */
public class example05 extends JFrame{
	public example05() {
		//创建一个标签，标签中的文本信息进行居中显示
		JLabel label =new JLabel("李玺，你好",JLabel.CENTER);
		label.setFont(new Font("宋体",Font.PLAIN,20));//设置标签文字的字体
		this.add(label);//把标签添加到窗体中显示
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//下面的
		JCheckBox italic = new JCheckBox("italic");//倾斜效果
		JCheckBox bold = new JCheckBox("bold");//粗体效果
		JPanel panel = new JPanel();//创建窗口显示
		//添加复选框按钮到面板中
		panel.add(bold);
		panel.add(italic);
		//把面板添加到窗体的下方
		this.add(panel,BorderLayout.SOUTH);
		
		//为复选框定义ActionListener监听器
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int mode = Font.PLAIN;//默认字体样式
				if(italic.isSelected()) {
					//选中倾斜的复选框
					mode+=Font.ITALIC;
				}
				if(bold.isSelected()) {
					mode+=Font.BOLD;
				}
				//设置当前标签文字的样式
				label.setFont(new Font("宋体",mode,20));
			}
		};
		
		//为两个复选框添加监听器
		italic.addActionListener(listener);
		bold.addActionListener(listener);
		this.setVisible(true);//设置窗体显示
	}
	
	public static void main(String[] args) {
		new example05();
	}

}
