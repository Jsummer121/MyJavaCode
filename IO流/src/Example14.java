import java.io.File;

public class Example14 {
/*
 * 删除指定目录
 */
	public static void main(String[] args) {
		//创建一个File对象，代表一个目录
		File file = new File("E:\\javasy\\IO流\\test");
		file.delete();
	}
}
