package q;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Client extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Socket client; //客户端
	private String username;//用户名
	private DataOutputStream dos;//管道输出流
	private DataInputStream dis;//输入流
	
	private JTextArea textAreaRecord;//聊天记录
	private JButton botSend;//发送按钮
	private JButton botLogin;//登陆按钮
	private JButton botLogout;//登出按钮
	private JTextField textUsername;//登录名输入框
	private JList<String> listUsers;//用户列表
	private JLabel lbRoomInfo; //显示人数
	private final ButtonGroup buttonGroup = new ButtonGroup();//按钮选择
	private JRadioButton rdbotBrocast;//群聊按钮
	private JRadioButton rdbotPrivateChat;//私聊按钮
	private JTextArea textAreaMsg;//信息发送
	private DefaultListModel<String> modelUsers;//List用户模型
	/**
	 * 构造器 初始化
	 */
	public Client() {
		setTitle("聊天室客户端");//设置标题	
		setSize(715, 476);//设置窗口大小
		setLocationRelativeTo(null);//设置居中
		//监听窗口关闭
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//如果已经连接到服务器 则断开连接
				if(client != null)
					disconnect();
				System.exit(0);
			}
		});
		
		getContentPane().setLayout(null);//自定义布局
		
		//登录按钮
		botLogin = new JButton("登录");
		botLogin.setBounds(596, 20, 95, 27);
		getContentPane().add(botLogin);
		botLogin.addActionListener(new ActionListener() {
			//点击登录
			@Override
			public void actionPerformed(ActionEvent e) {
				password();
			}
		});
		
		//登出按钮
		botLogout = new JButton("登出");
		botLogout.setBounds(596, 20, 95, 27);
		getContentPane().add(botLogout);
		//隐藏
		botLogout.setVisible(false);
		botLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		
		JLabel jLebel1 = new JLabel("消息:");//消息文本框
		jLebel1.setBounds(14, 313, 72, 18);//设置大小位置
		getContentPane().add(jLebel1);//加入到panel
		
		botSend = new JButton("发送");//发送按钮
		botSend.setEnabled(false);//失效
		botSend.setBounds(444, 409, 88, 27);//设置大小位置
		getContentPane().add(botSend);
		//监听按钮是否被按下
		botSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//如果按下 发送
				sendMsg();
			}
		});		
		//聊天记录Label
		JLabel label = new JLabel("消息记录");
		label.setBounds(14, 55, 72, 18);
		getContentPane().add(label);
		
		//滚动panel 用于显示聊天记录
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 72, 518, 228);
		getContentPane().add(scrollPane);
		
		textAreaRecord = new JTextArea();
		//设置不可编辑
		textAreaRecord.setEditable(false);
		scrollPane.setViewportView(textAreaRecord);
		
		//用户名Lab
		JLabel label_1 = new JLabel("用户名:");
		label_1.setBounds(175, 24, 58, 18);
		getContentPane().add(label_1);

		//用户名输入框
		textUsername = new JTextField();
		textUsername.setBounds(233, 21, 95, 24);
		getContentPane().add(textUsername);
		//设定列宽
		textUsername.setColumns(10);
		//监听回车键登录
		textUsername.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//如果按下等同于按下登录按钮
				login();
			}
		});
		
		//将消息输入框设置成滚动Panel 
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 332, 518, 73);
		getContentPane().add(scrollPane_1);
		
		textAreaMsg = new JTextArea();
		scrollPane_1.setViewportView(textAreaMsg);
		//屏蔽回车换行 
		textAreaMsg.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				//crtl+回车切换下一行
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					textAreaMsg.append("\n");
				}
				//回车键发送
				else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMsg();
				}
			}
		});
		
		//在线用户Lab
		JLabel label_2 = new JLabel("在线用户");
		label_2.setBounds(543, 55, 72, 18);
		getContentPane().add(label_2);

		//将用户List设置成滚动Panel
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(546, 72, 149, 334);
		getContentPane().add(scrollPane_2);
		
		listUsers = new JList<String>();
		listUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(listUsers);
		
		//显示当前聊天室的人数
		lbRoomInfo = new JLabel("共人");
		lbRoomInfo.setBounds(546, 413, 145, 18);
		getContentPane().add(lbRoomInfo);
		
		rdbotBrocast = new JRadioButton("发送给所有人");//群聊选择按钮
		buttonGroup.add(rdbotBrocast);
		rdbotBrocast.setBounds(106, 309, 132, 22);
		getContentPane().add(rdbotBrocast);
		rdbotBrocast.setSelected(true);//默认选择群聊
		rdbotPrivateChat = new JRadioButton("私聊");//私聊选择按钮
	    buttonGroup.add(rdbotPrivateChat);
		rdbotPrivateChat.setBounds(256, 309, 157, 22);
		getContentPane().add(rdbotPrivateChat);
		
		modelUsers = new DefaultListModel<String>();
		listUsers.setModel(modelUsers);
		//设置窗口可见
		setVisible(true);
	}

	/*
	 * 密码界面
	 */
	private void password(){
		username = textUsername.getText();//从文本框获取用户名
		Connection coon = null;
		Statement stmt = null;
		ResultSet re = null;
		// 判断用户名是否存在
		try {
			// 1. 加载并注册数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 通过DriverManager获取数据库连接
			String url = "jdbc:mysql://106.13.180.138/java_test?serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "summer";
			coon = DriverManager.getConnection(url, user, password);
			// 3.通过Connection对象获取Statement对象
			stmt = coon.createStatement();
			//4. 使用Statement执行SQL语句
			String sql = "select * from user where username="+username;
			re = stmt.executeQuery(sql);
			System.out.println("1111=======");
			if (re.next()) {
		//存在 进行密码查找
				System.out.println("222222=======");
				JDialog pwd = new JDialog(this,true);
				pwd.setSize(250, 130);
				pwd.setLocationRelativeTo(null);
				pwd.setLayout(new FlowLayout());
				JLabel pwd_label = new JLabel("请输入账户："+username+"的密码");
				JTextField pwd_file = new JTextField(20);
				JButton btn = new JButton("登录");
				pwd.add(pwd_label);
				pwd.add(pwd_file);
				pwd.add(btn);
				pwd.setVisible(true);
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String psw = pwd_file.getText();
						try{
							// 1. 加载并注册数据库驱动
							Class.forName("com.mysql.cj.jdbc.Driver");
							// 2. 通过DriverManager获取数据库连接
							String url = "jdbc:mysql://106.13.180.138/java_test?serverTimezone=UTC&useSSL=false";
							String user = "root";
							String password = "summer";
							Connection coon = DriverManager.getConnection(url, user, password);
							// 3.通过Connection对象获取Statement对象
							Statement stmt = coon.createStatement();
							//4. 使用Statement执行SQL语句
							String sql="select * from user where username='"+ username +"' and password='"+ psw +"'";
							ResultSet result=stmt.executeQuery(sql);
							if (result.next()) {
								login();
							}else{
								JOptionPane.showMessageDialog(null, "密码错误，请重试");
							}
						}catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});

			}else{
		//不存在进入注册界面
				zhuce();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void zhuce() {

		
		
		
		
		
		
		
		
		
		
	}

	/*
	 * 登录
	 */
	private void login(){
		//判断用户名是否重复
		boolean login = false;	
		connect();//连接到服务器
		username = textUsername.getText();//从文本框获取用户名
		send(username);	//将用户名发送到服务器
		try {
			//接收服务器的判断
			login = dis.readBoolean();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//如果没有重复
		if(login) {
			//显示登录成功
			botSend.setEnabled(true);//启动发送键
			//接收服务器发送所有的用户列表 包括自己
			String users = receive();
			//分割字符串
			String[] usersname = users.split(";");
			//将分割完之后的字符串显示到List
			for(int i = 0; i< usersname.length; i++) {
				modelUsers.addElement(usersname[i]);
			}
			listUsers.setModel(modelUsers);
			//显示在线人数
			lbRoomInfo.setText("共"+modelUsers.getSize()+"人");
			//运行接收线程
			new Thread(new Receive()).start();
			//如果登录成功 按钮失效
			botLogin.setVisible(false);
			//登出键出现
			botLogout.setVisible(true);
		}else {
			//断开连接让用户重新登录
			disconnect();
			//聊天记录框输出错误信息
			textAreaRecord.append("用户名已经存在,请重新登录\n");
		}
	}
	
	private void logout() {
		disconnect();
		botLogin.setVisible(true);
		botLogout.setVisible(false);
		textAreaMsg.setText("");
		textAreaRecord.setText("");
		botSend.setEnabled(false);
		modelUsers.clear();
	}
	/**
	 * 用于连接服务器
	 */
	private void connect() {
		try {
			//指定连接服务器与端口
			client = new Socket("106.13.180.138",9999);
			//获取输出流 
			dos = new DataOutputStream(client.getOutputStream());
			//获取输入流
			dis = new DataInputStream(client.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 与服务端断开链接
	 */
	private void disconnect() {
		try {
			//关闭输出流
			dis.close();
			//关闭输入流
			dos.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送信息
	 */
	private void sendMsg() {
		//获取消息发送框的文本
		String msg = textAreaMsg.getText();
		//如果选择了群聊
		if(rdbotBrocast.isSelected())
			//直接发送
			send(msg);
		//如果选择了私聊
		else {
			//如果不是私聊格式
			if(!isPrivateChat(msg)) {
				//错误信息
				textAreaRecord.append("系统消息:私聊格式必须为@开头,并与正文用空格隔开\n");
			}else {//如果是私聊格式
				String name = getNameFromStr(msg);//从字符串中获取名字
				if(containsUser(name) != -1) {//用户列表中存在
					msg = msg.substring(1);
					send("SLSL"+msg);
				}else {//用户列表中不存在 或者@自己
					textAreaRecord.append("系统消息:你@的用户不存在或者不能@自己！\n");
				}
			}
		}
		//清空输入框
		textAreaMsg.setText("");
	}
	
	/**
	 * 发送数据到服务器
	 * @param msg
	 */
	private void send(String msg) {
		if(msg != null && !msg.equals("")) {
			try {
				//输出数据
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				disconnect();
			}
		}
	}
	
	/**
	 * 从服务器接收数据
	 * @return
	 */
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
//			e.printStackTrace();
			disconnect();
		}
		return msg;
	}
	
	/**
	 * 接收一个Boolean
	 * @return
	 */
	public boolean receiveBool() {
		boolean bool = false;
		try {
			bool =  dis.readBoolean();
		} catch (IOException e) {
//			e.printStackTrace();
			disconnect();
		}
		return bool;
	}
	
	/**
	 * 接收线程
	 * 内部类方便访问外部属性和方法
	 * @author k
	 *
	 */
	public class Receive implements Runnable{
		private boolean isRunnning = true;//线程标识
		
		public Receive() {

		}
		/**
		 * 线程体
		 */
		@Override
		public void run() {
			while(isRunnning) {
				String str = receive();
				//如果str以NEW开头 代表着一个用户加入了聊天室 
				if(str.startsWith("NEW")) {
					//从第四个元素开始添加到List
					modelUsers.addElement(str.substring(3));
					listUsers.setModel(modelUsers);
					//更新人数
					lbRoomInfo.setText("共"+modelUsers.getSize()+"人");
				}else if(str.startsWith("REMOVE")){
					//如果str以REMOVE开头 代表着一个用户退出了聊天室 
					int i = containsUser(str.substring(6));	//获取在ListModel中的下标
					//存在
					if(i != -1) {
						//提示
						textAreaRecord.append("系统消息:"+modelUsers.elementAt(i)+"退出了聊天室");
						//删除元素
						modelUsers.remove(i);
						lbRoomInfo.setText("共"+modelUsers.getSize()+"人");
					}
				}else {
					//表示接受了正常的消息
					textAreaRecord.setText(textAreaRecord.getText()+str+"\n");
				}
			}
		}
	}
	/**
	 * 在ListModel中是否包含元素
	 * @param name
	 * @return	返回在Model中的下标
	 */
	private int containsUser(String name) {
		for(int i = 0;i < modelUsers.getSize();i++) {
			if(name.equals(modelUsers.get(i))) {
				if(name.equals(username))
					continue;
				return i;
			}
		}
		return -1;
	}
	/**
	 * 是否是私聊格式
	 * @param str
	 * @return
	 */
	private  boolean isPrivateChat(String str) {
		//不完善
		//以@开头并存在空格
		if(str.startsWith("@") && str.indexOf(' ') != -1) {
			return true;
		}
		return false;
	}
	/**
	 * 从私聊字符串中分割出username
	 * @param str
	 * @return
	 */
	private String getNameFromStr(String str) {
		if(isPrivateChat(str)) {
			return str.substring(1,str.indexOf(" "));
		}
		return null;
	}
	public static void main(String[] args) {
		
		new Client();
	}
}
