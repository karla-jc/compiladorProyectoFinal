/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sintactico;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author Usuario
 */
public class CrearArchivos {

    public static void main(String[] args) {
        try {
            String ruta = "datos" + File.separatorChar;
            String[] rutas = {ruta + "Lexer.flex"};
            
            String [] rutasS ={"-parser","Sintax",ruta+"Sintax.cup"};
            java_cup.Main.main(rutasS);
            jflex.Main.generate(rutas);
            //System.out.println(ruta);
            
            //path de java
            Path sym = Paths.get(System.getProperty("user.dir")+File.separatorChar+"src"+File.separatorChar+"analizadorSintactico"+File.separatorChar+"sym.java");
            eliminar(sym);
            Path sym1 = Paths.get(System.getProperty("user.dir")+File.separatorChar+"src"+File.separatorChar+"analizadorSintactico"+File.separatorChar+"Sintax.java");
            eliminar(sym1);
            Path lex = Paths.get(System.getProperty("user.dir")+File.separatorChar+"src"+File.separatorChar+"analizadorSintactico"+File.separatorChar+"LexerCup.java");
            eliminar(lex);
//            System.out.println(System.getProperty("user.dir"));

            Files.move(Paths.get(System.getProperty("user.dir")+File.separatorChar+"sym.java"),sym);
            Files.move(Paths.get(System.getProperty("user.dir")+File.separatorChar+"Sintax.java"),sym1);
            Files.move(Paths.get(ruta+"LexerCup.java"),lex);
                    
        } catch (Exception e) {
            System.out.println("Error en analizador" + e);
        }
    }
    private static void eliminar(Path ruta){
        try {
            if (Files.exists(ruta)) {
                Files.delete(ruta);
            }
            
        } catch (Exception e) {
            System.out.println("Error"+ruta+" "+e);
        }
    }
}
