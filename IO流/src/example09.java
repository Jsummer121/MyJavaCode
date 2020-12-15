import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class example09 {
/*
 * BufferedReader和BufferedWriter完成文件复制
 * 在BufferedReader中有一个方法：
 * 		public String readLine（） 读一行字符串
 * 在BufferedWriter中的方法：
 * 		public void newLine（） 写入一个换行符
 */
	public static void main(String[] args) throws Exception {
		//创建一个BufferedReader缓冲对象，用于读文件中的数据
		BufferedReader in = new BufferedReader(new FileReader("test.txt"));
		//创建一个BufferedWriter缓冲对象，用于写文件数据
		BufferedWriter out = new BufferedWriter(new FileWriter("example09.txt"));
		//读数据
		String line = null;
		//每次读一行，判断是否读到文件末尾
		while((line = in.readLine()) != null) {
			//写数据
			out.write(line);
			out.newLine();//写入一个换行符，该方法会根据不同的操作西游生成相应的换行符号
			out.flush();//刷新
		}
		//关闭流，释放对应的资源
		in.close();
		out.close();
	}
}
