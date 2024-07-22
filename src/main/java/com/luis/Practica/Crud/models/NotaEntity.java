package com.luis.Practica.Crud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "notas")
@Getter
@Setter
@ToString
public class NotaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

}
