import java.util.Random;
import java.util.Scanner;
// 本游戏设计三种模式，当用户输入1时进入人机模式，由用户输入一个1-2的数字，机器自动生成一个数字，进行判断；
// 当用户输入模式2时，进入双人对战模式，用户一次输入两个数字进行判断；
// 当用户输入模式3时，进入规定对战局数模式，用户输入两个数字
public class Shitoujiandaobu {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		System.out.println("请输入想玩的游戏规则：1：人机模式；2：双人模式；3:规定局数对战模式；");
		Scanner in=new Scanner(System.in);
		c=in.nextInt();
			if(c==1)
			{
				System.out.println("欢迎使用人机模式");
				while (true)
				{
					a = in.nextInt();
					if (a==9)
						break;
					Random ran=new Random();
					b=ran.nextInt(3);
					if (a==b)
						System.out.println("平局，再来重新来一局吧");
					else if (a==0)
						if (b==1)
							System.out.println("恭喜你，本局你赢啦");
						else
							System.out.println("很遗憾，你输了，再接再厉吧！");
					else if (a==1)
						if (b==2)
							System.out.println("恭喜你，本局你赢啦");
						else
							System.out.println("很遗憾，你输了，再接再厉吧！");
					else
						if (b==0)
							System.out.println("恭喜你，本局你赢啦");
						else
							System.out.println("很遗憾，你输了，再接再厉吧！");
					System.out.println("输入9退出游戏");
				}
			}
			else if(c==2)
			{
				System.out.println("欢迎来到双人对战模式");
				while (true)
				{
					a = in.nextInt();
					if (a==9)
						break;
					b = in.nextInt();
					if (a==b)
						System.out.println("平局，再来重新来一局吧");
					else if (a==0)
						if (b==1)
							System.out.println("恭喜1号，本局你赢啦");
						else
							System.out.println("很遗憾1号，你输了，再接再厉吧！");
					else if (a==1)
						if (b==2)
							System.out.println("恭喜1号，本局你赢啦");
						else
							System.out.println("很遗憾1号，你输了，再接再厉吧！");
					else
						if (b==0)
							System.out.println("恭喜1号，本局你赢啦");
						else
							System.out.println("很遗憾1号，你输了，再接再厉吧！");
					System.out.println("输入9退出游戏");
				}
			}
			else if(c==3)
			{
				System.out.println("欢迎来到规定局数对战模式");
				int d = in.nextInt();
				for (int i=1;i<=d;i++)
				{
					a = in.nextInt();
					if (a==9)
						break;
					b = in.nextInt();
					if (a==b)
						System.out.println("平局，再来重新来一局吧");
					else if (a==0)
						if (b==1)
							System.out.println("恭喜1号，本局你赢啦");
						else
							System.out.println("很遗憾1号，你输了，再接再厉吧！");
					else if (a==1)
						if (b==2)
							System.out.println("恭喜1号，本局你赢啦");
						else
							System.out.println("很遗憾1号，你输了，再接再厉吧！");
					else
						if (b==0)
							System.out.println("恭喜1号，本局你赢啦");
						else
							System.out.println("很遗憾1号，你输了，再接再厉吧！");
					System.out.println("输入9退出游戏");
				}
			}
			else
				System.out.println("您输入的游戏规则代码有误，请下次再试");
			System.out.println("感谢使用本游戏，欢迎下次再来玩");
	}
}
