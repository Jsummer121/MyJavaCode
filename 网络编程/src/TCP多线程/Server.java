package TCP多线程;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP的多线程服务器端
 */
public class Server {
	public static void main(String[] args) throws Exception {
		//1.创建一个ServerSocket对象（表示服务器）指定服务器的端口号
		ServerSocket server = new ServerSocket(7788);
		
		while(true) {
			//2.通过accept来接受客户端的请求连接
			final Socket client = server.accept();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						//3.获取客户端的输出流或输入流
						OutputStream out = client.getOutputStream();//获取客户端输出流
						System.out.println("开始与客户端"+ client.getInetAddress().getHostAddress() +"交互数据");
						//4.通过输出流写数据到客户端或者通过输入流从客户端中读取发来的数据
						System.out.println("开始与客户端交互数据");
						out.write("dreamspy".getBytes());
						Thread.sleep(5000);//模拟执行其他功能，占用的时间
						System.out.println("结束与客户端交互数据");
						//5.关闭Socket对象，释放资源
						out.close();
						client.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
