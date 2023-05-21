package com.example.jaso94913.service;

import com.example.jaso94913.model.Book;
import com.example.jaso94913.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository repository;

    /**
     * データベースから本の一覧を取得する
     *
     * @return
     */
    public List<Book> findAll() {
        return repository.findAll();
    }
}