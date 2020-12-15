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
	CardLayout cardlayout = new CardLayout();//���忨Ƭ���ֹ�����
	Panel cardPanel = new Panel();//������壬���ÿ�Ƭ����
	Panel controlPanel = new Panel();//������壬���ð�ť
	Button preButton;//�����л�����һ�ſ�Ƭ�İ�ť
	Button nextButton;//�����л�����һ�ſ�Ƭ�İ�ť
	public cardLayout() {
		this.setSize(300,200);//���ô����С
		cardPanel.setLayout(cardlayout);//���ò���Ϊ��Ƭ���ֹ�����
		//��cardPanel����������ı���ǩ
		cardPanel.add(new Label("��һ������",Label.CENTER));
		cardPanel.add(new Label("�ڶ�������",Label.CENTER));
		cardPanel.add(new Label("����������",Label.CENTER));
		//����������ť
		nextButton = new Button("��һ�ſ�Ƭ");
		preButton = new Button("��һ�ſ�Ƭ");
		//����ť��ӵ�controlButton�����
		controlPanel.add(preButton);
		controlPanel.add(nextButton);
		//�������ӵ���������ʾ
		this.add(cardPanel,BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);//���ô�����ʾ
		
		//Ϊ��ť��Ӽ����¼�
		nextButton.addActionListener(this);
		preButton.addActionListener(this);
		
		//Ϊ������ӹر��¼�������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cardLayout.this.dispose();
			}
		});
	}
	//ʵ�ְ�ť�ļ������������Դ���ʵ��������Ӧ�Ĵ���ʽ
	@Override
	public void actionPerformed(ActionEvent e) {
		//����û����nextButton��ִ�в���
		if(e.getSource()== nextButton) {
			//�л�cardPanel��嵱ǰ��Ƭ������л�һ��
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
