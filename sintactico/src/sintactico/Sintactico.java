/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sintactico;

import sintactico.LexerCup;
import java.io.StringReader;
import analizadorSintactico.Sintax;
import java_cup.Lexer;
import java_cup.runtime.Symbol;

/**
 *
 * @author Usuario
 */
public class Sintactico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena="Tales como; Paul, Jorge .";
        Sintax s = new Sintax(new LexerCup(new StringReader(cadena)));
        try {
            s.parse();
        } catch (Exception e) {
            Symbol sym= s.getS();
          //  System.out.println(sym);
            System.out.println("Error de sintaxis linea"+(sym.right + 1)+" columna "+(sym.left+1)+" Texto "+sym.value) ;
        }
    }
    
}
