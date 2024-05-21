package com.aluracursos.sanchezluys.screenmatch.service;

public interface I_ConvierteDatos {
    // <T> son los datos del tipo genericos
    <T> T obtenerDatos(String json, Class<T> clase);
}
