package com.example.myproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
 public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=255)
    private String name;
    @Column(nullable=false ,unique=true)
    private String email;
    @Column(nullable=false,length=200)
    private String password;

 }