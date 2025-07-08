# Chat Asíncrono con RabbitMQ (Java + Docker)

## Objetivo
Simular una comunicación asíncrona entre un emisor (productor) y un receptor (consumidor) usando RabbitMQ como intermediario de mensajes.

## Tecnologías
- Java 21
- RabbitMQ
- Docker y Docker Compose

## ¿Cómo ejecutar?

1. Clona el repositorio y abre la carpeta:
   
   git clone  https://github.com/CeciliaVargas0025/SDtrabajofinal.git 
   
    cd SDtrabajofinal
   

2. Construye e inicia los contenedores:
   
   docker-compose up --build
   

 nombre  del container:
 docker ps


3. En una terminal nueva, conectarse al emisor para enviar mensajes:

   docker attach sdtrabajofinal-emisor-1
   

4. En otra terminal, ver los mensajes recibidos:

   docker logs -f sdtrabajofinal-receptor-1

5. Acceder al panel de control de RabbitMQ:
   - URL: [http://localhost:15672](http://localhost:15672)
   - Usuario: usuario
   - Contraseña: clave123

