import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class example05 {
/*
 * 文件的拷贝，使用缓冲区拷贝
 */
	public static void main(String[] args) throws Exception {
		//创建一个字节输入流，用于读取当前目录下source文件中的mp3文件
		InputStream in = new FileInputStream("source/姑娘.mp3");
		//创建字节输出流，将读取的数据写入当前目录下的target的mp3文件内
		OutputStream out = new FileOutputStream("target/测试2.mp3");
		//读数据
		//定义一个缓冲区数组
		long beginTime = System.currentTimeMillis();
		byte[] buff = new byte[1024];//定义一个字节数组，作为缓冲区
		int len;//定义int类型的变量len，记住读取读入缓冲区的字节数
		
		while((len = in.read(buff)) != -1) {//判断是否读到文件末尾
			//写数据
			out.write(buff,0 ,len);//从第一个字节开始，向文件写入len个字节
		}
		long endTime = System.currentTimeMillis();
		//关闭流
		in.close();
		out.close();
		System.out.println("拷贝文件所消耗的时间是"+(endTime-beginTime)+"毫秒");
	}
}
