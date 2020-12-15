package ������;

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
		JFrame mainWin = new JFrame("������");
		mainWin.setSize(400, 210);
		mainWin.setLocationRelativeTo(null);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setLayout(new BorderLayout());
		//ͷ��
		JPanel head = new JPanel();
		JLabel totalLb = new JLabel("�ܹ���Ŀ:");
		totalTx = new JTextField(6);
		totalBtn = new JButton("ȷ��");
		head.add(totalLb);
		head.add(totalTx);
		head.add(totalBtn);
		mainWin.add(head,BorderLayout.NORTH);
		
		//�м䲿��
		JPanel center = new JPanel();
		center.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.blue));//�������Ĵ��ڵ����±߿�
		x1Lb = new JLabel(Integer.toString(x1));
		JLabel fuhao = new JLabel("+");
		x2Lb = new JLabel(Integer.toString(x2));
		JLabel dengyu = new JLabel("=");
		number = new JTextField(6);
		submit = new JButton("�ύ");
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
		
		//�ײ�
		JPanel button = new JPanel();
		rightLb = new JLabel("���Ѿ����"+Integer.toString(right)+"�⣬������"+Integer.toString(leave)+"��δ���ꡣ");
		button.add(rightLb);
		mainWin.add(button,BorderLayout.SOUTH);

		mainWin.setVisible(true);
				
		//��Ӽ���
		totalBtn.addActionListener(this);
		submit.addActionListener(this);
	}
	public static void main(String[] args) {
		new jisuanji();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(totalBtn)) {
			//����������ť
			total = Integer.valueOf(totalTx.getText()).intValue();//��ȡ�ܹ�������
			leave = total;
			//�������ֳ��ֵ������
			int Max = 100;
			//ѭ�����������м���
			Random r = new Random();
			x1 = r.nextInt(Max);
			x2 = r.nextInt(Max);
			x1Lb.setText(Integer.toString(x1));
			x2Lb.setText(Integer.toString(x2));
			leave -= 1;
		}
		if(e.getSource().equals(submit)) {
			//�����ύ��ť
			int getNumber = Integer.valueOf(number.getText()).intValue();
			if(getNumber==x1+x2) {
				right+=1;
				JOptionPane.showMessageDialog(null, "��ϲ����������");
			}else {
				JOptionPane.showMessageDialog(null, "���ź����������ˣ��ٽ�����������");
			}
			if(leave!=0) {
				//�������ֳ��ֵ������
				int Max = 100;
				//ѭ�����������м���
				Random r = new Random();
				x1 = r.nextInt(Max);
				x2 = r.nextInt(Max);
				x1Lb.setText(Integer.toString(x1));
				x2Lb.setText(Integer.toString(x2));
				rightLb.setText("���Ѿ����"+Integer.toString(right)+"�⣬������"+Integer.toString(leave)+"��δ���ꡣ");
				leave -= 1;
			}else {
				if(right==total) {
					JOptionPane.showMessageDialog(null, "��ϲ��С���ѣ������"+total+"����ȫ������ˣ����ˮƽ�Ѿ��ﵽ������");
				}else if(total*0.8<right && right<total) {
					JOptionPane.showMessageDialog(null, "��ϲ�㣬��ĳɼ��Ѿ��ﵽ4�ǵ�ˮƽ��");
				}else if(total*0.6<right && right<total*0.8) {
					JOptionPane.showMessageDialog(null, "��ϲ�㣬��ĳɼ��Ѿ��ﵽ3�ǵ�ˮƽ��");
				}else if(total*0.4<right && right<total*0.6) {
					JOptionPane.showMessageDialog(null, "���ź�����ĳɼ�ֻ��2�ǵ�ˮƽ");
				}else {
					JOptionPane.showMessageDialog(null, "���ź������ˮƽ���Ƚϵͣ��ٽ�����������");
				}
			}
		}
	}
}

