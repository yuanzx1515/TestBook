package org.spring.testbook.service.impl;

import jakarta.annotation.Resource;
import org.spring.testbook.Mapper.CommentsMapper;
import org.spring.testbook.entity.Comment;
import org.spring.testbook.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentsMapper commentsMapper;

    @Override
    public List<Comment> getComments(int page, int size) {
        int offset = (page - 1) * size; // 计算偏移量
        return commentsMapper.selectComments(size, offset);
    }

    @Override
    public int getTotalComments() {
        return commentsMapper.countComments();
    }

    @Override
    public void insertComment(String content) {
        commentsMapper.insertComment(content);
    }

    @Override
    public void deleteComment(int id) {
        commentsMapper.deleteComment(id);
    }
}
