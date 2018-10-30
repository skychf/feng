package com.skychf.feng.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "disks")
public class Disk {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(length = 32, unique = true, nullable = false)
    private String id;

    @Column(length = 32, nullable = false)
    private String diskId;

    @Column(nullable = false)
    private Integer userId;

    private String name;

    private Integer size;

    private String type;

    private String classify;

    private Integer isFolder;

    private String uri;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;
}
