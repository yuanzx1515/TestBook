package org.spring.testbook.Mapper;

import org.apache.ibatis.annotations.*;
import org.spring.testbook.entity.Comment;

import java.util.List;

@Mapper
public interface CommentsMapper {

    /**
     * 查询评论列表，按创建时间倒序排序。
     *
     * @param limit 每次查询的最大记录数，用于分页。
     * @param offset 查询的起始偏移量，用于分页。
     * @return 返回按创建时间倒序排列的评论列表。
     */
    @Select("SELECT id, content, create_time " +
            "FROM comments " +
            "ORDER BY create_time DESC " +
            "LIMIT #{limit} OFFSET #{offset}")
    List<Comment> selectComments(@Param("limit") int limit, @Param("offset") int offset);


    /**
     * 查询comments表的数量
     * @return int
     */
    @Select("SELECT COUNT(*) FROM comments")
    int countComments();


    /**
     * @param content 评论
     */
    @Insert("INSERT INTO comments(content) values(#{content})")
    void insertComment(@Param("content") String content);


    /**
     * 删除
     * @param id
     */
    @Delete("delete from comments where id = #{id}")
    void deleteComment(@Param("id") int id);
}
