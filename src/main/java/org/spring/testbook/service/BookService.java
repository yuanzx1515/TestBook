package org.spring.testbook.service;

import org.apache.ibatis.annotations.Param;
import org.spring.testbook.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> SelectBookList();
    int BookCount();
    List<Book> SelectActiveBookList();
    List<Book> selectBookWithBorrowStatus();
    int InsertBook(String title,  String desc,  double price);
}
