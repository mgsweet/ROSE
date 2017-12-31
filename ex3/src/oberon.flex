/* oberon.flex */
/* --------------------------Usercode Section------------------------ */

import java.io.*;
import exceptions.*;
import java_cup.runtime.*;

%%
/* -----------------Options and Declarations Section----------------- */

%cup
%class OberonScanner
%public
%type java_cup.runtime.Symbol
%ignorecase
%line 
%column
%yylexthrow LexicalException
%unicode
%eofval{
	return symbol(sym.EOF);
%eofval}

%{
	int get_line(){return yyline;}
	int get_column(){return yycolumn;}

	/* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
	private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

Comment	= "(*"~"*)"
Punctuation = ";" | ","
Identifier = [:jletter:]+[:jletterdigit:]*
Number = [1-9]+[0-9]* | 0[0-7]*
WhiteSpace 	= " "|\t|\b|\f|\r|\n|\r\n

IllegalOctal = 0[0-7]*[9|8]+[0-9]*
IllegalInteger 	= {Number}+{Identifier}+
MismatchedComment= "(*" ([^\*] | "*"+[^\)])* | ([^\(]|"("+[^\*])* "*)"

%%
/* ------------------------Lexical Rules Section---------------------- */
<YYINITIAL>
{
	"+"			{return symbol(sym.PLUS);}
	"-"			{return symbol(sym.MINUS);}
	"*"			{return symbol(sym.TIMES);}
	"DIV"		{return symbol(sym.DIVIDE);}
	"MOD"		{return symbol(sym.MOD);}
	":="		{return symbol(sym.ASSIGN);}
	"="			{return symbol(sym.EQ);}
	"#"			{return symbol(sym.NEQ);}
	"<"			{return symbol(sym.LT);}
	"<="		{return symbol(sym.LE);}
	">"			{return symbol(sym.GT);}
	">="		{return symbol(sym.GE);}
	"OR"		{return symbol(sym.OR);}
	"&"			{return symbol(sym.AND);}
	"~"			{return symbol(sym.NOT);}
	"IF"		{return symbol(sym.IF);}
	"THEN"		{return symbol(sym.THEN);}
	"ELSIF"		{return symbol(sym.ELSIF);}
	"ELSE"		{return symbol(sym.ELSE);}
	"WHILE"		{return symbol(sym.WHILE);}    
	"DO"		{return symbol(sym.DO);}
	"BEGIN"		{return symbol(sym.BEGIN);}
	"CONST"		{return symbol(sym.CONST);}
	"END"		{return symbol(sym.END);}
	"MODULE"	{return symbol(sym.MODULE);}
	"OF"		{return symbol(sym.OF);}
	"PROCEDURE"	{return symbol(sym.PROCEDURE);}
	"RECORD"	{return symbol(sym.RECORD);}
	"ARRAY"		{return symbol(sym.ARRAY);}
	"VAR"		{return symbol(sym.VAR);}
	"TYPE"		{return symbol(sym.TYPE);}
	"READ"		{return symbol(sym.READ);}
	"WRITE"		{return symbol(sym.WRITE);}
	"writeln"	{return symbol(sym.WRITELN);}
	"INTEGER"	{return symbol(sym.INTEGER);}
	"BOOLEAN"	{return symbol(sym.BOOLEAN);}
	";"			{return symbol(sym.SEMI);}
	":"			{return symbol(sym.COLON);}
	","			{return symbol(sym.COMMA);}
	"."			{return symbol(sym.PERIOD);}
	"["			{return symbol(sym.LBRACKET);}
	"]"			{return symbol(sym.RBRACKET);}
	"("			{return symbol(sym.LPAREN);}
	")"			{return symbol(sym.RPAREN);}

	{Comment}	{/*Do nothing*/}
	{MismatchedComment}	{throw new MismatchedCommentException(yytext());}
	{WhiteSpace}	{/* just skip what was found, do nothing */}
	{IllegalOctal}	{throw new IllegalOctalException(yytext());}
	{IllegalInteger}	{throw new IllegalIntegerException(yytext());}
	{Number}		{
				if (yylength() > 12)
					throw new IllegalIntegerRangeException(yytext());
				else {
					return symbol(sym.NUMBER, yytext());
				}
			}
	{Identifier}		{
				if (yylength() > 24)
					throw new IllegalIdentifierLengthException(yytext());
				else {
					return symbol(sym.IDENTIFIER, yytext());
				}
			}
}
[^]	{throw new IllegalSymbolException(yytext());}

