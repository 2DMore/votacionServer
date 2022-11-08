/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Controlador.controladorVotos;
import Modelo.actualizableImp;
import Vista.vistaDocumentoPlano;
import Vista.vistaGraficaBarras;
import Vista.vistaGraficaPastel;
import Vista.vistaPrincipal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EQUIPO 1
 */
public class ClienteMain {
    public static ClienteB broker;
    public static void main(String[] args) {
        broker = new ClienteB();
        /*
        String argumento = args[0];
        String[] partir = argumento.split(":");
        try {
            broker.startConnection(partir[0],Integer.parseInt(partir[1]));
        } catch (IOException ex) {
            System.out.println("No se pudo comenzar la coneccion con el broker");
        }*/
        try{
            broker.startConnection("127.0.0.1", 3434);
        }catch(IOException ex){
            System.out.println("No se pudo conectar al broker");
        }
        try {
            String sendMessage = broker.sendMessage(Mensajes.votar("CHOCOLATE"));
            System.out.println(sendMessage);
        } catch (IOException ex) {
        }
        actualizableImp actualizable = new actualizableImp(3);
        vistaPrincipal VistaPrincipal = new vistaPrincipal();
        vistaDocumentoPlano vistaDoc = new vistaDocumentoPlano();
        vistaGraficaPastel pastel = new vistaGraficaPastel();
        vistaGraficaBarras barras = new vistaGraficaBarras();
        
        controladorVotos control = new controladorVotos(actualizable, VistaPrincipal, pastel, barras);
        VistaPrincipal.setVisible(true);
        vistaDoc.setVisible(false);
        pastel.setVisible(true);
        barras.setVisible(true);
    }
}
