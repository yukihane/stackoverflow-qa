package com.example.so66104427;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BlogForm {
    private String title;
    private String shortDescription;
    private MultipartFile display_image;
}
