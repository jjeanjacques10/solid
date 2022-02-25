package com.jjeanjacques.solidgood.entity;

import javax.persistence.*;

@Entity
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String size;

}
