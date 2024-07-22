package com.luis.Practica.Crud.services;


import com.luis.Practica.Crud.exceptions.NotaNotFound;
import com.luis.Practica.Crud.mapper.NotaMapper;
import com.luis.Practica.Crud.models.NotaEntity;
import com.luis.Practica.Crud.repositories.NotaRepositoryImp;
import com.luis.Practica.Crud.request.NotaRequest;
import com.luis.Practica.Crud.request.NotaResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotasServices {


    private final NotaRepositoryImp notaRepositoryImp;
    private final NotaMapper notaMapper;


    public List<NotaResponse> getNotas(){
        List<NotaEntity> notaEntities = notaRepositoryImp.findAll();
        System.out.println(notaEntities);
        return notaEntities.stream()
                .map(notaMapper::toResponse).collect(Collectors.toList());
    }

    public NotaEntity postNota(NotaEntity nota){
        return notaRepositoryImp.save(nota);
    }

    public NotaResponse updateNota(Long id, NotaRequest nota){
      return  notaRepositoryImp.findById(id).map(n ->{
            n.setName(nota.getName());
            NotaEntity notaUpdate = notaRepositoryImp.save(n);
            return notaMapper.toResponse(notaUpdate);
        }).orElseThrow(() -> new NotaNotFound("no encontrado"));

    }

    public void deleteNota(Long id){
      notaRepositoryImp.findById(id).ifPresentOrElse(nota-> notaRepositoryImp.delete(nota), ()-> {throw new NotaNotFound("no encontrado");});

    }
    public NotaResponse getNotaById(Long id){
        return notaRepositoryImp.findById(id).map(notaMapper::toResponse).orElseThrow(() -> new NotaNotFound("no encontrado"));
    }

}
