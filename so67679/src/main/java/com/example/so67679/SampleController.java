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

    @GetMapping("/")
    public String index(Model model) {
        List<Blog> blogs = blogRepository.findAll();
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @GetMapping("/form")
    public String form(Blog blog) {
        return "form";
    }

    @PostMapping("/create")
    public String create(Blog blog) {
        blog.setPostDateTime(LocalDateTime.now());
        blogRepository.save(blog);
        //エンティティを保存するにはリポジトリインターフェースのsaveメソッドを使用。
        //エンティティをsaveすると@Idアノテーションを付けたフィールドに値が設定される。
        return "redirect:/blog/" + blog.getId();
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Integer id, Model model) {
        Optional<Blog> blog = blogRepository.findById(id);
        //返されたオブジェクトがnullでなければこの処理を行うなど、nullの場合の処理を書きやすくするためのもの。
        //getメソッドを呼び出して中身を取り出す。
        model.addAttribute("blog", blog.get());

        Comment comment = new Comment();
        comment.setBlog(blog.get());
        model.addAttribute("comment", comment);
        return "blog";
    }

    @PostMapping("/comment")
    public String createComment(Comment comment) {
        comment.setPostDateTime(LocalDateTime.now());
        commentRepository.save(comment);
        return "redirect:/blog/" + comment.getBlog().getId();
    }

}
