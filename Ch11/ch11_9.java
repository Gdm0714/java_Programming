import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch11_9 extends  JFrame{
    ImageIcon []icon = {new ImageIcon("images/가위.png"), new ImageIcon("images/바위.png"), new ImageIcon("images/보.png")};
    JLabel me = new JLabel("me");
    JLabel com = new JLabel("com");
    JLabel result = new JLabel("");
    JButton []b = new JButton[3];
    public ch11_9(){
        setTitle("가위 바위 보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        north.setBackground(Color.GRAY);
        for(int i = 0; i<3; i++) {
            b[i] = new JButton(icon[i]);
            north.add(b[i]);
            b[i].addActionListener(new MyAction(i));
        }
        c.add(north, BorderLayout.NORTH);
        center.add(me);
        center.add(com);
        center.add(result);
        c.add(center, BorderLayout.CENTER);
        setSize(1200, 600);
        setVisible(true);
    }

    class MyAction implements ActionListener{
        int index;
        MyAction(int index){
            this.index=index;
        }
        public void actionPerformed(ActionEvent e){
            int comse = (int)(Math.random()*3);
            me.setIcon(icon[index]);
            com.setIcon(icon[comse]);
            if(comse == 0){
                if(index == 0){
                    result.setText("Same !!!");
                }
                else if(index == 1){
                    result.setText("Me !!!");
                }
                else{
                    result.setText("Computer !!!");
                }
            }
            else if(comse == 1){
                if(index == 0){
                    result.setText("Computer !!!");
                }
                else if(index == 1){
                    result.setText("Same !!!");
                }
                else{
                    result.setText("Me !!!");
                }
            }
            else{
                if(index == 0){
                    result.setText("Me !!!");
                }
                else if(index == 1){
                    result.setText("Computer !!!");
                }
                else{
                    result.setText("Same !!!");
                }
            }
        }
    }

    public static void main(String[] args) {
        new ch11_9();
    }
}
