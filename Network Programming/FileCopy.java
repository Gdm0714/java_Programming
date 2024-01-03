import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws Exception {
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(System.out);
        PrintStream out2 = new PrintStream("test.txt");

        String data = "";
        while (!(data = keyIn.readLine()).equals("quit")) {
            out2.println(data);
            out.println(data);
        }


        BufferedReader fileReader = new BufferedReader(new FileReader("test.txt"));
        String line;
        while ((line = fileReader.readLine()) != null) {
            out.println(line);
        }
        fileReader.close();
        out2.close();
        keyIn.close();
        out.close();
    }
}
