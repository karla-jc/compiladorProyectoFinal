/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import semanticopf.Sintax;
import semanticopf.LexerCup;
import java.io.StringReader;
import java_cup.runtime.Symbol;




/**
 *
 * @author Usuario iTC
 */
public class Semantico {
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena = "hola.";
        LexerCup lexer;
        lexer = new LexerCup(new StringReader(cadena));
        Sintax s = new Sintax(lexer);
        //Sintax s = new Sintax(new LexerCup(new StringReader(cadena)));
        Symbol auxS = null;
        try {
            s.parse();
            //auxS = s.parse();
        } catch (Exception e) {
            e.printStackTrace();
            Symbol sym = s.getS();
            //System.out.println(e);
            //Symbol sym = s.getS();
            //System.out.println("Error de sintaxis en la linea " + (sym.right +1) + "; columna " + (sym.left + 1) + "; Texto erroneo " + sym.value);
            if(sym != null){
                System.out.println("Error de sintaxis linea " + (sym.right + 1) + " columna " + (sym.left + 1) + " Texto " + sym.value);
            }else{
                System.out.println(e);
            }
            
        }
    }

    
    
    
}
