/* oberon.flex */
/* --------------------------Usercode Section------------------------ */

import java.io.*;
import exceptions.*;

%%
/* -----------------Options and Declarations Section----------------- */

%class OberonScanner
%public
%ignorecase
%line 
%column
%yylexthrow LexicalException
%type String
%unicode
%eofval{
	return "EOF";
%eofval}

%{
int get_line(){return yyline;}
int get_column(){return yycolumn;}
%}

Operator = "+"|"-"|"*"|"div"|"mod"|":="|"="|"#"|">"|"<"|">="|"<="|"("|")"|"&"|"or"|"~"|"["|"]"|"."|":"
ReservedWord = "If" | "then" | "elsif" | "else" | "while" | "do" | "begin" | "end" | "of" | "record" | "array" | "module" | "const "| "type" | "var" | "procedure"
Keyword	= "integer" | "write" | "read" | "writeln" | "boolean"
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
	{Comment}	{return "comment";}
	{MismatchedComment}	{throw new MismatchedCommentException();}
	{WhiteSpace}	{/* just skip what was found, do nothing */}
	{Operator}		{return "Operator";}
	{ReservedWord}	{return "ReservedWoed";}
	{Keyword}		{return "Keyword";}
	{Punctuation}	{return "Punctuation";}
	{IllegalOctal}	{throw new IllegalOctalException();}
	{IllegalInteger}	{throw new IllegalIntegerException();}
	{Number}		{
				if (yylength() > 12)
					throw new IllegalIntegerRangeException();
				else {
					{return "Number";}
				}
			}
	{Identifier}		{
				if (yylength() > 24)
					throw new IllegalIdentifierLengthException();
				else {
					{return "Identifier";}
				}
			}
}
[^]	{throw new IllegalSymbolException();}

