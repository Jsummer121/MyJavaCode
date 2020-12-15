package MenuClick;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 单机整数减法菜单项事件
 */
public class intMenu1TrpClick {
	public intMenu1TrpClick(JFrame mainframe) {
		
		JPanel panel = new JPanel();
		JLabel lable = new JLabel("这是一个测试label111");
		panel.add(lable);
		mainframe.add(panel);
		System.out.println("减法");
	}
}
