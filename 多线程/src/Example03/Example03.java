package Example03;
/*
 * 通过实现Runnable接口方式来创建多线程
 */
public class Example03 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();//创建一个MyThread类的对象
		Thread thread = new Thread(myThread);//创建线程对象
		thread.start();//开启线程，执行线程中的run方法
		while(true) {
			System.out.println("Main正在运行");
		}
	}
}

//线程的任务类
class MyThread implements Runnable{
	@Override
	public void run() {//线程对象调用start方法时，线程会从此处进行执行
		while(true) {
			System.out.println("MyThread类中的run方法正在运行");
		}
		
	}
}