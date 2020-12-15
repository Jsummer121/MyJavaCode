
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * @author k
 *
 */
public class Server {
	/**
	 * 所有客户端的集合
	 */
	private List<MyChannel> all = new ArrayList<MyChannel>();
	/**
	 * 
	 */
	private ServerSocket server;
	
	public static void main(String[] args) {
		new Server().start();
	}
	
	/**
	 * 开始运行
	 */
	public void start() {
		try {
			//创建一个ServerSocket对象（表示服务器）指定服务器的端口号
			server = new ServerSocket(9999);
			while(true) {
				//通过accept来接受客户端的请求连接
				Socket client = server.accept();
				MyChannel channel = new MyChannel(client);
				all.add(channel);	//添加客户端集合
				//添加多线程
				new Thread(channel).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 一个客户端一条道路
	 * @author k
	 *
	 */
	private class MyChannel implements Runnable {
		/**
		 * 输入流
		 */
		private DataInputStream dis;
		/**
		 * 输出流
		 */
		private DataOutputStream dos;
		/**
		 * 线程体的运行状态
		 */
		private boolean isRunning = true;
		/**
		 * 客户端的用户名
		 */
		private String username;
		/**
		 * 构造器 初始化
		 * @param client accept的套接字
		 */
		public MyChannel(Socket client) {
			try {
				//获取输入流与输出流
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
//				e.printStackTrace();
				closeStream(dis,dos);
			}
		}
		/**
		 * 检查当前channel的username与其他channel是否相同
		 * @return 如果有相同返回true 否则返回false
		 */
		private boolean checkUsernameDuplication() {
			//遍历所有channel
			for(MyChannel temp:all) {
				//如果username相同 则表示又重复
				if(username.equals(temp.username)) {
					//如果遍历到的channel就是自身
					if(temp == this) {
						continue;
					}
					return true;
				}
			}
			return false;
		}
		/**
		 * show所有用户 用于调试程序
		 */
		private void showUsers() {
			for(MyChannel temp:all) {
				System.out.println(temp.username);
			}
		}
		/**
		 * 读取数据
		 * @return 
		 */
		private String receive() {
			String msg = "";
			try {
				msg =  dis.readUTF();
				System.out.println(msg);
			} catch (IOException e) {
//				e.printStackTrace();
				closeStream(dis);
			}
			return msg;
		}
		
		/**
		 * 服务器发送字符串到客户端
		 * @param msg
		 */
		private void send(String msg) {
			if(null == msg || msg.equals("")) {
				return ;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
//				e.printStackTrace();
				closeStream(dos);
			}
		}
		
		/**
		 * 重载方法 服务器发送一个boolean到客户端
		 * @param msg
		 */
		private void send(boolean msg) {
			try {
				dos.writeBoolean(msg);
				dos.flush();
			} catch (IOException e) {
//				e.printStackTrace();
				closeStream(dos);
			}
		}
		
		/**
		 * 往客户端发送增加用户的信息
		 * @param username
		 */
		private void addMessage(String username) {
			for(MyChannel other:all) {
				if(other ==this)
					continue;
				other.send("NEW"+username);
			}
		}
		
		/**
		 * 往客户端发送减少用户的信息
		 * @param username
		 */
		private void removeMessage(String username) {
			for(MyChannel other:all) {
				if(other ==this)
					continue;
				other.send("REMOVE"+username);
			}
		}
		
		/**
		 * 往其他客户端发送消息 实现群聊
		 * @param msg 发送的信息
		 * @param sys 是否为系统消息
		 */
		private void sendOthers(String msg,boolean sys) {
			if(msg == "") {
				return ;	//如果消息为空 不发送
			}
			//是否为私聊
			if(msg.startsWith("SLSL")) {
				//获取name
				String name = msg.substring(4,msg.indexOf(" "));
				String content = msg.substring(msg.indexOf(" ")+1);
				for(MyChannel other:all) {
					if(other.username.equals(name)) {
						send("你悄悄地对"+name+"说:"+content);
						other.send(this.username+"对您悄悄地说:"+content);
					}
				}	
			}else {
				//遍历容器
				send("你说:"+msg);
				for(MyChannel other:all) {
					if(other ==this)
						continue;
					if(sys == false) {
						//将服务器收到此客户端的消息发给其他客户端
						other.send(username+"说:"+msg);
					}else {
						other.send("系统消息:"+msg);
					}
					
				}
			}
		}
		
		/**
		 * 关闭程序
		 * @param io 可变参数 关闭所有的流
		 */
		private void closeStream(Closeable... io) {
			//移除该channel
			if(all.remove(this)){//如果移除成功
				//往其他客户端发送移除用户名的信息
				removeMessage(username);
				//用于服务器端的日志
				System.out.println("一台名为("+username+")的客户端断开连接");
			}
			//增强for遍历可变参数 与数组遍历方法一致
			for(Closeable temp:io) {
				try {
					//如果流不为空
					if(null != temp) {
						temp.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//关闭线程
			isRunning = false;
		}
		
		/**
		 * 线程体
		 */
		@Override
		public void run() {
			try {
				username = dis.readUTF();//接收客户端的名字
				//客户端连接成功的日志
				System.out.println("一台名为("+username+"）的客户端连接成功");
				//如果此用户名已经存在
				if(checkUsernameDuplication()) {
					System.out.println("此用户名已经存在,提示客户端重新输入");
					//往客户端发送一个boolean类型 代表username是否已经存在 false代表已经存在
					send(false);
					closeStream(dis,dos);
					//如果username已存在 则关闭channel
					return;
				}
				//show所有的用户
				showUsers();
				//往客户端发送一个boolean类型 代表username是否已经存在 true代表不存在 使信息对称
				send(true);
				//把所有的用户名通过String传到客户端 用分号隔开
				StringBuilder users = new StringBuilder("");
				//遍历所有的用户 包括自己
				for(MyChannel other:all) {
					users.append(other.username+";");
				}
				//把StringBuilder转化成String
				String str = new String(users);
				//发送
				send(str);
				//让除了自身的用户添加自身的用户名
				addMessage(username);
//				System.out.println(users);
				//当一个用户进入聊天室的时候 向自身发送系统消息
				send("系统消息:欢迎进入聊天室:"+username);
				//当一个用户进入聊天室的时候 向别人发送系统消息
				sendOthers(username+"进入聊天室",true);
			} catch (IOException e) {
//				e.printStackTrace();
				closeStream(dis,dos);
			}
			while(isRunning) {
				//无限循环接收消息
				sendOthers(this.receive(),false);
			}
		}
	}
}
