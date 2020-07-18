package sarver1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient1 {
    public static void main(String[] args)throws Exception{
        try(Socket socket=new Socket("localhost",80);
                FileInputStream fis=new FileInputStream("Client_Send.txt");
                FileOutputStream fos=new FileOutputStream("Client_Recv.txt")){

            int ch;
            //Client_Send.txtの内容をサーバに送信
            OutputStream output=socket.getOutputStream();//ストリームを取得し、ここから読み書きする。
            while((ch=fis.read())!=-1) {
                //ストリームを通して出力していく
                output.write(ch);
            }
            System.out.println("送信しました");
            //終了するため0を送信
            //output.write(0);

            //サーバーからの返信をClient_Recv.txtに出力
            InputStream input=socket.getInputStream();//ストリームを取得し、ここから読み書きする。
            while((ch=input.read())!=-1) {
                fos.write(ch);
            }
            System.out.println("受けとりました");
        }catch(Exception ex) {
                ex.printStackTrace();
        }
    }
}