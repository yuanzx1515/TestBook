package org.spring.testbook.service;

import org.spring.testbook.entity.Borrow;

import java.util.List;

public interface BorrowService {
    int getBorrowCount();
    List<Borrow> getBorrowList();
    void deleteBorrow(int id);

}
