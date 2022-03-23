/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;
import compilador.model.Tokens;
import java.io.File;
import jflex.Main;

import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Usuario
 */
public class Compilador {
    private static String ruta = "datos" + File.separatorChar;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //generarArchivo();
         try {
            Lexer lexer= new Lexer (new FileReader(ruta+"codigo.jcr"));
            String result ="";
            while(true){
                Tokens token = lexer.yylex();
                   if(token == null){
                       result +="FIN";
                       break;
                   }
                   switch(token){
                       case ERROR: 
                           result+= lexer.lexema+ "  Es un símbolo desconocido";
                           break;
                       case NUMERO: 
                           result+= lexer.lexema+ "  Es un número";    
                           break;   
                       case PALABRA: 
                           result+= lexer.lexema+ "  Es una Palabra"; 
                           break;    
                       case RESERVADA: 
                           result+= lexer.lexema+ "  Es palabra reservada";    
                           break;    
                       case COMA: 
                           result+= lexer.lexema+ "  Es coma";    
                           break;
                       case PUNTO_COMA: 
                           result+= lexer.lexema+ "  Es punto y coma";    
                           break;  
                       case COMILLAS: 
                           result+= lexer.lexema+ "  Son comillas";    
                           break;   
                       case PUNTO: 
                           result+= lexer.lexema+ "  Es punto";    
                           break;
                        case DOS_PUNTOS: 
                           result+= lexer.lexema+ "  Son dos puntos";    
                           break;     
                       case MP: 
                           result+= lexer.lexema+ "  Palabra correcta con MP";    
                           break;  
                       case NP: 
                           result+= lexer.lexema+ "  Palabra incorrecta con NP";    
                           break;      
                        case MB: 
                           result+= lexer.lexema+ "  Palabra correcta con MB";    
                           break;  
                       case NB: 
                           result+= lexer.lexema+ "  Palabra incorrecta con NB";    
                           break;      
                       case UN_TILDADA: 
                           result+= lexer.lexema+ "  Palabra ún SI tildada";    
                           break;  
                       case UN_SIN_TILDE: 
                           result+= lexer.lexema+ "  Palabra un NO tildada";    
                           break; 
                       case ION_TILDADA: 
                           result+= lexer.lexema+ "  Palabra ión SI tildada";    
                           break;  
                       case ION_SIN_TILDE: 
                           result+= lexer.lexema+ "  Palabra ion NO tildada";    
                           break;     
                   }
                   System.out.println(result);
                   result= "";
            }
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }   
    public static void generarArchivo(){
        try {
            String[]archivos = {(ruta+ "lexer.flex")};
            Main.generate(archivos);
        } catch (Exception e) {
            System.out.println("Error al generar archivo"+e);
        }
    }
    
}