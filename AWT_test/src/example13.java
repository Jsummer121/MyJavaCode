import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class example13 {
/**
 * 键盘监听
 */
	public static void main(String[] args) {
		Frame f = new Frame("KeyEvent");
		f.setLayout(new FlowLayout());
		f.setSize(400,300);
		f.setLocation(200,300);
		f.setVisible(true);
		
		TextField tf = new TextField(30);//创建一个文本框对象
		f.add(tf);
		
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();//返回所按按键对应的整数值
				//返回按键的字符串描述
				String s = KeyEvent.getKeyText(keyCode);
				//输出相关信息
				System.out.println("键盘输入的内容为"+s+",");
				System.out.println("对应的keyCode值为："+keyCode+",");
			}
			
		});
		//用匿名内部类实现窗口关闭
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
