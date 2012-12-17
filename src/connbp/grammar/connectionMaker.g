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
	Inicializador ini = Inicializador.getInstance();
}	

entrada throws ConnBPSemanticException: #(PROGRAMA . decl_conexiones);

decl_conexiones throws ConnBPSemanticException: #(CONNECTIONS (conexion)*) ;

conexion throws ConnBPSemanticException: #(n:NEXUS (atributo)+) 
	{
		if(!aux.keySet().containsAll(ini.getValidAttrConnections()))
			throw new ConnBPSemanticException("Required connection attribute not included in line "+n.getLine());
		Connection conn = new Connection(ini.getPeople().get(aux.get("ID1")),ini.getPeople().get(aux.get("ID2")),aux.get("Type"));
		if(!ini.containsConnection(conn))
			ini.getConnections().add(conn);
		else
			throw new ConnBPSemanticException("Connection already exists in line "+n.getLine());
		aux.clear();
	}
	;

atributo throws ConnBPSemanticException: #(i:ATR_IDENT a:ATR_VALOR)
	{ 
		if(!ini.getValidAttrConnections().contains(i.getText()))
			throw new ConnBPSemanticException("Invalid connection attribute in line "+i.getLine()+": "+i.getText());
		if(i.getText().equals("Type") && !ini.getValidConnectionTypes().contains(a.getText()))
			throw new ConnBPSemanticException("Invalid connection type in line "+i.getLine()+": "+a.getText());
		if((i.getText().equals("ID1") | i.getText().equals("ID2")) && !ini.getPeople().containsKey(a.getText()))
			throw new ConnBPSemanticException("The person with ID "+a.getText()+" in line "+i.getLine()+" doesn't exists");
		aux.put(i.getText(),a.getText());
	}
	;