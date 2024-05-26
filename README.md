### iniciando codigo


| Pasos | Descripción                                                                                                       |   |   |
|-------|-------------------------------------------------------------------------------------------------------------------|---|---|
| 1     | Creando Hola Mundo con Spring                                                                                     |   |   |
| 2     | Consumiendo de una API con Spring                                                                                 |   |   |
| 3     | Usando una API de imagenes de cafe aleatorias                                                                     |   |   |
|       | https://coffee.alexflipnote.dev/random.json                                                                       |   |   |
| 4     | Instalando libreria jackson databind v.2.17.1                                                                     |   |   |
|       | usando sitio de maven                                                                                             |   |   |
|       | en el archivo pom.xml                                                                                             |   |   |
| 5     | Aplicando la libreria Jackson                                                                                     |   |   |
|       | Usando alias, @JsonAlias()                                                                                        |   |   |
|       | Se crea el modelo DatosSerie                                                                                      |   |   |
|       | Se crea la interface I_ConvierteDatos                                                                             |   |   |
|       | Se configura JsonIgnoreProperty para que no lea todos los datos del json, solo los definidos en la clase          |   |   |
| 6     | Ahora se usa la API con episodios y temporadas                                                                    |   |   |
|       | Se crea la clase record DatosEpisodio                                                                             |   |   |
|       | Se utiliza la nueva variable json3                                                                                |   |   |
|       | Se serializa con Title, Episode, imbRating y Released en la clase record                                          |   |   |
| 7     | Modelando las temporadas                                                                                          |   |   |
|       | Se crea el modelo DatosTemporadas,                                                                                |   |   |
|       | Se serializa con "Season" y "Epsiodes"                                                                            |   |   |
|       | En el main se define la variable json4                                                                            |   |   |
|       | Se hace el recorrido del la api con un for                                                                        |   |   |
| 8     | Creando el menu de interaccion con el usuario                                                                     |   |   |
|       | Nuevo paquete: principal y nueva clase principal                                                                  |   |   |
|       | Se crea una clase para el menu                                                                                    |   |   |
|       | Usar constantes, para usar la api  en la nueva clase menu                                                         |   |   |
|       | Las constantes se recomienda sean escritas en mayuscula ejm: URL_BASE                                             |   |   |
|       | Ojo para declarar una constante en java se usa: "private final String constante=valor"                            |   |   |
|       | "final" es una palabra reservada                                                                                  |   |   |
| 9     | Clase: 02-09: Buscando datos completos de la serie                                                                |   |   |
|       | Listas dentro de listas                                                                                           |   |   |
|       | ** USANDO FUNCIONES LAMBDA**                                                                                      |   |   |
|       | temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())) );                             |   |   |
|       | se simplifica los 2 bucles en una sola linea                                                                      |   |   |
|       | tambien se le llaman funciones anonimas.                                                                          |   |   |
| 10    | Clase 03-02: Encadenando Operaciones con Stream                                                                   |   |   |
|       | Se crea clase EjemploStream                                                                                       |   |   |
|       | Se usa la opcion de streams()                                                                                     |   |   |
|       | Del listado se ordenan, se eligen solo 4 y al final muestra solo los que inicien con L todo impreso en mayusculas |   |   |
| 11    | Clase 03-04: Identificando a los mejores Episodios                                                                |   |   |
|       | Se crea la lista de episodios y temporadas, usando Streams()                                                      |   |   |
|       | En datosEpisodios usando streams() se hace el filtro para eliminar los N/A                                        |   |   |
|       | -- se ordena de menor a mayor                                                                                     |   |   |
|       | -- se limita a 5 resultados                                                                                       |   |   |
| 12    | Clase 03-08: Nueva clase para lidiar con los datos del episiodio                                                  |   |   |
|       | Se crea la nueva clase Episodio, con sus setters y getters, asi como su toString()                                |   |   |
|       | Con los datos N/A se genera un error NumberFormatException, se corrige con un try-catch                           |   |   |
|       | Con las fechas N/A se generea un error DateTimeException, tambien se corrige con un try-cath                      |   |   |
|       | La nueva lista usa Stream()                                                                                       |   |   |
| 13    | Clase 03-09: Buscando un episodio a partir de una fecha                                                           |   |   |
|       | Usando la API de fechas                                                                                           |   |   |
|       | Se usa stream(), tambien un formateador de fechas con DateTimeFormatter                                           |   |   |
|       | Ahora se muetsran los episodios a partir de las fechas que indique el usuario                                     |   |   |
| 14    | Clase 04-02: Exibiendo las etapas de un stream                                                                    |   |   |
|       | Se usa peek()                                                                                                     |   |   |
|       | Se muestra como java realiza los streams() de cada filtro, en la lista de los top 5                               |   |   |
| 15    | Clase 04-05: Encontrando la primera coincidencia de búsqueda en una colección de datos                            |   |   |
|       | se usa streams(), con findfirst()                                                                                 |   |   |
|       | la validacion en el filtro se hace mayusculas a mayusculas                                                        |   |   |
|       | uso del optional. dado que no siempre habrá un resultado                                                            |   |   |
|       |                                                                                                                   |   |   |
