import java.io.FileInputStream;

public class Example01 {
/**
 * 字节流对文件数据的读取
 * @throws Exception 
 */
	public static void main(String[] args) throws Exception {
		//创建一个文件字节输入流
		FileInputStream in = new FileInputStream("test.txt");
		//定义一个int类型的变量b，记住每次读取的一个字节
		int b = 0;
		while(true) {
			b = in.read();//变量b记住读的每个字节
			if (b == -1) {//如果读取的字节为-1，说明读取完毕
				break;//跳出循环
			}
			System.out.println(b);
		}
		//关闭，释放系统资源
		in.close();
	}

}
