package 记事本;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 期中作业--记事本
 */
public class jishiben extends JFrame implements ActionListener{
	String name="";
	String chatFile;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem itemSaveOther,itemClose;
	JTextArea chatContent;
	JScrollPane showPanel;
	JDialog saveName,saveSuccese;
	JTextField nameFile;
	JButton nameBtnSave;
	JLabel label;
	// 写记事本函数的构造函数
	public jishiben() {
		menuBar = new JMenuBar();//创建菜单栏
		menu = new JMenu("文件");//创建文件菜单
		itemSaveOther = new JMenuItem("保存");//创建保存菜单项
		itemClose = new JMenuItem("关闭");//创建关闭菜单项
		chatContent = new JTextArea();//创建一个文本域
		showPanel = new JScrollPane(chatContent);//创建有一个滚动面板(中间容器)，并把文本域添加到滚动面板中
		
		// 设置窗体的一些基本参数
		this.setSize(600, 500);// 设置窗体的大小
		this.setLocationRelativeTo(null); // 设置窗口居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭
		
		// 组建下拉式菜单
		menu.add(itemSaveOther);
		menu.addSeparator();// 添加分隔符
		menu.add(itemClose);
		menuBar.add(menu);// 菜单添加到菜单栏
		this.setJMenuBar(menuBar);// 菜单栏添加到窗体
		

		// 将文本框添加进主页面
		this.add(showPanel);
		
		// 保存文件名的对话框
		saveName = new JDialog(jishiben.this,true);
		nameFile = new JTextField(10);
		nameBtnSave = new JButton("确定");
		saveName.setLayout(new FlowLayout());
		saveName.add(new JLabel("请输入保存的文件名"));
		saveName.add(nameFile);
		saveName.add(nameBtnSave);
		saveName.setSize(180, 120);
		saveName.setResizable(false);// 设置不可变动窗口大小
		saveName.setLocationRelativeTo(null);
		
		// 保存完成后，显示dialog框
		saveSuccese = new JDialog(jishiben.this,true);
		label = new JLabel("保存成功");
		saveSuccese.add(label);
		saveSuccese.setSize(50, 80);
		saveSuccese.setLocationRelativeTo(null);
		
		//添加监听事件		
		itemSaveOther.addActionListener(this);// 为保存按钮添加监听事件
		itemClose.addActionListener(this);// 为关闭按钮添加监听事件
		nameBtnSave.addActionListener(this);// 为保存文件名对话框的确定按钮添加监听事件
		
		this.setVisible(true);
	}
	
	
	// 为监听事件添加操作
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == itemClose) {// 为关闭按钮添加事件
			System.exit(0);
		}
		if(e.getSource() == itemSaveOther) {// 为另存为按钮添加事件
			saveName.setVisible(true);
		}
		if(e.getSource() == nameBtnSave) {// 为保存按钮添加事件
			saveName.setVisible(false);
			name = nameFile.getText();// 获取文件名
			chatFile = chatContent.getText();// 获取文本内容
			this.setTitle(name);
			String Fname = name+ ".txt";// 将名字进行后缀名处理
			File file = new File(Fname);
			try {
				FileWriter writer = new FileWriter(file);
				//把字符数据写入到文件中
				writer.write(chatFile);
				writer.write("\r\n");//将写入的数据换行
				writer.close();//关闭字符输出流
			}catch(Exception e1){
				label.setText("出现错误，请重试");
			}finally {
				saveSuccese.setVisible(true);
			}
		}
	}
	
	
	//主函数
	public static void main(String[] args) {
		new jishiben();//实例化构造函数
	}
}
