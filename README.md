# Chat Asíncrono con RabbitMQ 

##  Descripción
Este proyecto implementa un sistema de mensajería asíncrona utilizando RabbitMQ como broker de mensajes. Incluye un productor (emisor) y un consumidor (receptor) desarrollados en Java, contenerizados con Docker para fácil despliegue.

## Tecnologías
- Java 21
- RabbitMQ
- Docker y Docker Compose

## Instalación y ejecución

1. Clona el repositorio y abre la carpeta:
   
   git clone https://github.com/CeciliaVargas0025/SDtrabajofinal.git

   cd SDtrabajofinal
   

2. Construye e inicia los contenedores:
   
   docker-compose up --build

   
3. Verificar contenedores en ejecución

   docker ps

Se debe ver tres servicios activos:

sdtrabajofinal-rabbitmq-1

sdtrabajofinal-emisor-1

sdtrabajofinal-receptor-1

4. En una terminal nueva, conectarse al emisor para enviar mensajes:

   docker attach sdtrabajofinal-emisor-1

   Escribe los mensajes y presiona Enter para enviarlos.
   

4. En otra terminal, ver los mensajes recibidos:

   docker logs -f sdtrabajofinal-receptor-1

5. Acceder al panel de control de RabbitMQ:
   - URL: [http://localhost:15672](http://localhost:15672)
   - Usuario: usuario
   - Contraseña: clave123

