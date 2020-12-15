package 实验十一;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test3 {

	public static void main(String[] args) throws Exception {
		//创建一个BufferedReader缓冲对象，用于读文件中的数据
		BufferedReader in = new BufferedReader(new FileReader("reader.txt"));
		String line = null;
		//每次读一行，判断是否读到文件末尾
		while((line = in.readLine()) != null) {
			//写数据
			System.out.println(line);
		}
	}

}
