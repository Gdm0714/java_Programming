package Ch13_3;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

class Timer extends Thread {
    private JLabel jl;

    public Timer(JLabel jl) {
        this.jl = jl;
    }
    public void run(){
        while(true) {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);

            String clockText = Integer.toString(hour);
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(min));
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(second));
            jl.setText(clockText);
        }
    }
}

public class ch13_3 extends JFrame{
    public ch13_3(){
        setTitle("디지탈 시계 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JLabel jl = new JLabel();
        jl.setFont(new Font("Gothic", Font.ITALIC, 80));
        c.add(jl);
        Timer timer = new Timer(jl);
        setSize(400, 300);
        setVisible(true);
        timer.start();
    }

    public static void main(String[] args) {
        new ch13_3();
    }
}
