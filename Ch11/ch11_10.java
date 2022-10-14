import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch11_10 extends JFrame {
    JLabel [] jl = new JLabel[10];
    int count = 0;
    int x, y;
    public ch11_10(){
        setTitle("Ten 레이블 클릭");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        for(int i = 0; i<10; i++){
            x = (int)(Math.random()*500);
            y = (int)(Math.random()*500);
            jl[i] = new JLabel(Integer.toString(i));
            jl[i].setSize(10, 10);
            jl[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel label = (JLabel)e.getSource();
                    int num = Integer.parseInt(label.getText());
                    if(num == count){
                        label.setVisible(false);
                        count++;
                    }
                    if(count == 10){
                        reset();
                    }
                }
            });
            c.add(jl[i]);
        }
        reset();
        setSize(600, 600);
        setVisible(true);

    }
    public void reset(){
        count = 0;
        for(int i = 0; i<10; i++){
            x = (int)(Math.random()*600);
            y = (int)(Math.random()*600);
            jl[i].setLocation(x, y);
            jl[i].setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ch11_10();
    }
}
