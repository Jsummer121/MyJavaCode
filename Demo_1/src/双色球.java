import java.util.Random;
public class 双色球 {

	public static void main(String[] args) {
		int a;
		int[] b=new int[7];
		Random ran=new Random();
		// TODO Auto-generated method stub
		for(int i=0;i<=5;i++) {
			do {
				a=ran.nextInt(33)+1;
			}while (a==b[0]|a==b[1]|a==b[2]|a==b[3]|a==b[4]|a==b[5]);
			b[i]=a;
		}
		a=ran.nextInt(16)+1;
		b[6]=a;
		for (int i=0;i<=6;i++) {
			System.out.print(b[i]+",");
		}
	}

}
