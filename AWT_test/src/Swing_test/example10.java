package Swing_test;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * JTable
 */
public class example10 extends JFrame{
	public example10() {
		init();//使用JTable对象创建表格
	}
	
	//使用JTable对象创建表格
	public void init() {
		//定义一个一维数组,作为列的标题
		Object[] columnTitle = {"姓名","年龄","性别"};
		//定义一个二维数组，作为表格行对象的数据
		Object[][] tableData = {
				new Object[] {"李清照","29","女"},
				new Object[] {"summer","20","男"},
				new Object[] {"茉莉","20","女"},
				new Object[] {"李白","38","男"},
		};
		//创建表格
		JTable table = new JTable(tableData,columnTitle);
		//添加表格组件到窗体上
		this.add(new JScrollPane(table));
		//设置自适应窗体大小
		this.pack();
		this.setTitle("简单的表格");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new example10();
	}

}
