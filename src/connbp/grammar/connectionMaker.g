header {
	package connbp.grammar;
	import connbp.exceptions.ConnBPConnectionException;
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
	String error="";
}	

entrada throws ConnBPConnectionException: #(PROGRAMA . decl_conexiones)
		{
			if(!error.isEmpty()){
				ini.getConnections().clear();
				throw new ConnBPConnectionException(error);
			}
		};

decl_conexiones: #(CONNECTIONS (conexion)*) ;

conexion: #(n:NEXUS (atributo)+) 
	{
		if(!aux.keySet().containsAll(ini.getValidAttrConnections()))
			error+="Required connection attribute not included in line "+n.getLine()+"\n";
		if(error.isEmpty()){	
			Connection conn = new Connection(ini.getPeople().get(aux.get("ID1")),ini.getPeople().get(aux.get("ID2")),aux.get("Type"));
			if(!ini.containsConnection(conn))
				ini.getConnections().add(conn);
			else
				error+="Connection already exists in line "+n.getLine()+"\n";
		}
		aux.clear();
	}
	;

atributo: #(i:ATR_IDENT a:ATR_VALOR)
	{ 
		if(!ini.getValidAttrConnections().contains(i.getText()))
			error+="Invalid connection attribute in line "+i.getLine()+": "+i.getText()+"\n";
		if(i.getText().equals("Type") && !ini.getValidConnectionTypes().contains(a.getText()))
			error+="Invalid connection type in line "+i.getLine()+": "+a.getText()+"\n";
		if((i.getText().equals("ID1") | i.getText().equals("ID2")) && !ini.getPeople().containsKey(a.getText()))
			error+="The person with ID "+a.getText()+" in line "+i.getLine()+" doesn't exists"+"\n";
		aux.put(i.getText(),a.getText());
	}
	;