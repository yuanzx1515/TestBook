package org.spring.testbook.Mapper;

import org.apache.ibatis.annotations.*;
import org.spring.testbook.entity.Borrow;

import java.util.List;

/**
 *
 * 次接口查询关于borrow表的相关信息
 */

@Mapper
public interface BorrowMapper {


    /**
     *  <p>
     *  此方法从数据库中查询所有的借阅记录，借助表 `borrow`、`student` 和 `book` 的连接，
     *  获取借阅记录的详细信息，包括借阅记录 ID、学生信息、书籍信息及借阅时间等。
     *  </p>
     *@return 包含借阅信息的列表，每个元素是 {@link Borrow} 对象，其中包含以下字段：
     *   <ul>
     *      <li>id：借阅记录的 ID</li>
     *      <li>sid：学生的 ID</li>
     *      <li>bid：书籍的 ID</li>
     *      <li>time：借阅的时间</li>
     *      <li>studentName：学生的姓名</li>
     *      <li>bookName：书籍的名称</li>
     *  </ul>
     *
     */
    @Results({
           @Result(column = "id",property = "id"),
           @Result(column = "sid",property = "sid"),
           @Result(column = "bid",property = "bid"),
           @Result(column = "time",property = "time"),
           @Result(column = "name",property = "studentName"),
           @Result(column = "title",property = "bookName")
   })
    @Select("""
        select * from borrow left join student on borrow.sid = student.id
        left join book on book.id = borrow.bid
""")
    List<Borrow> getBorrowList();

    /**
     * <p>
     *     此接口返回有多个借阅的 返回int
     * </p>
     *
     */
    @Select("SELECT COUNT(*) FROM borrow")
    int getBorrowCount();


    /**
     *
     * @param id
     */
    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(int id);

    /**
     *
     * @param sid 学生id
     * @param bid 书籍id
     */
    @Insert("insert into borrow(sid,bid,time) values(#{sid},#{bid},NOW())")
    void insertBorrow(@Param("sid") int sid, @Param("bid") int bid);
}
