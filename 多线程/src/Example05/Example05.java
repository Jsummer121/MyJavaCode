package Example05;

/*
 * 售票程序，通过实现Runnable接口的方式来创建多线程
 */
public class Example05 {
	public static void main(String[] args) {
		//创建线程的任务类对象
		TicketWindows task = new TicketWindows();
		new Thread(task,"窗口1").start();//创建线程并命名为窗口1,开启线程
		new Thread(task,"窗口2").start();//创建线程并命名为窗口2,开启线程
		new Thread(task,"窗口3").start();//创建线程并命名为窗口3,开启线程
		new Thread(task,"窗口4").start();//创建线程并命名为窗口4,开启线程
	}

}

//线程任务类
class TicketWindows implements Runnable{
	private int tickets = 100;
	@Override
	public void run() {
		while(true) {
			if(tickets>0) {
				Thread th = Thread.currentThread();//获取当前运行run方法的程序
				String th_name = th.getName();//获取线程的名称
				System.out.println(th_name+"窗口，正在发售第"+tickets--+"张票；");
			}
		}
	}
}