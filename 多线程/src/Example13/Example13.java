package Example13;

/*
 * 死锁问题
 */
public class Example13 {
	public static void main(String[] args) {
		//2个创建任务对象
		Task task1 = new Task(true);
		Task task2 = new Task(false);
		//创建两个线程对象
		Thread t1 = new Thread(task1,"Chinese");
		Thread t2 = new Thread(task2,"American");
		//启动线程
		t1.start();
		t2.start();
	}

}

class Task implements Runnable{
	static Object chopsticks = new Object();//定义object类型的锁对象 chopsticks筷子
	static Object knife = new Object();//定义object类型的锁对象knife 刀
	private boolean flag;
	//构造方法
	public Task(boolean flag) {
		this.flag=flag;
	}
	
	@Override
	public void run() {
		if(flag) {
			while(true) {
				synchronized (chopsticks) {//chopsitcks锁对象的同步代码块
					System.out.println(Thread.currentThread().getName()+"---if---chopsticks");
					synchronized (knife) {//knife锁对象的同步代码块
						System.out.println(Thread.currentThread().getName()+"---if---knife");
					}
				}
			}
		} else {
			while(true) {
				synchronized (knife) {//knife锁对象的同步代码块
					System.out.println(Thread.currentThread().getName()+"---if---chopsticks");
					synchronized (chopsticks) {//chopsitcks锁对象的同步代码块
						System.out.println(Thread.currentThread().getName()+"---if---knife");
					}
				}
			}
		}
	}
}