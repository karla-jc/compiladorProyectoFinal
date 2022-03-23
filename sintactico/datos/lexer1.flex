package compilador;
import compilador.model.Tokens;
%%
%class Lexer
%type Tokens
N=[0-9]
SI_UN_SIN=[A-Z]*[U][N]
Si_un_sin=[a-z]*[u][n]
SI_UN_CON=[A-Z]*[Ú][N]
Si_un_con=[a-z]*[ú][n]

A=[A-Z]*[U][N][A-Za-z]*
B=[a-z]*[u][n][a-zA-Z]*
C=[A-Z]*[Ú][N][A-Za-z]*
D=[a-z]*[ú][n][a-zA-Z]*

SI_ION_SIN=[A-Z]*[I][O][N]
Si_ion_sin=[a-z]*[i][o][n]
SI_ION_CON=[A-Z]*[I][Ó][N]
Si_ion_con=[a-z]*[i][ó][n]

E=[A-Z]*[I][O][N][A-Za-z]*
F=[a-z]*[i][o][n][a-zA-Z]*
G=[A-Z]*[I][Ó][N][A-Za-z]*
H=[a-z]*[i][ó][n][a-zA-Z]*

SI_MP=[A-Z]*[M][P][A-Z]*
SI_mp=[a-z]*[m][p][a-z]*
SI_NP=[A-Z]*[N][P][A-Z]*
SI_np=[a-z]*[n][p][a-z]*

SI_MB=[A-Z]*[M][B][A-Z]*
SI_mb=[a-z]*[m][b][a-z]*
SI_NB=[A-Z]*[N][B][A-Z]*
SI_nb=[a-z]*[n][b][a-z]*
L=[a-zA-Z]*[_]*[0-9]*+
espacio=[ ,\t,\r,\n]+
%{ 
    public String lexema;
%}
%%
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\"" {lexema=yytext(); return Tokens.COMILLAS;}
";" {lexema=yytext(); return Tokens.PUNTO_COMA;}
":" {lexema=yytext(); return Tokens.DOS_PUNTOS;}
"," {lexema=yytext(); return Tokens.COMA;}
"." {lexema=yytext(); return Tokens.PUNTO;}
{SI_MP} {lexema=yytext(); return Tokens.MP;}
{SI_mp} {lexema=yytext(); return Tokens.MP;}
{SI_NP} {lexema=yytext(); return Tokens.NP;}
{SI_np} {lexema=yytext(); return Tokens.NP;}

{SI_MB} {lexema=yytext(); return Tokens.MB;}
{SI_mb} {lexema=yytext(); return Tokens.MB;}
{SI_NB} {lexema=yytext(); return Tokens.NB;}
{SI_nb} {lexema=yytext(); return Tokens.NB;}
{SI_UN_CON} {lexema=yytext(); return Tokens.UN_TILDADA;}
{Si_un_con} {lexema=yytext(); return Tokens.UN_TILDADA;}
{SI_UN_SIN} {lexema=yytext(); return Tokens.UN_SIN_TILDE;}
{Si_un_sin} {lexema=yytext(); return Tokens.UN_SIN_TILDE;}
{N}+ {lexema=yytext(); return Tokens.NUMERO;}
{SI_ION_CON}+ {lexema=yytext(); return Tokens.ION_TILDADA;}
{Si_ion_con}+ {lexema=yytext(); return Tokens.ION_TILDADA;}
{SI_ION_SIN}+ {lexema=yytext(); return Tokens.ION_SIN_TILDE;}

{L}+ {lexema=yytext(); return Tokens.PALABRA;}
{A}+ {lexema=yytext(); return Tokens.PALABRA;}
{B}+ {lexema=yytext(); return Tokens.PALABRA;}
{C}+ {lexema=yytext(); return Tokens.PALABRA;}
{D}+ {lexema=yytext(); return Tokens.PALABRA;}

{E}+ {lexema=yytext(); return Tokens.PALABRA;}
{F}+ {lexema=yytext(); return Tokens.PALABRA;}
{G}+ {lexema=yytext(); return Tokens.PALABRA;}
{H}+ {lexema=yytext(); return Tokens.PALABRA;}

"ENTERO" {lexema=yytext(); return Tokens.RESERVADA;}
 . {lexema=yytext(); return Tokens.ERROR;}