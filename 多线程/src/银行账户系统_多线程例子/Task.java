package 银行账户系统_多线程例子;

/*
 * 存钱的线程任务类
 * 
 * 向银行中存款三次，每次存款100元
 */
public class Task implements Runnable{
	//定义一个银行对象
	private Bank bank = new Bank();
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			bank.add(100);
		}
	}

}
