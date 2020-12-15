import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class example14 {
/**
 * AWT绘图
 */
	public static void main(String[] args) {
		Frame frame = new Frame("验证码");
		Panel panel = new MyPanel();
		frame.add(panel);
		frame.setSize(200,100);
		//将frame窗口居中
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		
		//利用匿名内部类实现关闭操作
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

class MyPanel extends Panel {
	@Override
	public void paint(Graphics g) {
		int width = 160;//定义验证码所对应的图片宽度
		int height = 40;//定义验证码图片的高度
		g.setColor(Color.LIGHT_GRAY);//设置画笔颜色
		//绘制验证码的背景
		g.fillRect(0, 0, width-1, height-1);
		//设置画笔颜色
		g.setColor(Color.BLACK);
		//设置边框
		g.drawRect(0, 0, width, height);
		//绘制干扰点
		Random r = new Random();
		for(int i=0;i<100;i++) {
			int x = r.nextInt(width) -2;
			int y = r.nextInt(height)-2;
			g.drawOval(x, y, 2, 2);
		}
		//设置验证码字体
		g.setFont(new Font("黑体",Font.BOLD,30));
		//设置验证码文字颜色
		g.setColor(Color.red);
		//产生随机验证码操作
		StringBuffer sb = new StringBuffer();
		char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < 4; i++) {
			int pos = r.nextInt(chars.length);
			char c = chars[pos];
			sb.append(c+" ");
		}
		//绘制验证码字符串文字
		g.drawString(sb.toString(), 20, 30);
	}
}
