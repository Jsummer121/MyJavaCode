import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class example02 {
	public static void main(String[] args) {
		//创建一个FlowLayout的窗体
		Frame f = new Frame("FlowLayout");
		//设置窗体中的布局管理器FlowLayout，所有组件左对齐，水平间距为20，垂直间距为30
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
		//设置窗体大小
		f.setSize(300,200);
		//设置窗体的位置（左上角）
		f.setLocation(300,200);
		//把按钮添加到f对应的窗口中
		f.add(new Button("第一个按钮"));
		f.add(new Button("第二个按钮"));
		f.add(new Button("第三个按钮"));
		f.add(new Button("第四个按钮"));
		f.add(new Button("第五个按钮"));
		f.add(new Button("第六个按钮"));
		//设置窗体可见
		f.setVisible(true);
	}
}
