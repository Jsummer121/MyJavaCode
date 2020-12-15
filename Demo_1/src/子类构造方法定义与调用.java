class People{
	People(){
		System.out.println("这是父类的构造方法");
	}
}

class Man extends People{
	public String name;
	Man(){
		System.out.println("这是子类的构造方法");
	}
	Man(String name){
		this.name=name;
	}
}

public class 子类构造方法定义与调用 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Man man1=new Man();
		Man man2=new Man("summer");
		System.out.println(man2.name);
	}
}
