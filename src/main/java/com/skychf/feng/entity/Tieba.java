package com.skychf.feng.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
@Data
public class Tieba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tiebaTypeId;

    private String title;

    private String body;

    private Integer userId;

    private Date createdAt;

    private Date updatedAt;
}
