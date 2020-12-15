package 聊天程序设计_DUP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 接受数据的任务类
 */
public class ReceiveTask implements Runnable {
	private int receivePort;
	public ReceiveTask(int receivePort) {
		this.receivePort = receivePort;
	}
	@Override
	public void run() {
		try {
			//1.创建DatagramSocket对象
			DatagramSocket ds = new DatagramSocket(receivePort);
			//2.创建DatagramPacket对象
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			//3.接收数据
			while(true) {
				ds.receive(dp);
				//4.显示收到的数据
				String str = new String(dp.getData(),0,dp.getLength());
				System.out.println("收到"+dp.getAddress().getHostAddress()+"--发送的数据--"+str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
