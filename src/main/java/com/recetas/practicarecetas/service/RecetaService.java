package com.recetas.practicarecetas.service;

import com.recetas.practicarecetas.model.Receta;
import com.recetas.practicarecetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository repository;

    //CRUD CREATE, READ, UPDATE, DELETE

    public Receta addReceta(Receta receta){
        receta.setRecetaId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(receta);
    }

    public List<Receta> findAllRecetas(){
        return repository.findAll();
    }

    public Receta getRecetaByRecetaId(String recetaId){
        return repository.findById(recetaId).get();
    }

    public List<Receta> getRecetaByNombre(String nombre){
        return  repository.findByTitulo(nombre);
    }

    public  List<Receta> getRecetaByNivelDificultad(String dificultad){
        return repository.getRecetaByNivelDificultad(dificultad);
    }

    public Receta updateReceta(Receta recetaRequest){
        //get the existing document from DB
        //populate new value from request to existing object/entity/document
        Receta existingReceta = repository.findById(recetaRequest.getRecetaId()).get();
        existingReceta.setTitulo(recetaRequest.getTitulo());
        existingReceta.setIngredientes(recetaRequest.getIngredientes());
        existingReceta.setTiempo(recetaRequest.getTiempo());
        existingReceta.setNivelDificultad(recetaRequest.getNivelDificultad());
        existingReceta.setImagen(recetaRequest.getImagen());
        existingReceta.setVideo(recetaRequest.getVideo());

        return  repository.save(existingReceta);
    }

    public String deleteReceta(String recetaId){
        repository.deleteById(recetaId);
        return  recetaId + "Receta deleted from dashboard";
    }
}
