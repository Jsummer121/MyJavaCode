package Example04;

/*
 * 售票程序，通过继承Thread类的方式来实现多线程的创建
 */
public class Eaxmple04 {
	public static void main(String[] args) {
		new TicketWindow().start();//创建第一个线程对象TicketWindow，并开启线程
		new TicketWindow().start();//创建第二个线程对象TicketWindow，并开启线程
		new TicketWindow().start();//创建第三个线程对象TicketWindow，并开启线程
		new TicketWindow().start();//创建第四个线程对象TicketWindow，并开启线程
	}
}

class TicketWindow extends Thread{
	private int tickets = 100;
	public void run() {//重写thread的run方法
		while(true) {
			if(tickets>0) {
				Thread th = Thread.currentThread();//获取run方法的线程
				String th_name = th.getName();//获取当前线程的名字
				System.out.println(th_name+"正在发售第"+ tickets-- +"张票；");
			}
		}
	}
}