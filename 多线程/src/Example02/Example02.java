package Example02;

/*
 * �̳�Thread��ķ�ʽ��ʵ�ֶ��߳�
 */

public class Example02 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();//�����߳�MyThread���̶߳���
		myThread.start();//�����߳�
		while(true) {
			System.out.println("main����������");
		}
	}

}

class MyThread extends Thread{
	public void run() {
		while(true) {
			System.out.println("MyThread���run������������");
		}
	}
}