import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class example04 {

	public static void main(String[] args) {
		// 创建一个名为GridLayout的窗体
		Frame f = new Frame("GridLayout");
		f.setLayout(new GridLayout(3,3));//设置该窗体为3*3的网格
		f.setSize(300,300);
		f.setLocation(200,300);
		//循环添加9个按钮到GridLayout中
		for(int i=1;i<=9;i++) {
			Button btn = new Button("btn"+i);
			f.add(btn);//向窗体中添加按钮
		}
		f.setVisible(true);
	}

}
