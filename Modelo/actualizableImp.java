package Modelo;

/**
 *
 * @author isaac
 */
public class actualizableImp implements Actualizable{
    private Producto[] productos;
    private ManipuladorDocs documento = new ManipuladorDocs("archivoCandidatos.txt");
    private int[] votos;

    public actualizableImp(int cantidadCandidatos) {
        votos=obtenerInfoCandidatos();
        this.productos = new Producto[cantidadCandidatos];
        this.productos[0] = new Producto(votos[0],"Producto 1");
        this.productos[1] = new Producto(votos[1],"Producto 2");
        this.productos[2] = new Producto(votos[2],"Producto 3");
        guardarInfoCandidatosa();
    }
    
    public int[]obtenerInfoCandidatos(){
        return documento.obtenerVotosDoc();
    }

    public void guardarInfoCandidatosa(){
        documento.escribirArchivo(productos);
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
