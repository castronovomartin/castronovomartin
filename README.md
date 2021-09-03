Hola! Espero que estén muy bien!

Adjunto una collection en postman para que puedan probar con mayor facilidad.

Solo deberían levantar el proyecto con el perfil local y de forma automática se comenzará consumir la api solicitada de forma continua cada 10 segundos e imprimiendo en logs en mayúsculas por consola el valor del bitcoin y el timestamp.

Luego cuando ya se hayan impreso al menos 2 de estos, pueden pegarle al segundo endpoint (/bitcoin/promedio) para que calcule el promedio y la variación porcentual. Para esto deben tomar 2 timestamp impresos en consola y enviarlos como parámetros. Ej:

http://localhost:8080/bitcoin/promedio?desde=2021-08-25 17:50:05.829&hasta=2021-08-25 17:50:45.834

Desde ya muchas gracias por la oportunidad!

Saludos.
