package ������;
import java.util.Random;
import java.util.Scanner;

public class jisuanqi1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ��ɵ�������");
		int total = sc.nextInt();//�û��������Ŀ����
		int x1,x2,right = 0;
		System.out.println("���ǿ�ʼ������");
		for (int i = 0; i < total; i++) {
			//�������ֳ��ֵ������
			int Max = 100;
			//ѭ�����������м���
			Random r = new Random();
			x1 = r.nextInt(Max);
			x2 = r.nextInt(Max);
			System.out.println(x1+"+"+x2+"=");
			int number = sc.nextInt();
			if(number==x1+x2) {
				right += 1;
				System.out.println("̫���ˣ�����������");
			}else {
				System.out.println("���ź�������û�д�ԣ��ٽ�����������");
			}
		}
		if(right==total) {
			System.out.println("��ϲ��С���ѣ������"+total+"����ȫ������ˣ����ˮƽ�Ѿ��ﵽ������");
		}else if(total*0.8<=right && right<total) {
			System.out.println("��ϲ������"+right+"�⣬��ĳɼ��Ѿ��ﵽ4�ǵ�ˮƽ��");
		}else if(total*0.6<=right && right<total*0.8) {
			System.out.println("��ϲ������"+right+"�⣬��ĳɼ��Ѿ��ﵽ3�ǵ�ˮƽ��");
		}else if(total*0.4<=right && right<total*0.6) {
			System.out.println("���ź���ֻ�����"+right+"�⣬��ĳɼ�ֻ��2�ǵ�ˮƽ");
		}else {
			System.out.println("���ź������ˮƽ���Ƚϵͣ��ٽ�����������");
		}
	}
}
