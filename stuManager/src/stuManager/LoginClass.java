package stuManager;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;

/**
 * 
 * Title: ��¼�� 
 * Description: ��½ģ�飬����������
 */

public class LoginClass {
	boolean packFrame = false;

	public LoginClass() {
		LoginFrame frame = new LoginFrame();
		if (packFrame) {
			frame.pack();
		} else {
			frame.validate();
		}
		// ���������С
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		;
		frame.setVisible(true);
	}

	// ������
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				new LoginClass();
			}
		});
	}
}
