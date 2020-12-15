import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class example03 {

	public static void main(String[] args) {
		//创建一个名为BorderLayout对的窗体
		Frame f = new Frame("BorderLayout");
		f.setLayout(new BorderLayout());//设置窗体中的布局管理器BorderLayout
		f.setSize(300,300);//设置大小
		f.setLocation(300,200);
		f.setVisible(true);
		//下面代码是创建五个按钮，分别用于填充BorderLayout的五个区域
		Button but1 = new Button("EAST");
		Button but2 = new Button("SOUTH");
		Button but3 = new Button("WEST");
		Button but4 = new Button("NORTH");
		Button but5 = new Button("CENTER");
		//将创建好的按钮添加到窗体中,并且设置按钮所在的区域
		f.add(but1,BorderLayout.EAST);
		f.add(but2,BorderLayout.SOUTH);
		f.add(but3,BorderLayout.WEST);
		f.add(but4,BorderLayout.NORTH);
		f.add(but5,BorderLayout.CENTER);
	}
}
