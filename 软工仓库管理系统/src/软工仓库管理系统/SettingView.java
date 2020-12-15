package 软工仓库管理系统;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SettingView extends JPanel{
	public SettingView() {
		JButton logoutButton=new JButton("用户注销");
		JButton exitButton2=new JButton("用户注册");
		//用户注销监听
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Longing();
				setVisible(false);
			}
		});
		//用户注册监听
		exitButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new AddUser();
			}
		});
		this.setLayout(new FlowLayout());
		this.add(logoutButton);
		this.add(exitButton2);
		this.setVisible(true);
	}
}
