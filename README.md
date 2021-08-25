Hola buenas tardes!

Primero que nada perdón por la demora. Como les comenté en la entrevista estamos a mil en el trabajo y no he tenido tiempo de ponerme hasta hoy que traté de hacer todo lo que pude y como pude ja.

Les subo en un zip el proyecto completo, y también les adjunté la collection en postman para que puedan probar con mayor facilidad.

Solo deberían levantar el proyecto y pegarle al primer endpoint http://localhost:8080/bitcoin desde postman para que empiece a hacer llamados concurrentes cada 10 segundos y a almacenar los valores en memoria.

Por algún motivo que no alcancé a corregir al llamar al primer endpoint por primera vez, para que empiece a hacer los llamados concurrentes, a veces falla. Si esto sucede, solo vuelvan a pegarle desde postman al primer enpoint para que empiece a correr bien (IMAGEN1).

Cada uno de los valores los irá imprimiendo en consola para que puedan ver los timestamp y sus precios asociados.

Luego cuando ya se hayan impreso al menos 2 de estos, pueden pegarle al segundo endpoint para que calcule el promedio y la variación porcentual:
http://localhost:8080/bitcoin/promedio?desde=2021-08-25 17:50:05.829&hasta=2021-08-25 17:50:45.834

A partir de los timestamp impresos en pantalla pueden colocarlos reemplazando los parámetros "desde" y "hasta" para poder llamarlo y recuperar el promedio (IMAGEN2).

Hice lo que pude con el tiempo que tuve hoy disponible. 
De todas maneras, desde ya muchas gracias por la oportunidad!

Saludos.
