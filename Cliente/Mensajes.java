/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import org.json.JSONObject;

/**
 *
 * @author David Pat
 */
public class Mensajes {

    public static String listar(String servicio){
        JSONObject mensaje = new JSONObject();
        mensaje.put("servicio", "listar");
        mensaje.put("variables", 1);
        mensaje.put("variable1", "palabra");
        mensaje.put("valor1", servicio);
        return mensaje.toString();
    }
    public static String listar(){
        JSONObject mensaje = new JSONObject();
        mensaje.put("servicio", "listar");
        mensaje.put("variables", 0);
        return mensaje.toString();
    }
    
    public static String contar(){
        JSONObject mensaje = new JSONObject();
        mensaje.put("servicio", "ejecutar");
        mensaje.put("variables", 1);
        mensaje.put("variable1", "servicio");
        mensaje.put("valor1", "contar");
        return mensaje.toString();
    }
    public static JSONObject contar2(){
        JSONObject mensaje = new JSONObject();
        mensaje.put("servicio", "ejecutar");
        mensaje.put("variables", 1);
        mensaje.put("variable1", "servicio");
        mensaje.put("valor1", "contar");
        return mensaje;
    }
}
