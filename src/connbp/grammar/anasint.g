header {
	package connbp.grammar;
}

class Anasint extends Parser;
options{
	k=4;
	buildAST = true;
}

tokens {
	PROGRAMA;
}

entrada: programa EOF!
		{ ##=#(#[PROGRAMA,"PROGRAMA"],##); }
	;

programa: decl_personas decl_conexiones decl_consultas;

decl_personas: PEOPLE^ "{"! (persona)+ "}"! ;

persona: PERSON^ "{"! atributo (","! atributo)* "}"! ;

atributo: ATR_IDENT^ "["! ATR_VALOR "]"! ;

decl_conexiones: CONNECTIONS^ "{"! (conexion)* "}"! ;

conexion: NEXUS^ "{"! atributo (","! atributo)* "}"! ;

decl_consultas: QUERIES^ "{"! (consulta "?"!)* "}"!;

consulta: "["! ATR_VALOR "]"! RELATEDTO^ "["! ATR_VALOR "]"!
	| "["! ATR_VALOR "]"! CONNECTIONSFOR^ "["! ATR_VALOR "]"!
	| "["! ATR_VALOR "]"! LEVELCONNECTIONSFOR^ "["! ATR_VALOR "]"!
	| GRAPH
	;
