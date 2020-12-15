package 实验十一;

import java.io.FileWriter;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws Exception {
		//创建一个FileWriter对象，用于向文件中写入数据
		FileWriter writer = new FileWriter("reader.txt");
		//准备写入到文件中的数据
		String str = "summer";
		//把字符数据写入到文件中
		writer.write(str);
		writer.write("\r\n");//将写入的数据换行
		writer.close();//关闭字符输出流

	}

}
