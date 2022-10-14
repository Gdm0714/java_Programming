import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ex11_11 extends JFrame {
    private JTextField tf = new JTextField(10);
    private Vector<String> v = new Vector<String>();
    private JList<String> nameList = new JList<String>(v);

    public ex11_11(){
        setTitle("리스트 변경 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JLabel jl = new JLabel("이름 입력 후<Enter> 키");
        c.add(jl);
        c.add(tf);
        v.add("황기태");
        v.add("이재문");
        nameList.setVisibleRowCount(5);
        nameList.setFixedCellWidth(100);
        c.add(new JScrollPane(nameList));
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField jt = (JTextField)e.getSource();
                v.add(jt.getText());
                jt.setText("");
                nameList.setListData(v);
            }
        });
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ex11_11();
    }
}
