package 实验六;
//（5）定义类NormalMan实现接口Mankind，仅显示相应的功能信息来实现它们声明的抽象方法；
//（6）在类NormalMan中定义私有变量name，实现无参构造方法和有参构造方法初始化该变量。
public class NormalMan implements Mankind {
	//定义name
	private String name;
	//实现有参构造方法
	NormalMan(String name){
		this.name=name;
	}
	
	//实现无参构造方法
	NormalMan(){
		name="李四";
	}
	
	//实现接口
	public void breath() {
		System.out.println(name+"can breath");
	}
	public void move() {
		System.out.println(name+"can move");
	}
	public void eat() {
		System.out.println(name+"can eat");
	}
	public void study() {
		System.out.println(name+"can study");
	}
	public void think() {
		System.out.println(name+"can think");
	}
	
	public void output() {
		breath();
		move();
		eat();
		study();
		think();
	}
	
}
