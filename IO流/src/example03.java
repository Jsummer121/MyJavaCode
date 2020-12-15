import java.io.FileOutputStream;
import java.io.OutputStream;

public class example03 {
/*
 *使用FileOutputStream将数据以追加的形式写道文件的末尾 
 */
	public static void main(String[] args) throws Exception {
		//创建一个文件字节输出流
		OutputStream out = new FileOutputStream("example02.txt",true);
		String str = "欢迎你";
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			out.wait(b[i]);
		}
		out.close();
	}
}
