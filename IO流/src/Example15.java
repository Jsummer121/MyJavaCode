import java.io.File;

public class Example15 {
/*
 * 删除带有文件的文件夹
 */
	public static void main(String[] args) {
		File file = new File("E:\\javasy\\IO流\\test");
		//调用deleteDir方法
		deleteDir(file);
		file.delete();
	}
	//定义删除文件夹的方法
	public static void deleteDir(File dir) {
		//判断传入的dir是否存在
		if(dir.exists()) {
			//获取当前目录中所有的file对象
			File[] files = dir.listFiles();
			//遍历所有的子目录和文件信息
			for(File file:files) {
				if(file.isDirectory()) {
					//如果是文件夹，递归调用deletedir方法
					deleteDir(file);
				}else {
					//如果是文件，直接删除
					file.delete();
				}
			}
			//删除完目录中的所有文件后，删除目录
			dir.delete();
		}
	}
}
