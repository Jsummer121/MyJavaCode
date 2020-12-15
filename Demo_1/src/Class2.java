
public class Class2 {
	public static void main(String[] args) {
		Student s1 = new Student("张三",1);
		Student s2 = new Student(2);
		Student s3 = new Student();
		s1.set("李四",20);
		s1.output();
		s2.output();
		s3.output();
	}
}


class Student{
	String name;
	int id;
	Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	Student(int id){
		this.id = id;
		name = null;
	}
	
	Student(){
		id = 0;
		name = null;
	}
	
	public void set(String name,int num) {
		this.name = name;
		this.id = num;
	}
	
	public void output(){
		System.out.println(name+"同学你好，你的学号为:"+id);
	}
}