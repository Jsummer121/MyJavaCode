package MenuClick;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 单机帮助菜单项事件
 */
public class helpClick {
	public helpClick() {
	JLabel label1 = new JLabel();
	JPanel panel = new JPanel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JDialog dialog = new JDialog(); 
	label1.setText("Dreamspy计算器硬性规定：");
	label2.setText("1、单一计算时，使用的是两个规定范围内的数字进行计算。");
	label3.setText("2、混合运算时，使用的是三个规定范围内的数字进行计算。");
	label4.setText("3、数值范围可选。");
//	label1.setFont(new Font("宋体", Font.BOLD, 20));
	panel.add(label1);
	panel.add(label2);
	panel.add(label3);
	panel.add(label4);
	dialog.add(panel);
	dialog.setModal(true);
	dialog.setSize(400,140);
	dialog.setLocationRelativeTo(null);
	dialog.setVisible(true);
	};
}
