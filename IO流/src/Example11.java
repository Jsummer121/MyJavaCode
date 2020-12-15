import java.io.File;

public class Example11 {
/*
 * File常用方法
 */
	public static void main(String[] args) {
		File file = new File("test.txt");//创建file文件对象，表示一个文件
		//获取文件的名称
		System.out.println("文件名称："+file.getName());//test.txt
		//获取文件的路径
		System.out.println("文件的路径："+file.getPath());//test.txt
		//获取文件的绝对路径
		System.out.println("文件的绝对路径："+file.getAbsolutePath());//E:\javasy\IO流\test.txt
		//获取文件的父路径
		System.out.println("文件的父路径："+file.getParent());//null
		//判断文件的内容是否可读
		System.out.println(file.canRead() ? "文件可读":"文件不可读");//文件可读
		//判断文件内容是否可写
		System.out.println(file.canWrite() ? "文件可写":"文件不可写");//文件可写
		//判断当前文件是否是一个文件
		System.out.println(file.isFile() ?"是一个文件":"不是一个文件");//是一个文件
		//判断是否是文件夹
		System.out.println(file.isDirectory() ?"是一个目录":"不是一个目录");//不是一个目录
		//判断是否是一个绝对路径的编写
		System.out.println(file.isAbsolute() ?"是绝对路径":"不是绝对路径");//不是绝对路径
		//获得文件最后的修改时间
		System.out.println("最后修改时间为："+file.lastModified());
		//获得文件的大小
		System.out.println("文件大小为："+file.length()+"字节");
		//是否成功删除文件
		System.out.println("是否成功删除文件" + file.delete());
	}
}
