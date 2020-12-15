package App;

import javax.swing.JFrame;

import mainFrame.mainJFrame;

public class mainApp extends JFrame{
	public mainApp() {
		new mainJFrame().setVisible(true);;
	}
	public static void main(String[] args) {
		new mainApp();
	}
}
