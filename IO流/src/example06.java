import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class example06 {
/*
 * BufferdInputStream 和BufferdOutputStream这两个流的用法
 */
	public static void main(String[] args) throws Exception {
		//创建一个缓冲区的输入流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.txt"));
		//创建一个带缓冲区的输出流
		BufferedOutputStream bos  = new BufferedOutputStream(new FileOutputStream("example06.txt"));
		//读数据
		int len;
		while((len = bis.read())!= -1) {
			//写数据
			bos.write(len);
		}
		//关闭流
		bis.close();
		bos.close();
	}

}
