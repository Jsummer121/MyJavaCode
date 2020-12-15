import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class example12 {

	public static void main(String[] args) {
		Frame f = new Frame("MouseEvent");
		f.setLayout(new FlowLayout());
		f.setSize(300,200);
		f.setLocation(300,200);
		f.setVisible(true);
		Button btn = new Button("Button");
		f.add(btn);//将按钮添加到窗体
		//为按钮添加鼠标事件监听器
		btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked---鼠标点击事件");
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mousePressed---鼠标按下事件");
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased---鼠标放开事件");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered---鼠标进入按钮区域的事件");
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited---鼠标移出按钮区域的事件");
				
			}
			
		});
		

	}

}
