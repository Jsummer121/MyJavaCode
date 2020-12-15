package SetBounds_test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test2 extends JFrame{
	
	JLabel label;
	JButton bt1;
	JPanel panel;
	public test2() {
		this.setSize(500, 500);
		//this.setLayout(new FlowLayout());
		this.setLayout(null);//这样才可以正确显示
		label = new JLabel("测试1");
		label.setBounds(10, 10, 100, 100);
		bt1 = new JButton("确定");
		bt1.setBounds(200, 200, 30, 30);
		this.add(label);
		this.add(bt1);
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new test2();
	}

}
