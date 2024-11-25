package org.spring.testbook.BookController;

import jakarta.annotation.Resource;
import org.spring.testbook.entity.Comment;
import org.spring.testbook.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/comments")
    public String getComments(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5") int size,
                              Model model) {
        List<Comment> comments = commentService.getComments(page, size);

        int totalComments = commentService.getTotalComments();

        int totalPages = (int) Math.ceil((double) totalComments / size);

        model.addAttribute("comments", comments);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "comments";
    }

    @PostMapping("/comments")
    public String addComment(String content) {
        commentService.insertComment(content);
        return "redirect:/comments";
    }

    @GetMapping("/delete-comments")
    public String deleteComment(int id) {
        commentService.deleteComment(id);
        return "redirect:/comments";
    }
}
