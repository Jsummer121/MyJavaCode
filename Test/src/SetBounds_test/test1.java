package SetBounds_test;

import javax.swing.JFrame;

public class test1  extends JFrame{
	
	public test1(){
		this.setTitle("仓库管理系统");
		// 整个窗体设置setBounds
		this.setBounds(0, -20, 500, 500);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new test1();
	}

}
