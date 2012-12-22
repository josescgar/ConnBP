header {
	package connbp.grammar;
}

class Analex extends Lexer;

options {
	importVocab=Anasint;
	charVocabulary = '\3'..'\377';
	caseSensitiveLiterals=false;
	k=2;
}

tokens {
	PEOPLE="PEOPLE";
	CONNECTIONS="CONNECTIONS";
	PERSON="PERSON";
	NEXUS="NEXUS";
	QUERIES="QUERIES";
	RELATEDTO="RelatedTo";
	CONNECTIONSFOR="ConnectionsFor";
	LEVELCONNECTIONSFOR="LevelConnectionsFor";
	GRAPH="Graph";
}

{
	boolean valor=false;
}

//Blancos y líneas
protected NUEVA_LINEA : "\r\n" 
{newline();};
BLANCO : (' '|'\t'|NUEVA_LINEA)
{$setType(Token.SKIP);};

//Comentarios
COML: "//" (~'\r')*
{$setType(Token.SKIP);};

COMB: "/*" (options{greedy=false;}:(NUEVA_LINEA|.))* "*/"
{$setType(Token.SKIP);};

//Identificadores
protected LETRA: ('a'..'z'|'A'..'Z'| '_' | 'á'..'ú');
protected DIGITO: '0' .. '9';
protected TEXTO: (LETRA | DIGITO | '@' | '.' | '-' | BLANCO)+;
ATR_IDENT: {!valor}? (LETRA|DIGITO)+ ;

//Atributos
ATR_VALOR: {valor}?  TEXTO ;
INI_VALOR: {!valor}? '[' {valor=true;} ;
FIN_VALOR: {valor}? ']' {valor=false;} ;

//Bloques y separadores
INI_BLOQUE: '{';
FIN_BLOQUE: '}';
SEPARADOR: ',';
FIN_QUERY: '?';