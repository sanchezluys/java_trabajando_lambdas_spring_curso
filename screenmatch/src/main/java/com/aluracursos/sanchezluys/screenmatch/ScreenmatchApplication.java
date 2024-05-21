package com.aluracursos.sanchezluys.screenmatch;

import com.aluracursos.sanchezluys.screenmatch.modelo.DatosEpisodio;
import com.aluracursos.sanchezluys.screenmatch.modelo.DatosSerie;
import com.aluracursos.sanchezluys.screenmatch.modelo.DatosTemporadas;
import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import com.aluracursos.sanchezluys.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		//*** ahora con episodio y temporadas
		System.out.println("************************************");
		System.out.println("Con la API en episodios y temporadas ");
		var json3 = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&episode=1&season=1&apikey=5e85123f");
		System.out.println("Json3: "+json3);
		DatosEpisodio episodio = conversor.obtenerDatos(json3, DatosEpisodio.class);
		System.out.println("Episodio: "+episodio);
		//*** ahora con  la lista de temporadas
		System.out.println("************************************");
		System.out.println("Listas de temporadas ");
		// se crea la lista
		List<DatosTemporadas> temporadas = new ArrayList<>();
		for (int i = 1; i < datos.totalTemporadas() ; i++) {

			var json4 = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&season="+i+"&apikey=5e85123f");
			var datosTemporadas = conversor.obtenerDatos(json4, DatosTemporadas.class);
			//**
			System.out.println("Cuando i = "+i);
			System.out.println("-> json4: "+ json4);
			temporadas.add(datosTemporadas);
		}
		//** se imprime la lista
		temporadas.forEach(System.out::println);
	}
}
