import java.io.File;
import java.io.FilenameFilter;

public class Example13 {
/*
 * 遍历指定目录下，所有扩展名为.txt的文件
 */
	public static void main(String[] args) {
		//创建一个File当对象
		File file = new File("E:\\javasy\\IO流");
		//创建一个过滤器对象
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//dir 代表文件的父路径
				//name 代表文件的名称
				File currentFile = new File(dir,name);
				//如果文件名以.txt结尾，返回true，否则返回false
				if(currentFile.isFile() && name.endsWith(".txt")) {
					return true;
				}else {
					return false;
				}
			}
		};
		//获取过滤后的所有文件名的数组信息
		String[] names = file.list(filter);
		for(String name:names) {
			System.out.println(name);
		}
	}
}
