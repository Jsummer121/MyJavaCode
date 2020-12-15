package Example02;

/*
 * 继承Thread类的方式来实现多线程
 */

public class Example02 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();//创建线程MyThread的线程对象
		myThread.start();//开启线程
		while(true) {
			System.out.println("main方法在运行");
		}
	}

}

class MyThread extends Thread{
	public void run() {
		while(true) {
			System.out.println("MyThread类的run方法正在运行");
		}
	}
}