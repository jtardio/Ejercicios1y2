Ejercicio 9

Ejercicio que implementa un chat con un servidor y diferentes usuarios gestionados por threads.
Se controlan las diferentes opciones del (unirse al chat, escribir mensaje y abandonar chat) por parámetros enviados por cada cliente.
La gestión de las opciones se realiza en la clase ChatServerThread que implementa Runnable y revisa cual es la opcion seleccionada.

Al iniciar los clientes se le ha de pasar por parámetros puerto (3333) y direccion del server.