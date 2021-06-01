package lesson4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleP2 extends Application {
    private Label lb;
    private CheckBox ch;
    private Image im;
    private ImageView iv;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage)throws Exception
    {
        Label lb = new Label("This is me");
        CheckBox ch = new CheckBox("画像の表示");
        im = new Image(getClass().getResourceAsStream("1414406%20.jpg"));
        iv = new ImageView(im);

        lb.setGraphic(new ImageView(im));

        BorderPane bp = new BorderPane();

        bp.setCenter(lb);
        bp.setBottom(ch);

        lb.setAlignment(Pos.CENTER);
        bp.setCenter(lb);
        //イベントハンドラの登録
        ch.setOnAction(new SampleEventHandler());

        Scene sc =new Scene(bp,500,500);

        stage.setScene(sc);

        stage.setTitle("サンプル");
        stage.show();
    }

    class SampleEventHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e) {
            CheckBox tmp = (CheckBox)e.getSource();
            if(tmp.isSelected() == true) {
                lb.setGraphic(iv);
            }
            else if(tmp.isSelected() == false) {
                lb.setGraphic(null);
            }
        }
        // TODO 自動生成されたメソッド・スタブ

    }

}
