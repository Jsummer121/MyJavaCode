package Example02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 接收端
 */
public class Receiver {

	public static void main(String[] args) throws IOException {
		
		//1.定义一个DatagramSocket对象，指定接收端的端口号
		DatagramSocket ds = new DatagramSocket(8954);
		
		//2.定义DatagramPacket对象，用于接收数据
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//3.调用接收数据方法
		System.out.println("等待接收数据");
		ds.receive(dp);//等待接收数据，如果没有数据则会阻塞
		//4.获取查看接收到的数据信息
		byte[] data = dp.getData();
		int length = dp.getLength();//实际接收到的数据的数量
		String ip = dp.getAddress().getHostAddress();//获取ip地址
		int port = dp.getPort();//获取端口号
		String str = new String(data,0,length);
		System.out.println(str+" from "+ip+":"+port);
		//5.释放资源
		ds.close();
	}

}
