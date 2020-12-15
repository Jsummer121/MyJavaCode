package Example09;

/*
 * 线程插队。join()方法实现
 */
public class Example09 {

	public static void main(String[] args) throws InterruptedException {
		//创建线程
		Thread t = new Thread(new Task(),"线程1");
		//启动线程
		t.start();
		for (int i = 1; i <= 6; i++) {
			System.out.println(Thread.currentThread().getName()+"输出"+i);
			if(i==2) {
				t.join();//调用join方法
			}
			Thread.sleep(500);//线程休眠500毫秒
		}
	}

}

class Task implements Runnable{
	@Override
	public void run() {
		for (int i = 1; i <= 6; i++) {
			System.out.println(Thread.currentThread().getName()+"输出"+i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}