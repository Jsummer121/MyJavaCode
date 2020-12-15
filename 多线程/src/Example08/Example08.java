package Example08;

/*
 * 线程让步，yield方法
 */
public class Example08 {
	public static void main(String[] args) {
		//创建两个线程
		Thread t1 = new Yield("线程A");
		Thread t2 = new Yield("线程B");
		//开启线程
		t1.start();
		t2.start();
	}
}

class Yield extends Thread{
	//构造方法
	public Yield(String name) {
		super(name);//调用父类的构造方法，完成线程名称的指定
	}

	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println(Thread.currentThread().getName()+"-----"+i);
			if(i==3) {
				System.out.println(Thread.currentThread().getName()+"让步");
				Thread.yield();//线程运行到此处，做出让步
			}
		}
	}
}