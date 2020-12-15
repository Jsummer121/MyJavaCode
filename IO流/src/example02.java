import java.io.FileOutputStream;

/*
 * 使用FileOutPutStream将文件写入文件
 */
public class example02 {
	public static void main(String[] args) throws Exception {
		//创建一个文件字节输入流
		FileOutputStream out = new FileOutputStream("example02.txt");
		String str = "summer";
		byte[] b = str.getBytes();//将字符串变成字节
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}
		out.close();
	}
}
