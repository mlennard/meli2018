# Code Challenge Martin Lennard - Mercado Libre 2018
## Instrucciones de funcionamiento
1- Descargar el código fuente de mi [Github](https://github.com/mlennard/meli2018/)

2- Desde un IDE importar como proyecto Maven lo descargado en el punto 1.

3- Con Maven o Gradle ejecutar el goal 'install'

4- Con cualquier cliente REST (Postman, Crest, cualquier extensión de tipo rest client de Google Chrome) hacer un POST a la URL http://localhost:8080/mutant indicando el Content-Type:application/json y en el cuerpo del request incluir la cadena ADN de la siguiente manera:
> { "dna":["CACAGAT","TCGCGCA","GAXCTXT","ATTACGA","TGTCACT","CACGTAA","AGGXGCG"] }

## Código fuente
La resolución del problema/algoritmo de detección de ADN mutante se encuentra en https://github.com/mlennard/meli2018/blob/master/src/main/java/lennard/meli/DNAService.java

## Aporte adicional
El entregable cuenta con test unitarios, los mismos pueden ser ejecutados por separado con cualquier plugin Junit en el IDE de preferencia o incluso con Maven/Gradle (goal 'test').

## URL de la API Rest
La API Rest se encuentra desplegada via Heroku en la siguiente URL: https://murmuring-wave-86603.herokuapp.com/mutant
Se puede probar siguiendo las mismas indicaciones del punto 4 descrito más arriba.