package Server;


import Cliente.ClienteB;
import Cliente.Mensajes;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;

public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerMultiCliente server  = new ServerMultiCliente();
        try {
            //Conexion por primera vez FUNCION DE CLIENTE UNICO
            JSONObject jsonServerInfo = new JSONObject();
            Scanner lector = new Scanner(System.in);
            //BrokerComm commBroker = new BrokerComm();
            ClienteB broker = new ClienteB();
            //String ipBroker=lector.nextLine();
            //int portBroker=Integer.parseInt(lector.nextLine());
            String ipActual="127.0.0.1";
            int portActual=3434;
            try{
                System.out.println("Llegue aqui");
                //commBroker.empezarConexion(ipActual, portActual);
                jsonServerInfo.accumulate("servicio", "registrar");
                jsonServerInfo.accumulate("variables", 10);
                jsonServerInfo.accumulate("variable1", "servidor");
                jsonServerInfo.accumulate("valor1", ipActual);
                jsonServerInfo.accumulate("variable2", "puerto");
                jsonServerInfo.accumulate("valor2", 6666);
                jsonServerInfo.accumulate("variable3", "servicio");
                jsonServerInfo.accumulate("valor3","votar");
                jsonServerInfo.accumulate("variable4", "parametros");
                jsonServerInfo.accumulate("valor4", 1);
                jsonServerInfo.accumulate("variable5", "servicio");
                jsonServerInfo.accumulate("valor5","contar");
                jsonServerInfo.accumulate("variable6", "parametros");
                jsonServerInfo.accumulate("valor6", 0);
                jsonServerInfo.accumulate("variable7", "servicio");
                jsonServerInfo.accumulate("valor7","registrar");
                jsonServerInfo.accumulate("variable8", "parametros");
                jsonServerInfo.accumulate("valor8", 2);
                jsonServerInfo.accumulate("variable9", "servicio");
                jsonServerInfo.accumulate("valor9","listar");
                jsonServerInfo.accumulate("variable10", "parametros");
                jsonServerInfo.accumulate("valor10", 0);
                System.out.println("Respuesta: ");
                
                
                String respuesta = broker.mensajear(ipActual, portActual, jsonServerInfo.toString());
                System.out.println(respuesta);
                String respuesta2 = broker.mensajear(ipActual, portActual,Mensajes.listar());
                System.out.println(respuesta2);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            server.start(6666);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
}
