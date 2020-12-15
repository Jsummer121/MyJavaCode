package 实验八;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jisuanqi  extends JFrame  implements ActionListener {
	//定义每个按钮
	JButton bt1,bt2,bt3,bt4,bt5;
	//定义标签
	JTextField text1,text2,text3,text4;
	JLabel label1,label2,label3;
	JDialog dialog1 = new JDialog(this,"对错判断栏");
	JDialog dialog2 = new JDialog(this,"对错判断栏");
	//定义相应的构造方法
	public jisuanqi(){
		//设置窗体的相关参数
		this.setTitle("Dreamspy计算器");//设置标题
		this.setLayout(new FlowLayout());//设置窗口的布局方式
		this.setSize(700, 200);//设置窗口大小
		this.setLocationRelativeTo(null);//设置屏幕居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//设置不可变动窗口大小
		//设置弹出对话框的相关参数
		label2 = new JLabel("恭喜你，答对啦！！！");
		label3 = new JLabel("很遗憾，这次没有答对，再接再厉！！！");
		//回答正确对话框参数
		dialog1.setSize(250,100);
		dialog1.setLocationRelativeTo(null);
		dialog1.setResizable(false);
		dialog1.setModal(false);//设置为非模式对话框
		dialog1.add(label2);
		//回答错误对话框参数
		dialog2.setSize(250,100);
		dialog2.setResizable(false);
		dialog2.setLocationRelativeTo(null);
		dialog2.setModal(false);//设置为非模式对话框
		dialog2.add(label3);
		
		bt1=new JButton("加法");
		bt3=new JButton("减法");
		bt4=new JButton("乘法");
		bt5=new JButton("除法");
		bt2=new JButton("结束运算");
		
		//将每个按钮添加到jframe中
		this.add(bt1);
		this.add(bt3);
		this.add(bt4);
		this.add(bt5);
		this.add(bt2);
		//为按钮添加监听器
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		//设置主体部分
		label1=new JLabel("将自己的答案写在运算结果的框内，再点击上方的运算按钮!!");
		Random r=new Random();
		int n=r.nextInt(100);
		String s=String.valueOf(n);
		text1=new JTextField(s,20);
		String[] a= {"+","-","×","÷"};
		int num=(int)(Math.random()*a.length);//随机生成字符串下标 
		text4=new JTextField(a[num],20);
		int j=r.nextInt(100);
		String p=String.valueOf(j);
		text2=new JTextField(p,20);
		text3=new JTextField(20);
		JPanel mainFrame=new JPanel(new GridLayout(5,2));//网络布局
		mainFrame.add(new JLabel("提示:"));
		mainFrame.add(label1);
		mainFrame.add(new JLabel("数值一:"));
		mainFrame.add(text1);
		mainFrame.add(new JLabel("计算类型:"));
		mainFrame.add(text4);
		mainFrame.add(new JLabel("数值二:"));
		mainFrame.add(text2);
		mainFrame.add(new JLabel("运算结果:"));
		mainFrame.add(text3);
		this.add(mainFrame);
		this.setVisible(true);
}

//设置监听事件
public void actionPerformed(ActionEvent e){
	if(e.getSource()== bt2){
		System.exit(0);
	}else{
		Double num1=new Double(text1.getText());//实现字符串到浮点数转换
		Double num2=new Double(text2.getText());
		Double num3= (double)0;//转换
			
		if(e.getSource()==bt1){
			num3=num1+num2;
		}else if(e.getSource()==bt3){
			num3=num1-num2;
		}else if(e.getSource()==bt4){
			num3=num1*num2;
		}else if(e.getSource()==bt5){
			num3=num1/num2;
		}
		//实现体现用户是否运算正确
		if(num3==Double.parseDouble(text3.getText()))
		{
			//如果正确，则弹出显示回答正确的对话框
			dialog1.setVisible(true);
		}else {
			//如果错误，则弹出显示回答错误的对话框
			dialog2.setVisible(true);
		}
		
	}
}

public static void main(String[] args) {
	new jisuanqi();
}}
