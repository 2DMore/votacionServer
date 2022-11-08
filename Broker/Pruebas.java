/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;
import org.json.JSONObject;

import Cliente.Mensajes;
/**
 *
 * @author EQUIPO 1
 */
public class Pruebas {
    public static void main(String[] args) {
        Servicios s = new Servicios();
        /*JSONObject solicitud = new JSONObject();
        solicitud.accumulate("servicio", "registrar");
        solicitud.accumulate("variables", 4);
        solicitud.accumulate("variable1", "servidor");
        solicitud.accumulate("valor1", "148.209.67.45");
        solicitud.accumulate("variable2", "puerto");
        solicitud.accumulate("valor2", 75);
        solicitud.accumulate("variable3", "servicio");
        solicitud.accumulate("valor3", "votar");
        solicitud.accumulate("variable4", "parametros");
        solicitud.accumulate("valor4", 1);
        JSONObject solicitud2 = new JSONObject();
        solicitud2.accumulate("servicio", "registrar");
        solicitud2.accumulate("variables", 4);
        solicitud2.accumulate("variable1", "servidor");
        solicitud2.accumulate("valor1", "148.209.67.75");
        solicitud2.accumulate("variable2", "puerto");
        solicitud2.accumulate("valor2", 75);
        solicitud2.accumulate("variable3", "servicio");
        solicitud2.accumulate("valor3", "registrar");
        solicitud2.accumulate("variable4", "parametros");
        solicitud2.accumulate("valor4", 2);
        
        
        System.out.println(s.parseMensaje(solicitud.toString()));
        System.out.println(s.parseMensaje(solicitud2.toString()));
        System.out.println("---------");
        System.out.println(s.servidores.toString());
        System.out.println(s.servicios.toString());
        
        
        JSONObject listar = new JSONObject();
        listar.accumulate("servicio", "listar");
        listar.accumulate("variables", 1);
        listar.accumulate("valor1", "registrar");
        System.out.println(s.parseMensaje(listar.toString()));*/
        s.ejecutar(Mensajes.contar2());
    }
}
