package com.luis.Practica.Crud.repositories;

import com.luis.Practica.Crud.models.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface NotaRepositoryImp extends JpaRepository<NotaEntity, Long> {
}

