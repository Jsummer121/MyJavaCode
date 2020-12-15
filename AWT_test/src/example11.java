import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class example11 {
/**
 * 窗口事件
 */
	public static void main(String[] args) {
		Frame f = new Frame("windowEvent");
		f.setSize(400,300);
		f.setLocation(300,200);
		f.setVisible(true);
		//使用内部类创建WindowListener对象，监听窗体事件
		f.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("WindowOpened --- 窗体打开激活事件");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing --- 窗体正在执行关闭时的操作");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("windowClosed --- 窗口关闭事件");
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("windowIconified --- 窗体图标化事件（最小化）");
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("windowDeiconified --- 窗体取消图标化事件");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated --- 窗体激活事件");
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("windowDeactivated--窗体停用事件");
			}
		});
	}
}
