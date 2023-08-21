package com.capstone.rideitout.Model;


import jakarta.persistence.*;


@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


}
