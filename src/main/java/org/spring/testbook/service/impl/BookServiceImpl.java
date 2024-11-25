package org.spring.testbook.service.impl;

import jakarta.annotation.Resource;
import org.spring.testbook.Mapper.BookMapper;
import org.spring.testbook.entity.Book;
import org.spring.testbook.service.BookService;
import org.spring.testbook.service.BorrowService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Resource
    BorrowService  borrowService;

    @Override
    public List<Book> SelectBookList() {
      return  bookMapper.SelectBookList();
    }



    @Override
    public int BookCount() {
        return bookMapper.BookCount();
    }

    @Override
    public List<Book> SelectActiveBookList() {
        return bookMapper.SelectActiveBookList();
    }

    @Override
    public List<Book> selectBookWithBorrowStatus() {
        return bookMapper.selectBookWithBorrowStatus();
    }

    @Override
    public int InsertBook(String title, String desc, double price) {
        return bookMapper.InsertBook(title, desc, price);
    }

}
