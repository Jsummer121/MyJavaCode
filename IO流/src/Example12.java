import java.io.File;

public class Example12 {
/*
 * List方法演示
 */
	public static void main(String[] args) {
		//创建一个file对象
		File file = new File("E:\\javasy");
		//判断当前file对象是否是文件夹
		if(file.isDirectory()) {
			//获取目录下所有文件的文件名
			String[] names = file.list();
			for (String name : names) {
				System.out.println(name);
			}
		}
	}

}
