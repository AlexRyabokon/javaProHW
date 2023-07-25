package com.example.homework40.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name= "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private double cost;

}
