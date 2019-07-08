package lec0402;

import java.applet.Applet;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import lec0401Util.Keisan;

public class lec0402kadai extends Applet implements ActionListener, ItemListener {
        //フィールドの定義
        //パネル
        Panel plusPanel = new Panel();
        Panel minusPanel = new Panel();
        Panel multiplyPanel = new Panel();
        Panel dividePanel = new Panel();
        Panel answerPanel = new Panel();
        Panel operatorPanel = new Panel();

        //テキストフィールド
        TextField plusText1 = new TextField("", 4);
        TextField plusText2 = new TextField("", 4);
        TextField minusText1 = new TextField("", 4);
        TextField minusText2 = new TextField("", 4);
        TextField multiplyText1 = new TextField("", 4);
        TextField multiplyText2 = new TextField("", 4);
        TextField divideText1 = new TextField("", 4);
        TextField divideText2 = new TextField("", 4);
        TextField answerText = new TextField("", 4);

        //ボタン
        Button calcButton = new Button("=");

        //チェックボックス
        CheckboxGroup cgroup = new CheckboxGroup();
        Checkbox plusCheckbox  = new Checkbox("+", cgroup, true);
        Checkbox minusCheckbox = new Checkbox("-", cgroup, false);
        Checkbox multiplyCheckbox = new Checkbox("*", cgroup, false);
        Checkbox divideCheckbox   = new Checkbox("/", cgroup, false);
        Checkbox selected;

        // CardLayoutを適用するパネル
        Panel panel = new Panel();
        // (※layoutなのにpanelという命名はまぎらわしいです)
        CardLayout cardPanel = new CardLayout();

        public void init(){

            //plusPanelにFlowLayoutを設定しコンポーネントを登録する
            plusPanel.setLayout(new FlowLayout());
            plusPanel.add(plusText1);
            plusPanel.add(new Label("+"));
            plusPanel.add(plusText2);

            //minusPanelにFlowLayoutを設定しコンポーネントを登録する
            minusPanel.setLayout(new FlowLayout());
            minusPanel.add(minusText1);
            minusPanel.add(new Label("-"));
            minusPanel.add(minusText2);

            //multiplyPanelにFlowLayoutを設定しコンポーネントを登録する
            multiplyPanel.setLayout(new FlowLayout());
            multiplyPanel.add(multiplyText1);
            multiplyPanel.add(new Label("*"));
            multiplyPanel.add(multiplyText2);

            //dividePanelにFlowLayoutを設定しコンポーネントを登録する
            dividePanel.setLayout(new FlowLayout());
            dividePanel.add(divideText1);
            dividePanel.add(new Label("/"));
            dividePanel.add(divideText2);

            //answerPanelにFlowLayoutを設定しコンポーネントを登録する
            answerPanel.setLayout(new FlowLayout());
            answerPanel.add(calcButton);
            answerPanel.add(answerText);

            //operatorパネルにFlowLayoutを設定しコンポーネントを登録する
            operatorPanel.setLayout(new FlowLayout());
            operatorPanel.add(plusCheckbox);
            operatorPanel.add(minusCheckbox);
            operatorPanel.add(multiplyCheckbox);
            operatorPanel.add(divideCheckbox);

            //レイアウトマネージャの設定
            panel.setLayout(cardPanel);
            panel.add(plusPanel,"card1");
            panel.add(minusPanel,"card2");
            panel.add(multiplyPanel,"card3");
            panel.add(dividePanel,"card4");

            plusCheckbox.addItemListener(this);
            minusCheckbox.addItemListener(this);
            multiplyCheckbox.addItemListener(this);
            divideCheckbox.addItemListener(this);
            cardPanel.first(panel);

            //アプレットにGridLayoutを設定し，パネルを登録し配置していく
            setLayout( new GridLayout(2, 2) );
            add(panel);
            add(answerPanel);
            add(operatorPanel);
            //ダミーのパネルを配置する
            add( new Panel() );

            //ボタンをリスナーとして登録する
            calcButton.addActionListener(this);

            //define contents of on/off which has object(register events)
            plusCheckbox.addItemListener(this);
            minusCheckbox.addItemListener(this);
            multiplyCheckbox.addItemListener(this);
            divideCheckbox.addItemListener(this);

        }

        public void actionPerformed(ActionEvent e) {

            //選択されているチェックボックスを取得する
            Checkbox selected = cgroup.getSelectedCheckbox();

            //選択されている演算に応じて，計算を行う
            if (selected == plusCheckbox) {
                //数値を取得する
                double v1 = Double.parseDouble( plusText1.getText() );
                double v2 = Double.parseDouble( plusText2.getText() );
                //Keisanクラスを2つの数値を渡して生成する
                Keisan k = new Keisan(v1, v2);
                //計算結果を表示する
                answerText.setText( String.valueOf( k.plus() ) );
            }
            else if (selected == minusCheckbox) {
                double v1 = Double.parseDouble( minusText1.getText() );
                double v2 = Double.parseDouble( minusText2.getText() );
                Keisan k = new Keisan(v1, v2);
                answerText.setText( String.valueOf( k.minus() ) );
            }
            else if (selected == multiplyCheckbox) {
                double v1 = Double.parseDouble( multiplyText1.getText() );
                double v2 = Double.parseDouble( multiplyText2.getText() );
                Keisan k = new Keisan(v1, v2);
                answerText.setText( String.valueOf( k.multiply() ) );
            }
            else if (selected == divideCheckbox) {
                double v1 = Double.parseDouble( divideText1.getText() );
                double v2 = Double.parseDouble( divideText2.getText() );
                Keisan k = new Keisan(v1, v2);
                answerText.setText( String.valueOf( k.divide() ) );
            }
        }

        //excute contents of on/off
        public void itemStateChanged(ItemEvent e) {
            Checkbox selected = cgroup.getSelectedCheckbox();

            if(selected == plusCheckbox){
                cardPanel.show(panel,"card1");
            }else if (selected == minusCheckbox){
                cardPanel.show(panel,"card2");
           }else if (selected == multiplyCheckbox){
               cardPanel.show(panel,"card3");
            }else if (selected == divideCheckbox){
                cardPanel.show(panel, "card4");
            }
        }
}