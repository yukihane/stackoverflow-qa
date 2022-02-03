package zip_with_password;

import java.io.File;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class Test {

    public static void main(String[] args) {
        // 圧縮用パラメーター
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
         
        try {
            String outputPath = args[0];
            String password = args[1];
            System.out.println("get outputPath : " + outputPath); // debug
            System.out.println("get password : " + password); // debug
         
            // ZipFileインスタンスを生成します。
            // コンストラクタの引数に、"出力先" と "パスワード" を指定します。
            @SuppressWarnings("resource")
            ZipFile zipFile = new ZipFile(outputPath, password.toCharArray());
            // 圧縮するファイルをパスで指定
            String inputPath = args[2];
            System.out.println("get inputPath : " + inputPath); // debug
            File folder = new File(inputPath);
            zipFile.addFolder(folder, zipParameters);                       
                
            
        } catch (Exception e) {
            // 例外処理
            e.printStackTrace();
        }
        
        System.out.println("end"); // debug
    }

}

