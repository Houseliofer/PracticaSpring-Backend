package com.recetas.practicarecetas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Receta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {

    @Id
    private String recetaId;
    private String titulo;
    private String[] ingredientes;
    private int tiempo;
    private String nivelDificultad;
    private String imagen;
    private String video;
}
