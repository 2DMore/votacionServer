
package Pruebas;

import Controlador.controladorVotos;
import Modelo.actualizableImp;
import Vista.vistaDocumentoPlano;
import Vista.vistaGraficaBarras;
import Vista.vistaGraficaPastel;
import Vista.vistaPrincipal;

/**
 *
 * @author isaac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        actualizableImp actualizable = new actualizableImp(3);
        vistaPrincipal VistaPrincipal = new vistaPrincipal();
        vistaDocumentoPlano vistaDoc = new vistaDocumentoPlano();
        vistaGraficaPastel pastel = new vistaGraficaPastel();
        vistaGraficaBarras barras = new vistaGraficaBarras();
        
        //controladorVotos control = new controladorVotos(actualizable, VistaPrincipal, pastel, barras);
        VistaPrincipal.setVisible(true);
        vistaDoc.setVisible(false);
        pastel.setVisible(true);
        barras.setVisible(true);
    }
    
}
