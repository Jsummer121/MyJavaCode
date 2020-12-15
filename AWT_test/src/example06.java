import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class cardLayout extends Frame implements ActionListener{
	CardLayout cardlayout = new CardLayout();//定义卡片布局管理器
	Panel cardPanel = new Panel();//定义面板，放置卡片内容
	Panel controlPanel = new Panel();//定义面板，放置按钮
	Button preButton;//声明切换到上一张卡片的按钮
	Button nextButton;//声明切换到下一张卡片的按钮
	public cardLayout() {
		this.setSize(300,200);//设置窗体大小
		cardPanel.setLayout(cardlayout);//设置布局为卡片布局管理器
		//在cardPanel中添加三个文本标签
		cardPanel.add(new Label("第一个界面",Label.CENTER));
		cardPanel.add(new Label("第二个界面",Label.CENTER));
		cardPanel.add(new Label("第三个界面",Label.CENTER));
		//创建两个按钮
		nextButton = new Button("下一张卡片");
		preButton = new Button("上一张卡片");
		//将按钮添加到controlButton面板中
		controlPanel.add(preButton);
		controlPanel.add(nextButton);
		//把面板添加到窗体中显示
		this.add(cardPanel,BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);//设置窗体显示
		
		//为按钮添加监听事件
		nextButton.addActionListener(this);
		preButton.addActionListener(this);
		
		//为窗口添加关闭事件监听器
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cardLayout.this.dispose();
			}
		});
	}
	//实现按钮的监听触发，并对触发实践做出相应的处理方式
	@Override
	public void actionPerformed(ActionEvent e) {
		//如果用户点击nextButton，执行操作
		if(e.getSource()== nextButton) {
			//切换cardPanel面板当前卡片，向后切换一张
			cardlayout.next(cardPanel);
		}
		if(e.getSource()== preButton) {
			cardlayout.previous(cardPanel);
		}
	}
	
}


public class example06 {
	public static void main(String[] args) {
		cardLayout layout = new cardLayout();
	}
}
