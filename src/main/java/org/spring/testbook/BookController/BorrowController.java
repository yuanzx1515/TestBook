package org.spring.testbook.BookController;

import jakarta.annotation.Resource;
import org.spring.testbook.Mapper.BookMapper;
import org.spring.testbook.Mapper.BorrowMapper;
import org.spring.testbook.Mapper.StudentMapper;
import org.spring.testbook.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowController {

       @Resource
       StudentService studentService;

        @Resource
        BookMapper bookMapper;

        @Resource
        BorrowMapper borrowMapper;




    @GetMapping("/login")
    public String login() {
        return "login";
    }


    /**
     *
     * @param model borrow主界面的信息
     *
     */
    @GetMapping({"/borrow","/"})
    public String borrow(Model model) {
        model.addAttribute("student_count",studentService.countStudents());
        model.addAttribute("book_count",bookMapper.BookCount());
        model.addAttribute("getBorrowList",borrowMapper.getBorrowList());
        model.addAttribute("borrow_count",borrowMapper.getBorrowCount());
        return "borrow";
    }

    /**
     * @param id borrow表单中的id
     */
    @GetMapping("/return-book")
    public String returnBook(int id) {
        borrowMapper.deleteBorrow(id);
        return "redirect:/borrow";
    }

    @GetMapping("/add-borrow")
    public String addBook(Model model) {
        model.addAttribute("student_list",studentService.selectAllStudent());
        model.addAttribute("book_list",bookMapper.SelectActiveBookList());
        return "add-borrow";
    }

    @PostMapping("/add-borrow")
    public String addBorrow(int student,int book) {
        borrowMapper.insertBorrow(student, book);
        return "redirect:/borrow";
    }

}
