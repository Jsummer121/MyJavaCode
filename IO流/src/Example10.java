import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 转换流：将字节流转换为字符流
 */
public class Example10 {
	public static void main(String[] args) throws Exception {
		//指定输入流
		FileInputStream in = new FileInputStream("reader.txt");//创建字节输入流
		InputStreamReader isr = new InputStreamReader(in);//将字节输入流转化字符输入流
		BufferedReader br = new BufferedReader(isr);
		//指定输出流
		FileOutputStream out = new FileOutputStream("example10.txt");//创建字节输出流
		OutputStreamWriter osw = new OutputStreamWriter(out);//将字节输出流转化成字符输出流
		BufferedWriter bw = new BufferedWriter(osw);
		//读数据
		String line = null;
		while((line = br.readLine())!=null) {
			//写入数据
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//关闭流
		br.close();
		bw.close();
	}
}
