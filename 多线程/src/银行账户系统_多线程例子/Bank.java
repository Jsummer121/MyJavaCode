package 银行账户系统_多线程例子;
/*
 * 银行
 */

public class Bank {
	private int sum = 0;
	
	public void add(int money) {
		synchronized (this) {
			sum+=money;
			System.out.println("账户余额为：" + sum);
		}
	}


}
