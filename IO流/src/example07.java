import java.io.FileReader;

public class example07 {
/*
 * 用FileReader读文件中的字符
 */
	public static void main(String[] args) throws Exception {
		//创建一个FileReader对象，用来读取文件中的字符
		FileReader reader = new FileReader("reader.txt");
		//读数据
		int ch;//定义一个变量，用于记录读到的字符
		//循环判断，是否读取到了文件的末尾
		while( (ch = reader.read())!=-1) {
			System.out.println((char)ch);
		}
		reader.close();//关闭字符输入流
	}
}
