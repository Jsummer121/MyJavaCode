package MainWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test2 extends JFrame {
	ImageIcon background;
	JLabel title1,title2,backlabel;
	JPanel contentpane;
	JButton denlu,zhuce;
	
	public test2() {
		title1=new JLabel("欢迎进入学生成");
		title2=new JLabel(" 绩 管 理 系 统");
		Font font=new Font("华文行楷",Font.CENTER_BASELINE,100);
		title1.setFont(font);
		title1.setForeground(Color.WHITE);
		title2.setFont(font);
		title2.setForeground(Color.WHITE);
		denlu=new JButton("登录");
		denlu.addActionListener(new denlugui());
		zhuce=new JButton("注册");
		zhuce.addActionListener(new zhuce());
		
		setBounds(300,250,730,470);//设置窗体出现的位置
		setResizable(false);//设置窗体为不可缩放
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentpane=new JPanel();
		setContentPane(contentpane);//设置contentPane属性
		contentpane.setOpaque(false);//设置背景为透明
		init();
		contentpane.setLayout(new FlowLayout());
		contentpane.add(title1);
		contentpane.add(title2);
		contentpane.add(denlu);
		contentpane.add(zhuce);
		this.setTitle("学生成绩管理系统");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}
public void init() {
	ImageIcon background=new ImageIcon("ground1.jpg");
	backlabel=new JLabel(background);
	this.getLayeredPane().add(backlabel,new Integer(Integer.MIN_VALUE));
	backlabel.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
}

class denlugui implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//new denlu();
	}
	
}

class zhuce implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//new Zhuce();
	}
	
}
	public static void main(String[] args) {
		new test2();
	}

}
