import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class example04 {
/*
 * 文件的拷贝
 */
	public static void main(String[] args) throws Exception {
		//创建一个字节输入流，用来读取当前目录source文件夹中的mp3文件
		InputStream in = new FileInputStream("source/姑娘.mp3");
		//创建字节输出流，用于将读取的数据写入到当前目录的target文件夹中
		OutputStream out = new FileOutputStream("target/测试.mp3");
		//读数据
		int len;//用于记录每次读取的一个字节
		long beginTime = System.currentTimeMillis();//获取拷贝文件前的系统时间
		//写数据到文件
		while((len = in.read())!= -1) {
			//写数据到文件中
			out.write(len);
		}
		long endTime = System.currentTimeMillis();//获取拷贝后的系统时间
		//关闭流
		in.close();
		out.close();
		System.out.println("本次拷贝一共用时："+(endTime-beginTime)+"ms");
	}

}
