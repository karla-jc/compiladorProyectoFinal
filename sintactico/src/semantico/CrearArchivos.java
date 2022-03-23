/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Usuario iTC
 */
public class CrearArchivos {
    public static void main(String[] args) {
        try {
            String ruta = "datos" + File.separatorChar;
            String[] rutas = {ruta + "Lexer.flex"};
            String[] rutasS = {"-parser", "Sintax", ruta + "Sintax.cup"};
            java_cup.Main.main(rutasS);
            jflex.Main.generate(rutas);
            System.out.println(ruta);
            
            Path sym = Paths.get(System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar + "semanticopf" + File.separatorChar + "sym.java");
            eliminar(sym);
            Files.move(Paths.get(System.getProperty("user.dir") + File.separatorChar + "sym.java"), sym);
            
            Path sym1 = Paths.get(System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar + "semanticopf" + File.separatorChar + "Sintax.java");
            eliminar(sym1);
            Files.move(Paths.get(System.getProperty("user.dir") + File.separatorChar + "Sintax.java"), sym1);
            
            Path lex = Paths.get(System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar + "semanticopf" + File.separatorChar + "LexerCup.java");
            eliminar(lex);
            Files.move(Paths.get(ruta + "LexerCup.java"), lex);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private static void eliminar(Path ruta){
         try{
             if(Files.exists(ruta)){
                 Files.delete(ruta);
             }
         }catch(Exception e){
             System.out.println("Error " + ruta + " "+e);
         
         }
     }
    
}
