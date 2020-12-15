package 多线程;

/*
 * 单线程程序
 */

public class Example01 {
	public static void main(String[] args) {
		//创建MyThread类对象
		MyThread myThread = new MyThread();
		myThread.run();//调用run方法
		while(true) {
			System.out.println("main方法在运行");
		}
	}
}

class MyThread{
	public void run() {
		while(true) {//该循环对应的是一个死循环，打印输出语句
			System.out.println("MyThread类的run()方法在运行");
		}
	}
	
}
