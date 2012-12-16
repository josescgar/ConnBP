header {
	package connbp.grammar;
	import connbp.exceptions.ConnBPSemanticException;
	import java.util.HashMap;
	import connbp.helper.*;
	import java.util.LinkedList;
}

class ConnectionMaker extends TreeParser;

options {
	importVocab=Anasint;
}

{
	HashMap<String,String> aux = new HashMap<String,String>();
}	

entrada throws ConnBPSemanticException: #(PROGRAMA . decl_conexiones);

decl_conexiones throws ConnBPSemanticException: #(CONNECTIONS (conexion)*) ;

conexion throws ConnBPSemanticException: #(n:NEXUS (atributo)+) 
	{
		if(!aux.keySet().containsAll(Inicializador.getInstance().getValidAttrConnections()))
			throw new ConnBPSemanticException("Required connection attribute not included in line "+n.getLine());
		Inicializador.getInstance().getConnections().add(new Connection(Inicializador.getInstance().getPeople().get(aux.get("ID1")),Inicializador.getInstance().getPeople().get(aux.get("ID2")),aux.get("Type")));
		aux.clear();
	}
	;

atributo throws ConnBPSemanticException: #(i:ATR_IDENT a:ATR_VALOR)
	{ 
		if(!Inicializador.getInstance().getValidAttrConnections().contains(i.getText()))
			throw new ConnBPSemanticException("Invalid connection attribute in line "+i.getLine()+": "+i.getText());
		if(i.getText().equals("Type") && !Inicializador.getInstance().getValidConnectionTypes().contains(a.getText()))
			throw new ConnBPSemanticException("Invalid connection type in line "+i.getLine()+": "+a.getText());
		if((i.getText().equals("ID1") | i.getText().equals("ID2")) && !Inicializador.getInstance().getPeople().containsKey(a.getText()))
			throw new ConnBPSemanticException("The person with ID "+a.getText()+" in line "+i.getLine()+" doesn't exists");
		aux.put(i.getText(),a.getText());
	}
	;
