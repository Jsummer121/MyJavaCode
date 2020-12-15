import java.awt.Frame;

public class Example01 {

	public static void main(String[] args) {
		//建立新窗体对象
		Frame f = new Frame("我的第一个窗体!");
		//设置窗体的宽度和高度
		f.setSize(400,300);
		//设置窗体在屏幕中所处位置（参数是窗口左上角的坐标）
		f.setLocation(300,200);
		//设置窗体可见
		f.setVisible(true);
	}
}
