package 计算器;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jisuanji implements ActionListener {
	int total,x1,x2,right,leave;
	JButton totalBtn,submit;
	JTextField totalTx,number;
	JLabel x1Lb,x2Lb,rightLb;
	public jisuanji() {
		JFrame mainWin = new JFrame("计算器");
		mainWin.setSize(400, 210);
		mainWin.setLocationRelativeTo(null);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setLayout(new BorderLayout());
		//头部
		JPanel head = new JPanel();
		JLabel totalLb = new JLabel("总共题目:");
		totalTx = new JTextField(6);
		totalBtn = new JButton("确认");
		head.add(totalLb);
		head.add(totalTx);
		head.add(totalBtn);
		mainWin.add(head,BorderLayout.NORTH);
		
		//中间部分
		JPanel center = new JPanel();
		center.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.blue));//设置中心窗口的上下边框
		x1Lb = new JLabel(Integer.toString(x1));
		JLabel fuhao = new JLabel("+");
		x2Lb = new JLabel(Integer.toString(x2));
		JLabel dengyu = new JLabel("=");
		number = new JTextField(6);
		submit = new JButton("提交");
		center.setLayout(null);
		x1Lb.setBounds(70, 30, 50, 20);
		fuhao.setBounds(120, 30, 50, 20);
		x2Lb.setBounds(170, 30, 50, 20);
		dengyu.setBounds(230, 30, 50, 20);
		number.setBounds(280, 30, 50, 20);
		submit.setBounds(150, 60, 80, 30);
		center.add(x1Lb);
		center.add(fuhao);
		center.add(x2Lb);
		center.add(dengyu);
		center.add(number);
		center.add(submit);
		mainWin.add(center,BorderLayout.CENTER);
		
		//底部
		JPanel button = new JPanel();
		rightLb = new JLabel("您已经答对"+Integer.toString(right)+"题，您还有"+Integer.toString(leave)+"题未答完。");
		button.add(rightLb);
		mainWin.add(button,BorderLayout.SOUTH);

		mainWin.setVisible(true);
				
		//添加监听
		totalBtn.addActionListener(this);
		submit.addActionListener(this);
	}
	public static void main(String[] args) {
		new jisuanji();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(totalBtn)) {
			//单机题数按钮
			total = Integer.valueOf(totalTx.getText()).intValue();//获取总共的提数
			leave = total;
			//设置数字出现的最大数
			int Max = 100;
			//循环该数，进行计算
			Random r = new Random();
			x1 = r.nextInt(Max);
			x2 = r.nextInt(Max);
			x1Lb.setText(Integer.toString(x1));
			x2Lb.setText(Integer.toString(x2));
			leave -= 1;
		}
		if(e.getSource().equals(submit)) {
			//单机提交按钮
			int getNumber = Integer.valueOf(number.getText()).intValue();
			if(getNumber==x1+x2) {
				right+=1;
				JOptionPane.showMessageDialog(null, "恭喜你这题答对了");
			}else {
				JOptionPane.showMessageDialog(null, "很遗憾，这题打错了，再接再厉！！！");
			}
			if(leave!=0) {
				//设置数字出现的最大数
				int Max = 100;
				//循环该数，进行计算
				Random r = new Random();
				x1 = r.nextInt(Max);
				x2 = r.nextInt(Max);
				x1Lb.setText(Integer.toString(x1));
				x2Lb.setText(Integer.toString(x2));
				rightLb.setText("您已经答对"+Integer.toString(right)+"题，您还有"+Integer.toString(leave)+"题未答完。");
				leave -= 1;
			}else {
				if(right==total) {
					JOptionPane.showMessageDialog(null, "恭喜你小朋友，今天的"+total+"道题全部答对了，你的水平已经达到五星了");
				}else if(total*0.8<right && right<total) {
					JOptionPane.showMessageDialog(null, "恭喜你，你的成绩已经达到4星的水平了");
				}else if(total*0.6<right && right<total*0.8) {
					JOptionPane.showMessageDialog(null, "恭喜你，你的成绩已经达到3星的水平了");
				}else if(total*0.4<right && right<total*0.6) {
					JOptionPane.showMessageDialog(null, "很遗憾，你的成绩只有2星的水平");
				}else {
					JOptionPane.showMessageDialog(null, "很遗憾，你的水平还比较低，再接再厉！！！");
				}
			}
		}
	}
}

