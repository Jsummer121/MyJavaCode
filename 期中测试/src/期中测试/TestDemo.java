package 期中测试;

public class TestDemo {

	public static void main(String[] args) {
		Student s1=new Student("summer",20,"3班");
		Student s2=new Student("蒋鑫鑫",20,"3班");
		Student s3=new Student("李玺",18,"1班");
		s1.output();
		s2.output();
		s3.output();
		int count=Student.getCount();
		System.out.println("现在的学生为："+count+"个。");
		
		CollegeStudent s4=new CollegeStudent("蒋鑫鑫",20,"三班","计算机");
		s4.output();
	}
}
