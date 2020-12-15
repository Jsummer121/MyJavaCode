package 银行账户系统;
//编写一个银行用户现金业务办理程序，模拟新用户到银行办理业务，可以模拟出银行对用户到来的欢迎动作，对用户离开的提醒动作以及“存款”、
//“取款”、“查询余额”和“显示账号信息”等功能。编写一测试类，创建两个不同的账户类的对象，并分别完成存款、取款、查询余额、显示账号等操作。

//定义People类，作为父类，属性为name和money
class People{
	public String name;
	public float money;
	People(){
		money=0;
	}
}

//定义Zh类，继承People类，并实现相应的函数
class Zh extends People{
	//实现只传入一个值的构造方法
	Zh(String name){
		this.name=name;
		System.out.println("感谢您来开户");
	}
	//实现传入两个值的构造方法
	Zh(String name,float money){
		this.name=name;
		this.money=money;
		System.out.println("感谢您来开户");
	}
	//实现存款方法的构造
	public void deposit(float money){
		this.money+=money;
		System.out.println("您现在的账户余额为："+this.money+"元");
	}
	//实现取款方法的构造
	public void drow_money(float money){
		if(this.money<money) {
			System.out.println("对不起，余额不足");
		}else {
			this.money-=money;
			System.out.println("您好，这次取款金额为"+money+",账户所剩余额为："+this.money+"元");
		}
	}
	//实现查询余额的方法构造
	public void show_money(){
		System.out.println("您好，您现在账户的余额为："+money+"元");
	}
	//实现显示账户信息的方法构造
	public void show_message() {
		System.out.println("该账户的户主为："+name);
		System.out.println("该账户的余额为："+money);
	}
}

public class Demo {
	static public void main(String[] args){
		//实例两个用户
		Zh zh1=new Zh("summer",1000);
		Zh zh2=new Zh("july",2000);
		//实现查看账户信息操作
		zh1.show_message();
		zh2.show_message();
		System.out.println("++++++分界线++++++");
		//实现对用户1的账户存款，对用户2的账户取款操作
		zh1.deposit(2000);
		zh2.drow_money(500);
		System.out.println("++++++分界线++++++");
		//对两个账户实现显示账户余额操作
		zh1.show_money();
		zh2.show_money();
	}
}
