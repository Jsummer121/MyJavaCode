package 实验十二;

class myThread implements Runnable{   // 创建myThread类，并且继承Thread类
	  private String who;
	  public myThread(String str) { //构建带一个参数的构造方法
		  who=str; 
	  }
	  public void run()   //覆盖Thread类里的run()方法
	  {
		  for (int i=0;i<5;i++)
		  {
			  try {
				  Thread.sleep(2000);// 将线程进行睡眠
			  }catch (InterruptedException e) {}// 获取终端类异常
			  	System.out.println(who+"正在运行！！");
		  }
	  }
}
public class Test1{
	public static void main(String args[])
	{
		new Thread(new myThread("你")).start();
		new Thread(new myThread("她")).start();
		System.out.println("主方法main()运行结束！");
	}
}