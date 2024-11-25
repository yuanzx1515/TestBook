package org.spring.testbook.BookController;

import jakarta.annotation.Resource;
import org.spring.testbook.entity.Book;
import org.spring.testbook.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/books")
    public String books(Model model){
        model.addAttribute("book_list",bookService.SelectBookList());
        List<Book> books = bookService.selectBookWithBorrowStatus();
        model.addAttribute("book_list_status", books);
        return "books";
    }

    @GetMapping("/add-book")
    public String addBook(Model model){
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(String title,String desc,double price){
        bookService.InsertBook(title,desc,price);
        return "redirect:/books";
    }
}
