package 计算器;
import java.util.Random;
import java.util.Scanner;

public class jisuanji2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要完成的题目总数：");
		int total = sc.nextInt();//用户输入的题目总数
		int x1,x2,right = 0;
		System.out.println("接下来，我们开始答题了：");
		for (int i = 0; i < total; i++) {
			System.out.println("第"+(i+1)+"题");
			//设置数字出现的最大数
			int Max = 200;
			//循环该数，进行计算
			Random r = new Random();
			x1 = r.nextInt(Max);
			x2 = r.nextInt(Max);
			System.out.println(x1+"-"+x2+"=");
			int number = sc.nextInt();
			if(number==x1-x2) {
				right += 1;
				System.out.println("太棒了，这题你答对了");
			}else {
				System.out.println("很遗憾，这题没有答对，再接再厉！！！");
			}
		}
		if(right==total) {
			System.out.println("恭喜你小朋友，今天的"+total+"道题全部答对了，你的水平已经达到五星了");
		}else if(total*0.8<=right && right<total) {
			System.out.println("恭喜你答对了"+right+"题，你的成绩已经达到4星的水平了");
		}else if(total*0.6<=right && right<total*0.8) {
			System.out.println("恭喜你答对了"+right+"题，你的成绩已经达到3星的水平了");
		}else if(total*0.4<=right && right<total*0.6) {
			System.out.println("很遗憾你只答对了"+right+"题，你的成绩只有2星的水平");
		}else {
			System.out.println("很遗憾，你的水平还比较低，再接再厉！！！");
		}
	}
}

