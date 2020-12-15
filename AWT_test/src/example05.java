import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

//网格包布局管理器

class Layout extends Frame{
	public Layout(String title) {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();//约束对象
		this.setLayout(layout);//设置布局管理器
		c.fill = GridBagConstraints.BOTH; //设置组件横向纵向可以拉伸
		c.weightx = 1;//设置横向权重为1
		c.weighty = 1;//设置纵向权重为1
		//增加组件
		this.addComponent("btn1",layout,c);
		this.addComponent("btn2",layout,c);
		this.addComponent("btn3",layout,c);
		c.gridwidth = GridBagConstraints.REMAINDER;//添加的组件是本行的最后一个组件
		this.addComponent("btn4",layout,c);
		c.weightx = 0;//设置纵向权重为0
		c.weighty = 0;//设置纵向权重为0
		this.addComponent("btn5",layout,c);
		c.gridwidth = 1;//设置组件跨一个网格（默认值）
		this.addComponent("btn6",layout,c);
		c.gridwidth = GridBagConstraints.REMAINDER;//添加的组件是本行的最后一个组件
		this.addComponent("btn7",layout,c);
		c.gridwidth = 1;//设置组件跨2个网格
		c.gridheight = 2;////设置组件跨一个网格（默认值）
		c.weightx = 2;//设置纵向权重为2
		c.weighty = 2;//设置纵向权重为2
		this.addComponent("btn8",layout,c);
		c.gridwidth = GridBagConstraints.REMAINDER;//添加的组件是本行的最后一个组件
		c.gridheight = 1;//设置组件跨1个网格
		this.addComponent("btn9",layout,c);
		this.addComponent("btn10",layout,c);
		
		
		this.setTitle(title);//设置窗体的标题
		this.pack();//设置自动窗体大小
		this.setVisible(true);
	}
	
	
	//添加组件的方法，通过指定的约束，将组件添加到布局管理器中
	public void addComponent(String name,GridBagLayout layout,GridBagConstraints c) {
		Button bt = new Button(name);//创建一个名为name的按钮
		layout.setConstraints(bt, c);//设置约束对象和按钮的关联
		this.add(bt);
	}
}
public class example05 {
	public static void main(String[] args) {
		new Layout("GridBagLayout");
	}
}
