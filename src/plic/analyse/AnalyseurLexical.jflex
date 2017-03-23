package plic.analyse ;

import java_cup.runtime.*;
import plic.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

%state commentaire

commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]

idf = [a-zA-Z]+([0-9]+ | [a-zA-Z] | "_" | "$")*
chaine = ( \"[^\"]*\" )
classe = "classe"
publique = "publique"
privee = "privee"
entier = "entier"
fin = "fin"
ecrire = "ecrire"


csteE = [0-9]+
csteB = "vrai" | "faux"

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

debut = "debut"
fin = "fin"
operoper = "++" | "--"

%%

<YYINITIAL> {commentaireSlashSlash} {}
<YYINITIAL> {commentaireSlashEtoile} { yybegin(commentaire); }
<commentaire> {commentaireEtoileSlash} { yybegin(YYINITIAL); }




<YYINITIAL> {entier}				{ return symbol(CodesLexicaux.entier); }
<YYINITIAL> {classe} 				{ return symbol(CodesLexicaux.classe); }
<YYINITIAL> {publique}			{ return symbol(CodesLexicaux.publique); }
<YYINITIAL> {privee}				{ return symbol(CodesLexicaux.privee); }
<YYINITIAL> {ecrire}        { return symbol(CodesLexicaux.ecrire); }
<YYINITIAL> {fin}           { return symbol(CodesLexicaux.fin); }



<YYINITIAL> ";"           { return symbol(CodesLexicaux.pointvirgule); } 
<YYINITIAL> "="           { return symbol(CodesLexicaux.egal); }
<YYINITIAL> ","           { return symbol(CodesLexicaux.virgule); }


<YYINITIAL> "+"                	{ return symbol(CodesLexicaux.PLUS); }
<YYINITIAL> "-"                	{ return symbol(CodesLexicaux.MOINS); }
<YYINITIAL> "*"                	{ return symbol(CodesLexicaux.MULT); }
<YYINITIAL> "/"                	{ return symbol(CodesLexicaux.DIV); }



<YYINITIAL> "+"                	{ return symbol(CodesLexicaux.PLUS); }
<YYINITIAL> "-"                	{ return symbol(CodesLexicaux.MOINS); }
<YYINITIAL> "*"                	{ return symbol(CodesLexicaux.MULT); }
<YYINITIAL> "/"                	{ return symbol(CodesLexicaux.DIV); }

<YYINITIAL> "=="                    { return symbol(CodesLexicaux.EGALEGAL); }
<YYINITIAL> "!="                    { return symbol(CodesLexicaux.DIFF); }
<YYINITIAL> "<"                	{ return symbol(CodesLexicaux.INF); }
<YYINITIAL> ">"                	{ return symbol(CodesLexicaux.SUP); }

<YYINITIAL> "et"                	{ return symbol(CodesLexicaux.ET); }
<YYINITIAL> "ou"                	{ return symbol(CodesLexicaux.OU); }
<YYINITIAL> "non"                	{ return symbol(CodesLexicaux.NON); }

<YYINITIAL> "("                	{ return symbol(CodesLexicaux.PAROUV); }
<YYINITIAL> ")"                	{ return symbol(CodesLexicaux.PARFER); }

<YYINITIAL> {csteE}      	        { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
<YYINITIAL> {csteB}      	        { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }

<YYINITIAL> {idf} 				{ return symbol(CodesLexicaux.idf, yytext()); }
<YYINITIAL> {chaine} 				{ return symbol(CodesLexicaux.chaine, yytext()); }

<YINITIAL> {debut}				{return symbol(CodesLexicaux.debut, yytext()); }
<YINITIAL> {fin}				{return symbol(CodesLexicaux.fin, yytext()); }
<YINITIAL> {operoper}			{return symbol(CoodesLexicaux.fin, yytext()); }

{espace}                { }

<YYINITIAL> .                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
<commentaire> .               {}
