/*

 */



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
            BrokerComm commBroker = new BrokerComm();
            String ipBroker=lector.nextLine();
            int portBroker=Integer.parseInt(lector.nextLine());
            String ipActual="";
            int portActual=6666;
            try{
                commBroker.empezarConexion("192.168.248.250", portActual);
                jsonServerInfo.put("Servidor", ipActual);
                jsonServerInfo.put("Puerto", portActual);
                jsonServerInfo.put("Servicio", "votar");
                jsonServerInfo.put("Parametros", 1);
                commBroker.realizarConexionBroker(jsonServerInfo);
                commBroker.stop();

            }catch(Exception e){
                e.printStackTrace();
            }
            
            server.start(6666);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
