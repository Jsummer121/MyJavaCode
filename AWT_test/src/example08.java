import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class example08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建新窗体
		Frame f = new Frame("我的窗体");
		f.setSize(400,300);//设置窗体尺寸大小
		f.setLocation(300,200);//设置窗口的位置
		f.setVisible(true);//设置窗口的显示
		//为窗口组件注册监听器
		f.addWindowListener(new MyWindowListener());
	}

}

//创建MyWindowLinstener类实现WindowListener接口
class MyWindowListener implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 监听器监听事件对象作出处理
		Window window = e.getWindow();
		window.setVisible(false);
		//窗口的释放
		window.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
