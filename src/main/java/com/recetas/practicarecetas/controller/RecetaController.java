package com.recetas.practicarecetas.controller;

import com.recetas.practicarecetas.model.Receta;
import com.recetas.practicarecetas.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/receta")
public class RecetaController {
    @Autowired
    private RecetaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receta createReceta(@RequestBody Receta receta){
        return service.addReceta(receta);
    }

    @GetMapping
    public List<Receta> getRecetas(){
        return service.findAllRecetas();
    }

    @GetMapping("/{recetaId}")
    public Receta getReceta(@PathVariable String recetaId){
        return service.getRecetaByRecetaId(recetaId);
    }

    @GetMapping("/titulo/{nombre}")
    public List<Receta> findRecetaUsingTitulo(@PathVariable String nombre){
        return  service.getRecetaByNombre(nombre);
    }

    @GetMapping("/dificultad/{dificultad}")
    public List<Receta> getRecetaByDificultad(@PathVariable String dificultad){
        return service.getRecetaByNivelDificultad(dificultad);
    }

    @PutMapping
    public Receta modifyReceta(@RequestBody Receta receta){
        return  service.updateReceta(receta);
    }

    @DeleteMapping("/{recetaId}")
    public String deleteReceta(@PathVariable String recetaId){
        return service.deleteReceta(recetaId);
    }
}
