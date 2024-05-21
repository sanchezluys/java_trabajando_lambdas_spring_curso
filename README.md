### iniciando codigo


| Pasos | Descripción                                                                                     |   |   |
|-------|-------------------------------------------------------------------------------------------------|---|---|
| 1     | Creando Hola Mundo con Spring                                                                   |   |   |
| 2     | Consumiendo de una API con Spring                                                               |   |   |
| 3     | Usando una API de imagenes de cafe aleatorias                                                   |   |   |
|       | https://coffee.alexflipnote.dev/random.json                                                     |   |   |
| 4     | Instalando libreria jackson databind v.2.17.1                                                   |   |   |
|       | usando sitio de maven                                                                           |   |   |
|       | en el archivo pom.xml                                                                           |   |   |
| 5     | Aplicando la libreria Jackson                                                                   |   |   |
|       | Usando alias, @JsonAlias()                                                                      |   |   |
|       | Se crea el modelo DatosSerie                                                                    |   |   |
|       | Se crea la interface I_ConvierteDatos                                                           |   |   |
|       | Se configura JsonIgnoreProperty para que no lea todos los datos del json, solo los definidos en la clase |   |   |
| 6     | Ahora se usa la API con episodios y temporadas                                                  |   |   |
|       | Se crea la clase record DatosEpisodio                                                           |   |   |
|       | Se utiliza la nueva variable json3                                                              |   |   |
|       | Se serializa con Title, Episode, imbRating y Released en la clase record                        |   |   |
| 7     | Modelando las temporadas                                                                        |   |   |
|       | Se crea el modelo DatosTemporadas,                                                              |   |   |
|       | Se serializa con "Season" y "Epsiodes"                                                          |   |   |
|       | En el main se define la variable json4                                                          |   |   |
|       | Se hace el recorrido del la api con un for                                                      |   |   |
|       |                                                                                                 |   |   |
|       |                                                                                                 |   |   |
