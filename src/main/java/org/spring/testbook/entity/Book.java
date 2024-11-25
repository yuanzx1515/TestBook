package org.spring.testbook.entity;

import lombok.Data;

@Data
public class Book {
    int id;
    String title;
    String desc;
    double price;
    String borrowStatus;

}
