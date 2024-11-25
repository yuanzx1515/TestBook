package org.spring.testbook.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    int id;
    String content;
    Date create_time;
}
