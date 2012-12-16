// $ANTLR : "peopleFiller.g" -> "PeopleFiller.java"$

	package connbp.grammar;
	import connbp.helper.Person;
	import java.util.HashMap;
	import connbp.exceptions.ConnBPSemanticException;
	import java.util.LinkedList;
	import java.util.Map.Entry;

public interface PeopleFillerTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int PROGRAMA = 4;
	int PEOPLE = 5;
	// "{" = 6
	// "}" = 7
	int PERSON = 8;
	// "," = 9
	int ATR_IDENT = 10;
	// "[" = 11
	int ATR_VALOR = 12;
	// "]" = 13
	int CONNECTIONS = 14;
	int NEXUS = 15;
	int QUERIES = 16;
	// "?" = 17
	int RELATEDTO = 18;
	int CONNECTIONSFOR = 19;
	int LEVELCONNECTIONSFOR = 20;
	int GRAPH = 21;
}
