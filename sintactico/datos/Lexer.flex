package analizadorSintactico;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
MAYUS=[A-Z]+
Mayus=[A-Z]+[a-z]+
Minus=[a-z]+

D=[0-9]*[.][0-9]*
Double=[0-9]+
espacio=[ ,\t,\n,\r]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* comentarios */
("//"(.)*) {/*Ignore*/}

/* Tipo de dato NO RETORNO */
(VACIO) {return new Symbol (sym.VACIO, yychar, yyline, yytext());}

/* punto y coma */
(";") {return new Symbol (sym.Punto_coma, yychar, yyline, yytext());}

/* Coma */
("/,") {return new Symbol (sym.Coma, yychar, yyline, yytext());} 

/* Dos puntos */
(":") {return new Symbol (sym.Dos_puntos, yychar, yyline, yytext());}

/* MAYUSCULA */
{MAYUS} {return new Symbol (sym.MAYUSCULA, yychar, yyline, yytext());}

/* Mayuscula */
{Mayus} {return new Symbol (sym.Mayuscula, yychar, yyline, yytext());}

/* Minuscula */
{Minus} {return new Symbol (sym.Minuscula, yychar, yyline, yytext());}

/* Comillas */
("\"") {return new Symbol (sym.Comillas, yychar, yyline, yytext());}

/* punto */
(".") {return new Symbol (sym.Punto, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol (sym.ERROR, yychar, yyline, yytext());}