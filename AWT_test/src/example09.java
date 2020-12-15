import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class example09 {
	public static void main(String[] args) {
		Frame f = new Frame("继承适配器");
		f.setSize(400,300);
		f.setLocation(200,300);
		f.setVisible(true);
		//为窗口组件注册监听器
		f.addWindowListener(new MyWindowListener02());
	}
}

class MyWindowListener02 extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}