package 银行账户系统_多线程例子;
/*
 * 测试类
 */
public class SaveMoneyTest {
	public static void main(String[] args) {
		//线程的任务对象
		Task task = new Task();
		//创建两个线程
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		//开启线程
		t1.start();
		t2.start();
	}
}
