package java期末作业帮助;
import java.io.*;

public class Test2 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//创建学生对象
		Student stu1 = new Student(001,"张三",19,"计算机科学与技术");
		Student stu2 = new Student(002,"李斯",18,"土木工程");
		//将学生对象写入到student.txt文件中(放在与该java文件同级的位置)
		FileOutputStream fos = new FileOutputStream("students.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(stu1);//将学生1写入
		oos.writeObject(stu2);//将学生2写入
		fos.close();//关闭流
		oos.close();

		//从文件中读取存入的学生对象
		FileInputStream fis = new FileInputStream("students.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		stu1 = (Student)ois.readObject();//读取学生1
		stu2 = (Student)ois.readObject();//读取学生2
		fis.close();//关闭流
		ois.close();
		
		//输出第一个学生的信息
		System.out.println("第一个学生的信息为：");
		System.out.println("id:"+stu1.id);
		System.out.println("name:"+stu1.name);
		System.out.println("age:"+stu1.age);
		System.out.println("deparment:"+stu1.department);
		
		//输出第二个学生的信息
		System.out.println("第二个学生的信息为：");
		System.out.println("id:"+stu2.id);
		System.out.println("name:"+stu2.name);
		System.out.println("age:"+stu2.age);
		System.out.println("deparment:"+stu2.department);
	}
	
	//创建Student类
	public static class Student implements Serializable {
		/*
		 * 包含（学号）id、（姓名）name、（年龄）age和（专业）department
		 */
		int id ;
		String name;
		int age;
		String department;
		//创建带参的构造方法
		public  Student(int id,String name,int age,String department){
			this.id = id;
			this.name = name;
			this.age = age;
			this.department = department;
		}
	}

}


