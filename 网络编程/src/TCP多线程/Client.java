package TCP多线程;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * TCP客户端
 */
public class Client {
	public static void main(String[] args) throws Exception{
		//1.创建一个Socket对象，并连接到指定的服务器IP地址与服务器端口号
		Socket client = new Socket(InetAddress.getLocalHost(),7788);
		//2.发送数据给服务器或者接受服务器的数据
		InputStream in = client.getInputStream();
		byte[] buf = new byte[1024];
		int length = in.read(buf);//将数据读到缓冲数组中
		System.out.println(new String(buf,0,buf.length));
		//3.关闭Socket对象
		client.close();
	}
}
