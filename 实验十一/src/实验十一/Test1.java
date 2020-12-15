package 实验十一;

import java.io.File;

public class Test1 {
	public static void main(String[] args) {
		File file = new File("test.txt");//创建file文件对象，表示一个mingweitest.txt的文件
		System.out.println("文件已经创建");
		//获取文件的名称
		System.out.println("文件名称："+file.getName());//test.txt
		//获取文件的路径
		System.out.println("文件的路径："+file.getPath());//test.txt
		file.delete();//将文件删除
		
		//获取E盘的javasy文件中的所有文件
		File read_file = new File("E:\\javasy");
		if(read_file.isDirectory()) {
			//获取目录下所有文件的文件名
			String[] names = read_file.list();
			for (String name : names) {
				System.out.println(name);
			}
		
	    }
	}
}
