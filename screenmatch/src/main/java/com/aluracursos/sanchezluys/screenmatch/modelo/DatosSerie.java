package com.aluracursos.sanchezluys.screenmatch.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion
) {
}
