package com.luis.Practica.Crud.controller;


import com.luis.Practica.Crud.models.NotaEntity;

import com.luis.Practica.Crud.request.NotaRequest;
import com.luis.Practica.Crud.request.NotaResponse;
import com.luis.Practica.Crud.services.NotasServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
@AllArgsConstructor
public class NotasController {



   private final NotasServices notasServices;

    @GetMapping
    public List<NotaResponse>  getNotas(){
        return notasServices.getNotas();
    }

    @PostMapping
    public NotaEntity postNota(@RequestBody NotaEntity nota){
        return notasServices.postNota(nota);
    }


    @PutMapping("/{id}")
    public NotaResponse putNota(@PathVariable Long id, @RequestBody NotaRequest nota) {

        return notasServices.updateNota(id, nota);
    }

    @DeleteMapping("/{id}")
    public String deleteNota(@PathVariable Long id){
        notasServices.deleteNota(id);
        return "Nota eliminada";
    }

    @GetMapping("{id}")
    public NotaResponse getNotaById(@PathVariable Long id){
        return notasServices.getNotaById(id);
    }

}
