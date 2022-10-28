package Ch13_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyPanel extends JPanel {


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        int x = (int) (Math.random() * 400);
        int y = (int) (Math.random() * 400);
        g.drawOval(x, y, 50, 50);
    }
}
class Circle extends Thread {
    private MyPanel panel;

    public Circle(MyPanel panel) {
        this.panel = panel;
    }
    public void run(){
        while(true){
            try{
                panel.repaint();
                sleep(500);
            }
            catch (InterruptedException e){
                return;
            }
        }
    }
}



public class ch13_2 extends JFrame{
    private MyPanel panel = new MyPanel();
    private Circle c;
    public ch13_2(){
        setTitle("원을 0.5초 간격으로...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        panel.setLayout(null);
        setSize(400, 400);
        setVisible(true);
        c = new Circle(panel);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.start();
            }
        });

    }

    public static void main(String[] args) {
        new ch13_2();
    }
}
