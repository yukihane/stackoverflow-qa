package renshu1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Renshu2 extends Application {
    private Label lb1, lb2;
    private Button bt1, bt2, bt3;
    private BorderPane bp;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        lb1 = new Label("背景色を選んでください。");
        lb2 = new Label("");
        bt1 = new Button("Cyan");
        bt2 = new Button("Yellow");
        bt3 = new Button("Pink");

        bp = new BorderPane();
        HBox hb = new HBox();

        hb.getChildren().add(bt1);
        hb.getChildren().add(bt2);
        hb.getChildren().add(bt3);
        hb.setAlignment(Pos.CENTER);

        bp.setTop(lb1);
        bp.setBottom(lb2);
        bp.setCenter(hb);

        //イベントハンドラの登録
        bt1.setOnAction(new SampleEventHandler());
        bt2.setOnAction(new SampleEventHandler());
        bt3.setOnAction(new SampleEventHandler());

        Scene sc = new Scene(bp, 300, 200);

        stage.setScene(sc);

        stage.setTitle("背景色の変化");
        stage.show();
    }

    class SampleEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            Button tmp = (Button) e.getSource();
            lb2.setText(tmp.getText() + "が選ばれました。");
            if (tmp == bt1)
                bp.setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
            else if (tmp == bt2)
                bp.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
            else if (tmp == bt3)
                bp.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));

        }

    }

    // TODO 自動生成されたメソッド・スタブ

}
