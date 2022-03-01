package com.jjeanjacques.solidgood.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pokemon")
public class Pokemon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private int total;
    private int generation;
    private int legendary;

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

}
