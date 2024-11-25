package org.spring.testbook;

import org.junit.jupiter.api.Test;
import org.spring.testbook.Mapper.BookMapper;
import org.spring.testbook.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testSelectActiveBooks() {
        long startTime = System.nanoTime(); // 开始时间

        // 调用接口
        List<Book> books = bookMapper.SelectActiveBookList();
        bookMapper.selectBookWithBorrowStatus().forEach(System.out::println);
            books.forEach(System.out::println);
    }
}
