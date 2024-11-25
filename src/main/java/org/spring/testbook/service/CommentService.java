package org.spring.testbook.service;

import org.apache.ibatis.annotations.Param;
import org.spring.testbook.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getComments(int page, int size);

    int getTotalComments();

    void insertComment(String content);

    void deleteComment(@Param("id") int id);
}
