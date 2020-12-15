package Example02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 发送端
 */
public class Sender {

	public static void main(String[] args) throws IOException {
		//1.创建DatagramSocket对象，指定发送端程序的端口号
		DatagramSocket ds = new DatagramSocket(3000);
		//2.准备要发送的数据
		String str = "hello world";
		byte[] buf = str.getBytes();
		//3.创建一个DatagramPacket对象，用来封装要发送的数据
		//数据包含：要发送的数据、数据的长度、接收端的ip地址和端口号
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"),8954);
		
		//4.发送数据
		ds.send(dp);
		
		//5.释放资源
		ds.close();
	}

}
