package 聊天程序设计_DUP;

import java.util.Scanner;

/*
 * 聊天室
 */
public class CharRoom {

	public static void main(String[] args) {
		System.out.println("欢迎您，进入聊天室");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入本程序的发送数据的端口号：");
		int sendPort = sc.nextInt();
		System.out.println("请输入本程序的接收端的端口号：");
		int receivePort = sc.nextInt();
		System.out.println("聊天程序启动");
		
		new Thread(new SendTask(sendPort),"发送端任务").start();//发送操作
		new Thread(new ReceiveTask(receivePort),"接收端的任务").start();
		
	}

}
