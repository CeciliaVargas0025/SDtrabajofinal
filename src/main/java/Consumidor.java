
import com.rabbitmq.client.*;

public class Consumidor {
    private final static String NOMBRE_FILA = "chat_fila";

    public static void main(String[] args) throws Exception {
        ConnectionFactory fabrica = new ConnectionFactory();
        fabrica.setHost("rabbitmq");
        fabrica.setUsername("usuario");
        fabrica.setPassword("clave123");

        Connection conexion = fabrica.newConnection();
        Channel canal = conexion.createChannel();

        canal.queueDeclare(NOMBRE_FILA, true, false, false, null);
        System.out.println("Esperando mensajes...");

        DeliverCallback callbackEntrega = (etiquetaConsumidor, entrega) -> {
            String mensaje = new String(entrega.getBody(), "UTF-8");
            System.out.println("Mensaje recibido: " + mensaje);
            canal.basicAck(entrega.getEnvelope().getDeliveryTag(), false);
        };

        boolean confirmacionAutomatica = false;
        canal.basicConsume(NOMBRE_FILA, confirmacionAutomatica, callbackEntrega, etiqueta -> {});
    }
}
