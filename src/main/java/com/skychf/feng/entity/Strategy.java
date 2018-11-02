package com.skychf.feng.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Strategy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Integer userId;

    private String body;

    private Integer isPublic;

    private Integer isAudit;

    private Date createdAt;

    private Date updatedAt;
}
