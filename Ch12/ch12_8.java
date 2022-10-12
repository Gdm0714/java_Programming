import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ch11_8 extends JFrame {
    public ch11_8() {
        setTitle("마우스로 원 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(700, 400);
        setVisible(true);
    }

    class Circle {
        int x, y, w, h;

        public Circle(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }

    class MyPanel extends JPanel {
        Vector<Circle> vc = new Vector<Circle>();
        int fromx, fromy, tox, toy;

        public MyPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    fromx = e.getX();
                    fromy = e.getY();
                }
                public void mouseReleased(MouseEvent e){
                    tox = e.getX();
                    toy = e.getY();
                    int w, h;
                    w = tox-fromx;
                    h = toy-fromy;
                    if(w<0)w=-w;
                    if(h<0)h=-h;
                    vc.add(new Circle(fromx, fromy, w, h));
                    repaint();
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(int i = 0; i< vc.size(); i++){
                Circle c = vc.get(i);
                g.setColor(Color.MAGENTA);
                g.drawOval(c.x, c.y, c.w, c.h);
            }
        }
    }

    public static void main(String[] args) {
        new ch11_8();
    }
}
