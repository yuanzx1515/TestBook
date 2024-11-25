package org.spring.testbook.service.impl;


import jakarta.annotation.Resource;
import org.spring.testbook.Mapper.BorrowMapper;
import org.spring.testbook.entity.Borrow;
import org.spring.testbook.service.BorrowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;


    @Override
    public int getBorrowCount() {
        return borrowMapper.getBorrowCount();
    }

    @Override
    public List<Borrow> getBorrowList() {
        return borrowMapper.getBorrowList();
    }

    @Override
    public void deleteBorrow(int id) {
         borrowMapper.deleteBorrow(id);
    }
}
