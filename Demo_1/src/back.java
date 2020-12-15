public class back {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class Yhzh
{//属性，成员变量
	String name,password;//户名，密码
	double balance;//余额
	//操作，成员方法，函数    返回值类型 函数名（形参）｛｝
	//设置银行帐户的户名，密码，余额
	
	void set(String a,String b,double c)
    {this.name=a;this.password=b;this.balance=c;}
	
	void qk(double je) {
		if(this.balance<je) {
			System.out.println("余额不足！");
		}else {
			this.balance-=je;
			System.out.println("取款完成，当前账户内所剩余额为："+this.balance);
		}
	}//取款
	
    void ck(double je) {
    	this.balance+=je;
    	System.out.println("存款成功，当前卡内余额为："+this.balance);
    }//存款
    
    void mg() {
    	System.out.println(this.name+"先生你好，您现在卡内余额为："+this.balance);
    }//输出帐户信息
    
    void cp(String a) {
    	this.password=a;
    	System.out.println("您的密码修改完成。");
    }//修改帐户密码
}