package com.hzipyb.blogservice.domain.posts.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column
    private Long hits;

    @Column
    private String author;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
