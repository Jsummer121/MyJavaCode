package andiroidTest;

import java.io.File;
import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		File file = new File("AndroidTest2/2/androidtext2.txt");
		System.out.println(file.getParentFile().exists());
		System.out.println(file.exists());
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(file.exists());
	}

}
