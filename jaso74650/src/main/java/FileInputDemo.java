import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileInputDemo {
    
    private static FileInputDemoStream fi = new FileInputDemoStream();
    
    public static void main(String str[]) throws InterruptedException, FileNotFoundException, IOException {
        System.out.println("start");
        System.out.println("open stream");
        fi.createStream();
        for (int i=0; i < 10; i++) { 
            System.out.println(String.valueOf(i));
            fi.write("Counter: "+String.valueOf(i));
            Thread.sleep(10000);
        }
        System.out.println("cloes stream");
        fi.close();
        System.out.println("end");
    }
}
