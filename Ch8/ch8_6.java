package Ch8_6;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ch8_6 extends JFrame {
    private JTextField jtf = new JTextField();
    public ch8_6(){
        setTitle("텍스트 파일 합치기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(jtf);
        createMenu();
        setSize(300, 300);
        setVisible(true);
    }
    public void createMenu(){
        JMenuBar jb = new JMenuBar();
        JMenu jm = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        open.addActionListener(new OpenActionListener());
        save.addActionListener(new SaveActionListener());
        jm.add(open);
        jm.add(save);
        jb.add(jm);
        setJMenuBar(jb);
    }

    class OpenActionListener implements ActionListener{
        private JFileChooser chooser;
        private File f;
        private FileReader fr;
        BufferedReader br = null;
        String text;
        public OpenActionListener() {
            chooser = new JFileChooser();
            text = "";
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter= new FileNameExtensionFilter("텍스트 파일 (*.txt)",
                    "txt");
            chooser.setFileFilter(filter);
            int ret = chooser.showOpenDialog(null);
            if(ret != JFileChooser.APPROVE_OPTION){
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String filePath = chooser.getSelectedFile().getPath();
            try{
                f = new File(filePath);
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                while(true){
                    String s = br.readLine();
                    if(s == null){
                        break;
                    }
                    text += s;
                }
                fr.close();
            }catch (IOException i){
                System.out.println("입출력 오류");
            }
            jtf.setText(jtf.getText() + text);
            pack();
        }
    }

     class SaveActionListener implements ActionListener{
         private JFileChooser chooser;
         private File f;
         private FileWriter fw;
         String text;
         public SaveActionListener() {
             chooser = new JFileChooser();
             text = "";
         }
         @Override
         public void actionPerformed(ActionEvent e) {

             try{
                 fw = new FileWriter("appended.txt");
                 String text = jtf.getText();
                 fw.write(text, 0, text.length());
                 fw.close();
             }catch (IOException i){
                 System.out.println("입출력 오류");
             }
             jtf.setText(jtf.getText() + text);
             pack();
         }
     }

    public static void main(String[] args) {
        new ch8_6();
    }
}
