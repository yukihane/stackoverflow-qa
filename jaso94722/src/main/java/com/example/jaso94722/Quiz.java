package com.example.jaso94722;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    /**
     * 識別ID
     */
    @Id
    private Integer id;
    /**
     * クイズの内容
     */
    private String question;
    /**
     * クイズの解答
     */
    private Boolean answer;
    /**
     * 作成者
     */
    private String author;
}
