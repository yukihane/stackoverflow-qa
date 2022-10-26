import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class test {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("txt1.txt"));
            BufferedReader reader1 = new BufferedReader(new FileReader("txt2.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("txt3.txt"));

            String line;

            while (null != (line = reader.readLine())) {
                System.out.println(line);
            }

            String line1;
            while (null != (line1 = reader1.readLine())) {
                System.out.println(line1);
            }

            String line2;

            while (null != (line2 = reader2.readLine())) {
                System.out.println(line2);
            }

            reader.close();
            reader1.close();
            reader2.close();

            File file = new File("txt4.txt");
            File file1 = new File("txt5.txt");
            File file2 = new File("txt6.txt");
            file.createNewFile();
            file1.createNewFile();
            file2.createNewFile();
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            PrintWriter writer1 = new PrintWriter(new BufferedWriter(new FileWriter(file1)));
            PrintWriter writer2 = new PrintWriter(new BufferedWriter(new FileWriter(file2)));

            writer.println(line);
            writer1.println(line1);
            writer2.println(line2);

            writer.close();
            writer1.close();
            writer2.close();
        }

        catch (IOException e) {
        }

    }
}
