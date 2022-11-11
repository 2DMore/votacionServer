package Modelo;

/**
 *
 * @author isaac
 */
import Modelo.ManipuladorDocs;
public class actualizableImp implements Actualizable{
    private Producto[] productos;
    private ManipuladorDocs documento = new ManipuladorDocs("archivoCandidatos.txt");

    public actualizableImp(int cantidadCandidatos) {
        this.productos = new Producto[cantidadCandidatos];
        this.productos[0] = new Producto(0,"Producto 1");
        this.productos[1] = new Producto(0,"Producto 2");
        this.productos[2] = new Producto(0,"Producto 3");
        guardarInfoCandidatosa();
    }
    
    public void guardarInfoCandidatosa(){
        //documento.escribirArchivo(productos);
    }

    public Producto[] getProducto() {
        return productos;
    }
    
    public void actualizarProductoUno(){
        productos[0].aumentarVotos();
        actualizarInformacion();
    }
    
    public int getProductoUnoVotos(){
        return productos[0].getVotos();
    }
    
    public void actualizarProductoDos(){
        productos[1].aumentarVotos();
        actualizarInformacion();
    }
    
    public int getProductoDosVotos(){
        return productos[1].getVotos();
    }
    
    public void actualizarProductoTres(){
        productos[2].aumentarVotos();
        actualizarInformacion();
    }
    
    public int getProductoTresVotos(){
        return productos[2].getVotos();
    }
    
    @Override
    public void actualizarInformacion() {
        guardarInfoCandidatosa();
    }
}
