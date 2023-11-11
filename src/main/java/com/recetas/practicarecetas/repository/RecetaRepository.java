package com.recetas.practicarecetas.repository;

import com.recetas.practicarecetas.model.Receta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecetaRepository extends MongoRepository<Receta,String> {
    List<Receta> findByTitulo(String nombre);

    @Query("{nivelDificultad: ?0}")
    List<Receta> getRecetaByNivelDificultad(String dificultad);
}
