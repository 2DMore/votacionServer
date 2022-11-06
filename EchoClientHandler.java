/*

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import Modelo.actualizableImp;


public class EchoClientHandler extends Thread{
    private Socket clienteSocket;
    private PrintWriter out;
    private BufferedReader in;
    private actualizableImp actualizable;

    public EchoClientHandler(Socket aceptar) {
        this.clienteSocket = aceptar;
    }
    
    @Override
    public void run(){
        try {
            out = new PrintWriter(clienteSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            actualizableImp actualizable = new actualizableImp(3);
            String mensaje;
            out.println("Conección hecha");
            System.out.println("Conexion hecha");
            while((mensaje=in.readLine()) != null){
                switch(in.readLine()){
                    case "1":
                        actualizable.actualizarProductoUno();
                        out.println(actualizable.getProductoUnoVotos()+","+actualizable.getProductoDosVotos()+","+actualizable.getProductoTresVotos());
                        break;
                    case "2":
                        actualizable.actualizarProductoDos();
                        out.println(actualizable.getProductoUnoVotos()+","+actualizable.getProductoDosVotos()+","+actualizable.getProductoTresVotos());
                        break;
                    case "3":
                        actualizable.actualizarProductoTres();
                        out.println(actualizable.getProductoUnoVotos()+","+actualizable.getProductoDosVotos()+","+actualizable.getProductoTresVotos());
                        break;

                    default:
                        out.println("Adios cliente" +clienteSocket.getPort());
                        System.out.println("Cliente desconectado");
                        break;

                }
                /* 
                if(".".equals(mensaje)){
                    out.println("Adios cliente" +clienteSocket.getPort());
                    System.out.println("Cliente desconectado");
                    break;
                }else{
                    out.println("Server: "+ mensaje.toUpperCase() +"["+clienteSocket.getPort()+"]");
                }*/
            }
            out.println("Cerrando...");
            
            in.close();
            out.close();
            clienteSocket.close();
        } catch (IOException ex) { 
            System.out.println("Echo server: "+ ex.getMessage());
        }    
    }
    
}
