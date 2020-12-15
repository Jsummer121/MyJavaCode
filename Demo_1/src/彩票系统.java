import java.util.Random;
public class 彩票系统 {

	public static void main(String[] args) {
		int[][] total=new int[100][8];
		int[] real=new int[7];
		int totalMoney=0;
		total = Add_cp();
		real = total[100];

	}
	
	public static int[][] Add_cp() {
		// 自动生成100个彩票号码一共8位：前面6位红球，一位篮球和一位注数
		int a;
		int[][] total=new int[100][8];
		Random ran=new Random();
		for(int i=0;i<=100;i++) {
			int[] b=new int[8];
			if(i==100) {
				for(int j=0;j<=5;j++) 
				{
					do {
						a=ran.nextInt(33)+1;
					}while (a==b[0]|a==b[1]|a==b[2]|a==b[3]|a==b[4]|a==b[5]);
					b[j]=a;
				}
				b[6] = ran.nextInt(16)+1;
				total[100]=b;
				return total;//返回所有彩票号码
			}
			for(int j=0;j<=5;j++) {
				do {
					a=ran.nextInt(33)+1;
				}while (a==b[0]|a==b[1]|a==b[2]|a==b[3]|a==b[4]|a==b[5]);
				b[j]=a;
			}
			b[6] = ran.nextInt(16)+1;
			b[7] = ran.nextInt(99)+1;
			total[i]=b;
		}
		return total;//返回所有彩票号码
	}
	
	public static void Check_cp(int[] arr,int money) {
		//输入彩票号码与奖池数
		//[which,0,1,2,3,4,5,6,total]
		//用数组来存储该彩票是几等奖并且存储奖池
		//if() return //输出
	}

}
