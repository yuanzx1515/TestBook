package org.spring.testbook.Mapper;

import org.apache.ibatis.annotations.*;
import org.spring.testbook.entity.Book;

import java.util.List;
import java.util.Map;

/**
 *  查询关于book表的相关信息
 *
 */

@Mapper
public interface BookMapper {

    /**
     *
     * @return 返回书籍的数量 int
     * <p>
     *     返回多少本数 int
     * </p>
     */
    @Select("SELECT COUNT(*) FROM book")
    int BookCount();


    /**
     * @return 返回书籍列表
     * <ul>
     *     <li>int id </li>
     *       <li>String title</li>
     *     <li>String desc </li>
     *      <li>double price </li>
     * </ul>
     */
    @Select("select * from book")
    List<Book> SelectBookList();


    /**
     * 查询book表的书籍id 没有出现在borrow表中
     * @return
     */
    @Select("""
    SELECT
        b.id,
        b.title,
        b.desc,
        b.price
    FROM
        book b
            LEFT JOIN
        borrow br ON b.id = br.bid
    WHERE
        br.bid IS NULL;
""")
    List<Book> SelectActiveBookList();
    @Results({
            @Result(column = "id", property = "bid"),
            @Result(column = "book_title", property = "title"),
            @Result(column = "desc", property = "desc"),
            @Result(column = "price", property = "price"),
            @Result(column = "borrow_status", property = "borrowStatus")
    })
    @Select("""
    SELECT
        b.id AS book_id,
        b.title AS book_title,
        b.`desc` AS book_desc,
        b.price AS book_price,
        CASE
            WHEN br.bid IS NOT NULL THEN '已借阅'
            ELSE '未借阅'
        END AS borrow_status
    FROM
        book b
    LEFT JOIN
        borrow br
    ON
        b.id = br.bid
""")
    List<Book> selectBookWithBorrowStatus();


    @Insert("insert into book(title,`desc`,price) values(#{title},#{desc},#{price})")
    int InsertBook(@Param("title") String title, @Param("desc") String desc, @Param("price") double price);

}
