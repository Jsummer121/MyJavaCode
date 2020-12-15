package java期末作业帮助;

public class Test4 {
	public static void main(String[] args) {
		Student student = new Student();//创建实例
		student.start();//开启线程
		student.drank();//同步进行喝水
	}
}

//创建Student类继承Thread
class Student extends Thread{
	public void eat() {//表示正在吃饭的事件
		System.out.println("正在吃饭");
	}
	public void drank() {//表示正在喝水的事件
		System.out.println("正在喝水");
	}
	public void run() {//构造run函数，为后续线程启动制造函数
		eat();
	}
}