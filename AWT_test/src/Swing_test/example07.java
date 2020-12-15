package Swing_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * JComboBox组件
 *
 */
public class example07 extends JFrame{
	public example07() {
		//创建JPanel面板
		JPanel panel = new JPanel();
		//创建一个下拉列表框
		final JComboBox<String> comboBox = new JComboBox<String>();
		//为下拉列表框添加选择
		comboBox.addItem("请选择城市");
		comboBox.addItem("南阳");
		comboBox.addItem("杭州");
		comboBox.addItem("宁波");
		comboBox.addItem("上海");
		comboBox.addItem("广州");
		
		//创建文本框
		JTextField field = new JTextField(20);
		//添加组件到面板中
		panel.add(comboBox);
		panel.add(field);
		
		//为下拉列表框添加监听器
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				if("请选择城市".equals(item)) {
					field.setText("");
				}else {
					field.setText("您选择的城市是："+item);
				}
			}
		});
		
		//把面板添加到窗体上
		this.add(panel);
		this.setSize(350,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		}
	public static void main(String[] args) {
		new example07();
	}

}
