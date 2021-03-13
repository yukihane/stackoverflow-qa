import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

class FileInputDemoStream {

    private static File file = null;
    private static OutputStream os = null;
    private static FileOutputStream fos = null;

    public void createStream() throws InterruptedException, FileNotFoundException, IOException {
        System.out.println("start");
        String fileName = "demo.out";
        file = new File(fileName);
        fos = new FileOutputStream(file, true);
        os = new BufferedOutputStream(fos);
    }

    public void close() throws InterruptedException, FileNotFoundException, IOException {
        os.close();
    }

    public void write(String str) {
        try {
            System.out.println("ファイル存在確認：" + file.exists()); // falseになる
            System.out.println("ディスクリプタ：" + fos.getFD().valid()); // trueのまま
            Writer writer = new OutputStreamWriter(os);
            writer.write(str + "\n"); // エラーにならない
            writer.flush(); // エラーにならない
            fos.getFD().sync(); // エラーにならない
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}