import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class example07{
	public static void main(String[] args) {
		Frame f = new Frame("不使用布局管理器");
		//取消当前窗体的不管理器
		f.setLayout(null);
		f.setSize(300,150);
		Button bt1 = new Button("press");
		Button bt2 = new Button("pop");
		//设置按钮显示的位置与大小
		bt1.setBounds(40, 60, 100, 30);
		bt2.setBounds(140, 90, 100, 30);
		f.add(bt1);
		f.add(bt2);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
}
