package com.example.jaso94722;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Jaso94722Application {

    public static void main(String[] args) {
        SpringApplication.run(Jaso94722Application.class, args)
                .getBean(Jaso94722Application.class).execute();
    }

    @Autowired
    QuizRepository repository;

    /**
     * 実行メソッド
     */
    private void execute() {
        //登録処理
        setup();
        //全件取得
        //showList();
        //１件取得
        //showOne();
        //更新処理
        //updateQuiz();
        //削除処理
        //deleteQuiz();
    }

    /**
     * === クイズを２件登録します ===
     */
    private void setup() {
        //エンティティ生成
        Quiz quiz1 = new Quiz(null, "「Spring」はフレームワークですか？", true, "登録太郎");
        //登録実行
        quiz1 = repository.save(quiz1);
        //登録確認
        System.out.println("登録したデータは、" + quiz1 + "です。");
        //エンティティ生成
        Quiz quiz2 = new Quiz(null, "「Spring MVC」はバッチ処理機能を提供しますか？", false, "登録太郎");
        //登録実行
        quiz2 = repository.save(quiz2);
        //登録確認
        System.out.println("登録したデータは、" + quiz2 + "です。");
    }

    /**
     * === 前権取得 ===
     */
    private void showList() {
        System.out.println("--- 前権取得開始 ----");
        // リポジトリを仕様して前権取得を実施、結果を取得
        Iterable<Quiz> quizzes = repository.findAll();
        for (Quiz quiz : quizzes) {
            System.out.println(quiz);
        }
        System.out.println("--- 全権取得完了 ---");
    }

    /**
     * === １件取得 ===
     */
    private void showOne() {
        System.out.println("--- 1件取得開始 ---");
        //リポジトリを使用して１件取得を実施、結果を取得(戻り値はOptional)
        Optional<Quiz> quizOpt = repository.findById(1);
        //値存在チェック
        if (quizOpt.isPresent()) {
            System.out.println(quizOpt.get());
        } else {
            System.out.println("該当する問題が存在しません・・・");
        }
        System.out.println("--- １件取得完了 ---");
    }

    /**
     * === 更新処理 ===
     */
    private void updateQuiz() {
        System.out.println("--- 更新処理開始 ---");
        //更新したいエンティティを生成する
        Quiz quiz1 = new Quiz(1, "「スプリング」はフレームワークですか？", true, "変更タロウ");
        //更新実行
        quiz1 = repository.save(quiz1);
        //更新確認
        System.out.println("更新したデータは、" + quiz1 + "です。");
        System.out.println("--- 更新処理完了 ---");
    }

    /**
     * === 削除処理 ===
     */
    private void deleteQuiz() {
        System.out.println("--- 削除処理開始 ---");
        // 削除実行
        repository.deleteById(2);
        System.out.println("--- 削除処理完了 ---");
    }
}