
package arquivos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Arquivos {
static File arquivo;  
static File carpeta;
    
    public static void main(String[] args) {
    
//   crearCarpeta("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir");
//   crearArquivos("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir/product1.txt");
//   crearCarpeta("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir/subdir");
//   crearArquivos("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir/subdir/product2.txt");   
//   
//   verRuta("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir");
//   listaArq("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir");
//   infoArq("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir/product1.txt");
//   soLectura("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir/product1.txt");
//   //infoArq("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir/product1.txt");
//   soEscritura("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir/product1.txt");
     borraloTodo("/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/arquivos/arquivosdir");
    }
   
    
 public static void crearArquivos(String ruta){
    
     File xenerico = new File(ruta);
    if(!xenerico.exists()){
         try {
             if(xenerico.createNewFile()){
                 System.out.println("Arquivo creado correctamente");
             }} catch (IOException ex) {
             Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
         }
    }else{
        System.out.println("Erro ao crealo arquivo");
    }
 }
 public static void crearCarpeta(String ruta){
      carpeta = new File(ruta);
      
       if(!carpeta.exists()){
         if (carpeta.mkdir()){
             System.out.println("directorio creado");
                 
         }
         else{
             System.out.println("Fallo ao crealo directorio ");
         }
          
      }
      
    

 }   

public static void verRuta(String ruta){
   
    File archivo = new File(ruta);
    
    if(archivo.exists()==true){
        
        System.out.println("A ruta e "+ archivo.getAbsolutePath());
    }
    else{
        System.out.println("O arquivo non existe ");
    }
} 
public static void listaArq(String ruta){
   
    File arquivo = new File(ruta);
    
    if(arquivo.exists()==true){
        String archivos [] = arquivo.list();
       
        for(int i=0;i<archivos.length;i++){
         if(arquivo.isDirectory()){  
        System.out.println(""+archivos[i]);
       
         }
       
        }
    }else{
        System.out.println("O arquivo non existe ou está valeiro");
    }
        
    
}

public static void infoArq(String ruta){
    
    File arquivo = new File(ruta);
    
    if(arquivo.exists()==true){
        if(arquivo.canRead()){
            System.out.println("Pódese lee-lo no arquivo");
        }else{
            System.out.println("non se pode lee-lo arquivo");
        }
        if(arquivo.canWrite()){
            System.out.println("Pódese escribir no arquivo");
        }else{
            System.out.println("Non se pode lee-lo arquivo");
        }
        System.out.println(arquivo.length());
    }
}
public static void soLectura(String ruta){
    
    File arquivo = new File(ruta);
    
    if(arquivo.exists()==true){
     arquivo.setReadOnly();
    }
}

public static void soEscritura(String ruta){
    
    File arquivo = new File(ruta);
    
    if(arquivo.exists()==true){
        
        arquivo.setWritable(true);
        arquivo.setReadable(true);
    }
}
public static void borrArquivo(String ruta){
    arquivo  =  new File(ruta);
    if(arquivo.exists()){
        arquivo.delete();
        System.out.println("Arquivo borrado con éxito");
    }
    System.out.println("O arquivo non se pudo borrar");
}
public static void borraloTodo(String ruta){
    carpeta = new File(ruta);
    
    if(carpeta.exists()){
        File arquivos [] = carpeta.listFiles();
     for(int i=0;i<arquivos.length;i++){
        arquivos[i].delete();
        if(arquivos[i]!=null){
            borraloTodo(arquivos[i].getPath());
        }
     }
        System.out.println("As carpetas foron borradas");
    }
        
    carpeta.delete();
    
}
}
