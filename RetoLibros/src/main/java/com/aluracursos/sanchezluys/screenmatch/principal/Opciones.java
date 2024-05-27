package com.aluracursos.sanchezluys.screenmatch.principal;

import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import com.aluracursos.sanchezluys.screenmatch.service.ConvierteDatos;

public class Opciones {
    Menus menu = new Menus();
    public static final String URL_BASE="https://gutendex.com/books";
    public ConsumoAPI consumoAPI = new ConsumoAPI();
    public ConvierteDatos conversor = new ConvierteDatos();

    //**
    public void Opcion1() {
        menu.titulo1();
        var json= consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
    }
    public void Opcion2() {
        menu.titulo2();
    }
    public void Opcion3() {
        menu.titulo3();;
    }
}
