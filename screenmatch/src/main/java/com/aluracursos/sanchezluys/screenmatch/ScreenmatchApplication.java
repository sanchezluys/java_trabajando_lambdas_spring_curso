package com.aluracursos.sanchezluys.screenmatch;

import com.aluracursos.sanchezluys.screenmatch.modelo.DatosSerie;
import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import com.aluracursos.sanchezluys.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola mundo desde spring");
		//**********
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=5e85123f");
		// ejemplo de la imagen aleatoria de cafe
		var url_cafe= "https://coffee.alexflipnote.dev/random.json";
		var json2 = consumoAPI.obtenerDatos(url_cafe);
		System.out.println(json);
		System.out.println(json2);
		//*** usando interface para manehar datos genericos
		ConvierteDatos conversor = new ConvierteDatos();
		var datos= conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println("Datos= "+ datos);
	}
}
