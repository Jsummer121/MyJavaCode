package 期中测试;

//定义Student类并且继承Person接口
public class Student implements Person{
	private String name,className;//私有变量name与className
	private int age;//私有变量 age
	static int count;//静态变量学生总数
	
	//定义接受三个参数的构造方法
	Student(String name,int age,String className){
		this.name=name;
		this.age=age;
		this.className=className;
		this.count+=1;
	}
	//定义无参构造方法
	Student(){
		this.name="";
		this.age=0;
		this.className="";
	}
	//拷贝构造方法
	Student(Student s){
		super();
		this.name=s.name;
		this.age=s.age;
		this.className=s.className;
	}
	//定义成员方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//定义output方法
	public void output() {
		System.out.println("该学生姓名为："+name+"，年龄为："+age+"，班级为："+className+"。");
	}
	
	//定义getCount方法
	static int getCount() {
		return count;
	}
	
	//复写父类的speak方法
	public void speak() {
		System.out.println("学生说的外语是英语。");
	}
}
