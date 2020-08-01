package com.example.so67679;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SampleController {

    @Autowired //リポジトリインターフェース参照、追加、更新などのメソッドがあらかじめ定義されている。findAllメソッドを使用することで単純にテーブル内のレコードを一覧で返す。
    private BlogRepository blogRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable final Integer id, final Model model) {
        final Optional<Blog> blog = blogRepository.findById(id);
        //返されたオブジェクトがnullでなければこの処理を行うなど、nullの場合の処理を書きやすくするためのもの。
        //getメソッドを呼び出して中身を取り出す。
        model.addAttribute("blog", blog.get());

        final Comment comment = new Comment();
        comment.setBlog(blog.get());
        model.addAttribute("comment", comment);
        return "blog";
    }

    @PostMapping("/comment")
    public String createComment(final Comment comment) {
        comment.setPostDateTime(LocalDateTime.now());
        commentRepository.save(comment);
        return "redirect:/blog/" + comment.getBlog().getId();
    }

    @GetMapping("/comment")
    public String createDummyComment() {
        final Comment comment = new Comment();
        comment.setPostDateTime(LocalDateTime.now());
        comment.setText("ダミーテキスト: " + comment.getPostDateTime());
        final Blog blog = new Blog();
        blog.setComments(List.of(comment));
        blog.setContents("コンテンツ");
        blog.setTitle("タイトル");
        final Blog saved = blogRepository.save(blog);
        comment.setBlog(saved);
        commentRepository.save(comment);
        return "redirect:/blog/" + comment.getBlog().getId();
    }

}
