package MenuClick;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 单机整数加法菜单项事件
 */
public class intMenu1AddClick {
	public intMenu1AddClick(JFrame mainframe) {
		JPanel panel = new JPanel();
		JLabel lable = new JLabel("这是一个测试label222");
		panel.add(lable);
		mainframe.add(panel);
	}
}
