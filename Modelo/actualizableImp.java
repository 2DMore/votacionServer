package Modelo;

import org.json.JSONObject;

/**
 *
 * @author isaac
 */
public class actualizableImp implements Actualizable{
    private Producto[] productos;
    private ManipuladorDocs documento = new ManipuladorDocs("archivoCandidatos.txt");
    private ManipuladorDocs bitacora = new ManipuladorDocs("bitacora.txt");
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

    public JSONObject votarJSON(JSONObject solicitud){
        JSONObject voteJSON=new JSONObject();
        voteJSON.put("servicio", "votar");
        voteJSON.put("respuestas", "1");
        if(solicitud.getString("variable1").equals("Producto 1")){
            voteJSON.put("respuesta1", solicitud.getString("variable1"));
            voteJSON.put("valor1", getProductoUnoVotos());
        }
        if(solicitud.getString("variable1").equals("Producto 2")){
            voteJSON.put("respuesta1", solicitud.getString("variable1"));
            voteJSON.put("valor1", getProductoDosVotos());
        }
        if(solicitud.getString("variable1").equals("Producto 3")){
            voteJSON.put("respuesta1", solicitud.getString("variable1"));
            voteJSON.put("valor1", getProductoTresVotos());
        }
        return voteJSON;
    }

    public JSONObject listarJSONVotos(){
        String[] arrayBit=bitacora.getContenidoBitacora();
        JSONObject listJSON=new JSONObject();
        listJSON.accumulate("servicio", "contar");
        listJSON.accumulate("respuestas",""+arrayBit.length);
        for(int i=0; i<arrayBit.length;i++){
            listJSON.accumulate("respuesta"+i, arrayBit[i]);
        }
        return listJSON;
    }

    public JSONObject contarObjBitacora(){
        JSONObject candJSON=new JSONObject();
        candJSON.accumulate("servicio", "contar");
        candJSON.accumulate("respuestas", "3");
        candJSON.accumulate("respuesta1", "Producto 1");
        candJSON.accumulate("valor1", ""+getProductoUnoVotos());
        candJSON.accumulate("respuesta2", "Producto 2");
        candJSON.accumulate("valor2", ""+getProductoDosVotos());
        candJSON.accumulate("respuesta3", "Producto 3");
        candJSON.accumulate("valor3", ""+getProductoTresVotos());
        return candJSON;
    }

    public JSONObject registroJSONBitacora(JSONObject solicitud){
        String evento=solicitud.getString("valor1");
        String fecha=solicitud.getString("valor2");
        bitacora.escribirBitacora(evento, fecha);
        String[] arrayBit=bitacora.getContenidoBitacora();
        JSONObject bitJSON=new JSONObject();
        bitJSON.accumulate("servicio", "registrar");
        bitJSON.accumulate("respuestas", "1");
        bitJSON.accumulate("respuesta1", "eventos");
        bitJSON.accumulate("valor1", ""+arrayBit.length);
        return bitJSON;
    }
}
