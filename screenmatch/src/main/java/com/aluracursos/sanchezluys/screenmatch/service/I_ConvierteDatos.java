package com.aluracursos.sanchezluys.screenmatch.service;

public interface I_ConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
