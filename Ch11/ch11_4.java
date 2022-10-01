import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch11_4 extends JFrame {
	public ch11_4() {
		setTitle("Money Changer with CheckBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.setBackground(Color.PINK);
		JLabel jl = new JLabel("금액");
		JTextField jt = new JTextField(10);
		JButton jb = new JButton("계산");
		int[] money = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };
		String[] price = { "오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원" };
		JTextField[] result = new JTextField[8];
		JCheckBox[] jc = new JCheckBox[7];
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		JPanel center = new JPanel();
		north.setBackground(Color.PINK);
		south.setBackground(Color.PINK);
		west.setBackground(Color.PINK);
		center.setBackground(Color.PINK);
		east.setBackground(Color.PINK);
		north.add(jl);
		north.add(jt);
		north.add(jb);
		jb.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int total = Integer.parseInt(jt.getText());
				for (int i = 0; i < 7; i++) {
					if (jc[i].isSelected()) {
						result[i].setText(Integer.toString(total / money[i]));
						total %= money[i];
					} else {
						result[i].setText("0");
					}
				}
				result[7].setText(Integer.toString(total));
			}
		});
		c.add(north, BorderLayout.NORTH);
		JLabel [] pri = new JLabel[8];
		center.setLayout(new GridLayout(8, 3));
		for (int i = 0; i < 8; i++) {
			pri[i] = new JLabel(price[i]);
			pri[i].setHorizontalAlignment(pri[i].RIGHT);
			result[i] = new JTextField();
			center.add(pri[i]);
			center.add(result[i]);
			if(i<7) {
				jc[i] = new JCheckBox();
				center.add(jc[i]);
				jc[i].setBackground(Color.PINK);
			}
		}
		c.add(center, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
		
		c.add(south, BorderLayout.SOUTH);
		c.add(west, BorderLayout.WEST);
		c.add(east, BorderLayout.EAST);
	}
	public static void main(String[] args) {
		new ch11_4();
	}
}
