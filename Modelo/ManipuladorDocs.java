package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac
 */
public class ManipuladorDocs {
    private Scanner fileScanner;
    
    public ManipuladorDocs(String path){
        try {
            fileScanner = new Scanner(new File(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public String[][] leerArchivo(){
        String[] parsing = getContentFile();
        String[][] candidatosVotos = new String[parsing.length][2];
        for(int i = 0; i<parsing.length; i++){
            String[] parsing2 = parsing[i].split(",");
            System.arraycopy(parsing2, 0, candidatosVotos[i], 0, 2);
        }
        return candidatosVotos;
    }
    
    public String[] getContentFile(){
         String[] content = new String[3];
         int i = 0;
            while (fileScanner.hasNextLine()) {
                content[i]=fileScanner.nextLine()+"\n";
                i++;
            }
            fileScanner.close();
        return content;
    }
    


    public int[] obtenerVotosDoc(){
        String[] content = new String[3];
        content=getContentFile();
        int[] votos=new int[3];
        for(int i=0;i<content.length;i++){
            String[] columnas=content[i].split(",");
            System.out.println(columnas[1]);
            votos[i]=Integer.parseInt(columnas[1].trim());
        }
        return votos;
    }
    public String[] obtenerCandidatosDoc(){
        String[] content = getContentFile();
        String[] candidatos=new String[content.length];
        for(int i=0;i<content.length;i++){
            String[] columnas=content[i].split(",");
            System.out.println(columnas[0]);
            candidatos[i]=columnas[0].trim();
        }
        return candidatos;
    }
  
    public void closeFile(){
        fileScanner.close();
    }
    
    public void escribirArchivo(ArrayList<Producto> candidatosVotos){
        PrintWriter fileOut;
        try{
            fileOut = new PrintWriter(new FileWriter("archivoCandidatos.txt",false));
            for(int i = 0; i< candidatosVotos.size();i++){
                fileOut.println(candidatosVotos.get(i).getNombreProducto()+","+candidatosVotos.get(i).getVotos());
            }
            fileOut.close();
        }catch(FileNotFoundException e){
            System.out.println("Error: "+ e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ManipuladorDocs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribirBitacora(String evento, String fecha){
        PrintWriter fileOut;
        try{
            fileOut = new PrintWriter(new FileWriter("bitacora.txt",true));
            fileOut.println(fecha+" "+evento);
            fileOut.close();
        }catch(FileNotFoundException e){
            System.out.println("Error: "+ e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ManipuladorDocs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getContenidoBitacora(){
        String[] content = new String[2];
        int i = 0;
           while (fileScanner.hasNextLine()) {
               content[i]=fileScanner.nextLine()+"\n";
               i++;
           }
           fileScanner.close();
       return content;
   }
    
}
