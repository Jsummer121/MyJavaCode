////子类继承父类，拥有父类的成员
//class Zilei extends Student{
//	//子类可以新增成员
//	int age;
//	public Zilei(String name,int num,int age) {
//		//调用父类的构造方法实现赋值，必须放在第一行
//		super(name,num);
//		//调用父类中set方法
//		super.set(name,num);
//		//子类继承父类
//		this.set(name,num);
//		//
//		this.age=age;
//	}
//	public void set(String name,int num,int age) {set(name,num);this.age=age;}
//	public int getAge() {return age;}
//    public void setAge(int age) {this.age=age;}
//    public void output()//输出信息
//    {
//		super.output();
//		System.out.println("余额："+this.age);
//	}
//}
//class Student{
//	//在一个.java文件中，public类只能有一个，且与文件名一致
//			//属性，成员变量
//			private String name;int num;//私有成员只能在本类中进行访问
//			//静态变量，静态类
//			 static int n;
//			public static void huan() {
//				System.out.println("欢迎光临");
//			} 
//			//构造方法
//			public  Student(String x,int y)
//			{this.name=x;this.num=y;n++;}
//			 public Student() {
//				this.name="张三";this.num=1;
//			}
//			 public Student(int z) {
//				 this.num=z;
//			 }
//			 
//			 //拷贝构造方法：形参是本类的对象
//			 //1.具备实例化对象，成员变量赋初始值的功能
//			 //2.拷贝：根据原来的对象
//			 public Student(Student p) {
//				 this.name=p.name;
//				 this.num=p.num;
//				 
//			 }
//			public void set(String x,int y)
//			{this.name=x;this.num=y;}
//			public void setX(String x)
//			{this.name=x;}
//			public void setY(int y)
//			{this.num=y;}
//			//getXxxx得到某一项值
//			public String getX()
//			{return this.name;}
//			public int getY()
//			{return this.num;}
//			
//			public void output()//输出信息
//			{//this调用成员变量
//				System.out.println("姓名："+this.name);
//				System.out.println("账号："+this.num);
//				System.out.println("总数："+this.n);
//			}
//}
//public class Jx {
//	
//		public static void main(String[] args) {
//			// TODO Auto-generated method 
//			Student.huan();
//		 Student l = new Student("王无",4452); // 创建实例2
//		    l.output();
//		    Student s1=new Student();
//		    s1.output();
//		    Student s2=new Student(2);
//		    s2.output();
//		    Student s3=new Student(0);
//		    s3.output();
//		    s1.set("李四",20);
//		    System.out.println("修改后");
//		    s1.output();
//		    //拷贝实例化对象
//		    System.err.print("拷贝后的\n");
//		    Student p1=new Student(s2);
//		    p1.output();
//		    Student p2=new Student(l);
//		    p2.output();
//		    Zilei p3=new Zilei();
//		    p3.set("下降",12,34);
//		    p3.output();   
//}
//}