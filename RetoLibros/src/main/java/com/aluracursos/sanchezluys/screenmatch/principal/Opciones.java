package com.aluracursos.sanchezluys.screenmatch.principal;

import com.aluracursos.sanchezluys.screenmatch.model.Datos;
import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import com.aluracursos.sanchezluys.screenmatch.service.ConvierteDatos;

public class Opciones {
    Menus menu = new Menus();
    public static final String URL_BASE="https://gutendex.com/books/";
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvierteDatos conversor = new ConvierteDatos();
    //**
    public void Opcion1()
    {
        menu.titulo1();
        var json= consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println("Lista libros: "+ datos);
        menu.Menu();
    }
    public void Opcion2()
    {
        menu.titulo2();
        var json= consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        menu.Menu();
    }
    public void Opcion3()
    {
        menu.titulo3();
        menu.Menu();

    }

}
