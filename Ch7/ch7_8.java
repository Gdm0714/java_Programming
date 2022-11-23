package Ch7_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class PointManage extends JDialog {
    public JTextField name = new JTextField(5);
    public JTextField grade = new JTextField(5);
    private JButton btn = new JButton("입력");

    public PointManage(JFrame frame, String title) {
        super(frame, title, true);
        setLayout(new FlowLayout());
        add(name);
        add(grade);
        add(btn);
        setSize(200, 100);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public String getName() {
        if (name.getText().length() == 0) {
            return null;
        } else {
            return name.getText();
        }
    }

    public String getGrade() {
        if (grade.getText().length() == 0) {
            return "0";
        } else {
            return grade.getText();
        }
    }
}


public class ch7_8 extends JFrame {
    private HashMap<String, Integer> info = new HashMap<>();
    private JButton input = new JButton("정보 입력");
    private PointManage pm;

    public ch7_8() {
        setTitle("포인트 관리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pm = new PointManage(this, "정보 입력 창");

        input.addActionListener(new ActionListener() {
            String name;
            String grade;

            @Override
            public void actionPerformed(ActionEvent e) {
                pm.setVisible(true);
                name = pm.getName();
                grade = pm.getGrade();
                int point = Integer.parseInt(pm.getGrade());
                if (name == null && grade == "0") return;
                else {
                    if(info.get(name) == null){
                        info.put(name, point);
                    }
                    else{
                        info.put(name, info.get(name) + point);
                    }
                    Set<String> keys = info.keySet();
                    Iterator<String> it = keys.iterator();
                    while(it.hasNext()){
                        String key = it.next();
                        int value = info.get(key);
                        System.out.println("(" + key + "," + value + ")");
                    }
                }
                pm.name.setText("");
                pm.grade.setText("");
            }
        });
        getContentPane().add(input);
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ch7_8();
        System.out.println("** 포인트 관리 프로그램입니다 **");
    }
}
