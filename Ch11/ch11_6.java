import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class ch11_6 extends JFrame {
	public ch11_6() {
		setTitle("TextArea Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JTextArea jta = new JTextArea("");
		JSlider js = new JSlider(0, 100, 0);
		js.setMajorTickSpacing(20);//Å« ´«±Ý
		js.setMinorTickSpacing(5);//ÀÛÀº ´«±Ý
		js.setPaintTicks(true);
	
		js.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider js2 = (JSlider) e.getSource();
				String text = jta.getText();
				if (text.length() <= js.getValue()) {
					js.setValue(text.length());
				} else {
					jta.setText(text.substring(0, js2.getValue()));
					;
				}
			}
		});
		jta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				JTextArea jt = (JTextArea) e.getSource();
				String text = jt.getText();
				if (text.length() < 100) {
					js.setValue(text.length());
				}
				else {
					text = text.substring(0, 100);
					jta.setText(text);
				}
			}
		});
		c.add(jta, BorderLayout.CENTER);
		c.add(js, BorderLayout.SOUTH);
		setSize(600, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ch11_6();
	}
}
