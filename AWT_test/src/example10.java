import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 用匿名内部类实现事件处理
 */
public class example10 {

	public static void main(String[] args) {
		Frame f = new Frame("匿名内部类实现事件处理");
		f.setSize(400,300);
		f.setLocation(300,200);
		f.setVisible(true);
		Button bt1 = new Button("EXIT");
		f.add(bt1);
		//用匿名内部类的方法实现为按钮注册监听器
		bt1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
