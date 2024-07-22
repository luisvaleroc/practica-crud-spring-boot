package com.luis.Practica.Crud.mapper;

import com.luis.Practica.Crud.models.NotaEntity;
import com.luis.Practica.Crud.request.NotaRequest;
import com.luis.Practica.Crud.request.NotaResponse;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {

    public NotaEntity toEntity(NotaRequest notaRequest) {

        if (notaRequest == null){
            return null;
        }
        NotaEntity notaEntity = new NotaEntity();
        notaEntity.setName(notaEntity.getName());
        return notaEntity;
    }

    public NotaResponse toResponse(NotaEntity notaEntity) {
        if (notaEntity == null){
            return null;
        }
        NotaResponse notaResponse = new NotaResponse();
        notaResponse.setName(notaEntity.getName());
        return notaResponse;
    }
}
