package java期末作业帮助;
import java.util.Scanner;

public class Test1 { 
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("请输入学生的年龄：");
		int age = sc.nextInt();//用户输入年龄
		CheckScore check = new CheckScore();
		try { 
			check.check(age); //尝试检查该年龄是否合法
		} catch (MyException e) {// 用自己的异常类来捕获异常 
			e.printStackTrace(); 
		} 
	}

	public static class CheckScore {
		// 检查年龄合法性的方法check()
		public static void check(int age) throws MyException {// 抛出自己的异常类 
			if (age > 120 || age < 0) { 
				// 年龄不合法时抛出异常 
				throw new MyException("年龄不合法，年龄应该是0--120之间");// new一个自己的异常类 
			} else { 
				System.out.println("年龄合法，您的年龄为：" + age); 
			} 
		} 
	} 

	@SuppressWarnings("serial")
	public static class MyException extends Exception {  
		// 提供无参数的构造方法
		public MyException() {} 
		// 提供一个有参数的构造方法，可自动生成
		public MyException(String message) { 
			super(message);// 把参数传递给Throwable的带String参数的构造方法 
		}
	}
}