package com.example.so67679;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity //JPAにテーブルに保存するクラス（エンティティ）であることを示す。
@Data
public class Blog {
    @Id //対応するテーブルのプライマリーキー（主キー）となるフィールド
    @GeneratedValue(strategy = GenerationType.AUTO) //プライマリーキーの値を連番で自動生成。
    private Integer id;

    private String title;

    private LocalDateTime postDateTime;

    @Column(length = 1000) //テーブルの列を制御したい場合は@Columnをつける。フィールドの長さをデフォルトの255から1000にする。
    private String contents;
    //1対多の関係。ブログは複数のコメントを持つ。
    @OneToMany(mappedBy = "blog") //mappedBy引数には「相手側が自分を参照する名前」を指定。
    private List<Comment> comments;
}
