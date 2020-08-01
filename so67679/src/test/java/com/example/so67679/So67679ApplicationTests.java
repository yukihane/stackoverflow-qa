package com.example.so67679;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class So67679ApplicationTests {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void contextLoads(@Autowired final WebTestClient webClient) throws Exception {
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

        //        webClient.get().uri("/blog/" + saved.getId()).exchange().expectStatus().isOk().expectBody(String.class)
        //            .isEqualTo("Hello World");

        webClient.post().uri("/comment")
            .body(BodyInserters
                .fromFormData("blog", String.valueOf(saved.getId()))
                .with("text", "new comment"))
            .exchange()
            .expectStatus().is3xxRedirection();
    }
}
