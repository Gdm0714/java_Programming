import javax.swing.*;
import java.awt.*;

public class ch11_10 extends JFrame {
    public ch11_10() {
        setTitle("그래픽 이미지 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(600, 600);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        ImageIcon icon = new ImageIcon("images/photo.jpg");
        Image img = icon.getImage();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            int iw = img.getWidth(this);
            int ih = img.getHeight(this);
            g.drawImage(img, 0, 0, w/2-5, h/2-5, 0, 0, iw/2-5, ih/2-5, this);
            g.drawImage(img, w/2+5, 0, w, h/2-5, iw/2-5, 0, iw, ih/2-5, this);
            g.drawImage(img, 0, h/2+5, w/2-5, h, 0, ih/2+5, iw/2-5, ih, this);
            g.drawImage(img, w/2+5, h/2+5, w, h, iw/2+5, ih/2+5, iw, ih, this);
        }
    }

    public static void main(String[] args) {
        new ch11_10();
    }
}
