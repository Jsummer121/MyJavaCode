package 实验六;

public class Sy6_1 {
	//编写程序（文件名为Sy6_1.java），要求如下：
	//（1）定义Biology（生物）、Animal（动物）和Mankind（人）3个接口；
	//（2）接口Biology声明breath()抽象方法；
	//（3）接口Animal继承Biolog并声明move()和eat()抽象方法；
	//（4）接口Mankind继承Animal并声明study()和think()抽象方法；
	//（5）定义类NormalMan实现接口Mankind，仅显示相应的功能信息来实现它们声明的抽象方法；
	//（6）在类NormalMan中定义私有变量name，实现无参构造方法和有参构造方法初始化该变量。

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NormalMan p1=new NormalMan("张三");
	    p1.output();
	    p1=new NormalMan();
	    p1.output();
	}

}
