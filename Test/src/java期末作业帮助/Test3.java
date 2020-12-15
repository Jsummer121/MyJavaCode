package java期末作业帮助;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) throws Exception {
		//指定输入流
		FileInputStream in = new FileInputStream("reader.txt");//创建字节输入流
		InputStreamReader isr = new InputStreamReader(in);//将字节输入流转化字符输入流
		BufferedReader br = new BufferedReader(isr);

		//读数据
		String line = null;//按照每一行的方式读取
		while((line = br.readLine())!=null) {//如果这行是null则关闭读取
			System.out.println(line);
		}
		//关闭流
		in.close();
		isr.close();
		br.close();
	}
}
