package Swing_test;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 文本组件JTextField与JTextArea
 */
public class example04 extends JFrame{

	public example04() {
		//基本设定
		this.setLayout(new BorderLayout());//设置窗口布局
		this.setTitle("聊天窗口");//设置窗口标题
		this.setLocation(500,300);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//上面部分
		final JTextArea chatContent = new JTextArea(12,34);//创建一个文本域
		chatContent.setEditable(false);//设置文本域不可修改
		//创建有一个滚动面板，并把文本域添加到滚动面板中
		JScrollPane showPanel = new JScrollPane(chatContent);
		//添加滚动面板到窗口中
		this.add(showPanel,BorderLayout.CENTER);
		
		//下面部分
		Label label = new Label("聊天信息");//创建一个标签
		final JTextField inputField = new JTextField(20);
		JButton sendBt = new JButton("发送");//创建按钮
		JPanel inputPanel = new JPanel();//创建一个面板，用来存储下面的组件
		//添加组件到下面的面板中
		inputPanel.add(label);
		inputPanel.add(inputField);
		inputPanel.add(sendBt);
		//添加下面的面板到窗口中
		this.add(inputPanel,BorderLayout.SOUTH);//添加下面的面板到窗口中
		//为按钮添加事件
		sendBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String content = inputField.getText();//获取输入文本框内容
				if(content != null && !content.trim().equals("")) {
					//如果内容不为空，将输入的文本信息追加到聊天的从窗口中
					chatContent.append("本人："+content+"\n");
				}else {
					//如果内容为空，提示聊天信息不能为空
					chatContent.append("聊天信息不能为空\n");
				}
				//将文本框的内容设置为空
				inputField.setText("");
			}
		});
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new example04();
	}

}
