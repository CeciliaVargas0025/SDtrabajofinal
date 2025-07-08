
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

public class Productor {
    private final static String NOMBRE_FILA = "chat_fila";

    public static void main(String[] args) throws Exception {
        ConnectionFactory fabrica = new ConnectionFactory();
        fabrica.setHost("rabbitmq");
        fabrica.setUsername("usuario");
        fabrica.setPassword("clave123");

        try (Connection conexion = fabrica.newConnection();
             Channel canal = conexion.createChannel();
             Scanner entrada = new Scanner(System.in)) {

            canal.queueDeclare(NOMBRE_FILA, true, false, false, null);

            System.out.println("Escribe un mensaje (o 'salir'):");
            while (true) {
                System.out.print("> ");
                var mensaje = entrada.nextLine();
                if ("sair".equalsIgnoreCase(mensaje)) break;
                canal.basicPublish("", NOMBRE_FILA, null, mensaje.getBytes());
                System.out.println("Mensaje enviado: " + mensaje);
            }
        }
    }
}
