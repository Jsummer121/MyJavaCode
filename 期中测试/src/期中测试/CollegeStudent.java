package 期中测试;

public class CollegeStudent extends Student{
	public String major;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	//定义构造方法，并使用super函数赋值
	CollegeStudent(String name,int age,String className,String major){
		super(name,age,className);
		this.major=major;
	}
	
	//复用父类的output方法并添加新的功能
	public void output() {
		super.output();
		System.out.println("该学生的专业为："+major+"。");
	}
	
}
