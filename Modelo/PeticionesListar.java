package Modelo;

import java.io.IOException;

import org.json.JSONObject;

import Cliente.ClienteMain;
import Cliente.Mensajes;

public class PeticionesListar {
    


    public static String listarServiciosBroker(){
        String serviciosString;
        try {
            serviciosString  = ClienteMain.broker.sendMessage(Mensajes.listar());
        } catch (IOException e) {
            return "No se pudo enviar el mensaje al broker: \n" +e.getMessage();
        }
        JSONObject respuesta = new JSONObject(serviciosString);
        int respuestas = respuesta.getInt("respuestas");
        for(int i=0; i< respuestas; i++){
            String respuestaA = respuesta.getString("respuesta"+(i+1));
            String valorA = respuesta.getString("valor"+(i+1));
            serviciosString += respuestaA +": "+ valorA + "\n";
        }
        return serviciosString;
    }

    public static String buscarServiciosBroker(String buscar){
        String serviciosString;
        try {
            serviciosString  = ClienteMain.broker.sendMessage(Mensajes.listar(buscar));
        } catch (IOException e) {
            return "No se pudo enviar el mensaje al broker: \n" +e.getMessage();
        }
        JSONObject respuesta = new JSONObject(serviciosString);
        int respuestas = respuesta.getInt("respuestas");
        for(int i=0; i< respuestas; i++){
            String respuestaA = respuesta.getString("respuesta"+(i+1));
            String valorA = respuesta.getString("valor"+(i+1));
            serviciosString += respuestaA +": "+ valorA + "\n";
        }
        
        if(serviciosString.equals("")){
            serviciosString += "No se encontró encontró el servicio";
        }
        return serviciosString;
    }

    

}
