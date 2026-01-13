package com.cwa.crudspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    /*
    Un comment appartient à un seul post et
    plusieurs comment peuvent appartenir à un post
    */
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
