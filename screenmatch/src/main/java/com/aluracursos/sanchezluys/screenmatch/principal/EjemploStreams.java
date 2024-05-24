package com.aluracursos.sanchezluys.screenmatch.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Brenda","Luis","Maria","Eric","Genesys");

        System.out.println("Lista ordenada alfabeticamente, seleccionar 4 datos, y el que empieze con L se coloca en mayusculas");
        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n ->n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);

    }
}
