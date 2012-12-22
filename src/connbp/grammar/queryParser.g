header {
	package connbp.grammar;
	import connbp.helper.Inicializador;
	import connbp.exceptions.*;
	import java.util.LinkedList;
}

class QueryParser extends TreeParser;

options {
	importVocab=Anasint;
}

{
	Inicializador ini=Inicializador.getInstance();
	String error="";
}

entrada throws ConnBPQuerySemanticException: #(PROGRAMA . . decl_consultas) 
	{
		if(!error.isEmpty()){
			throw new ConnBPQuerySemanticException(error);
		}	
	};

decl_consultas: #(QUERIES (consulta)*) ;

consulta: #(r:RELATEDTO p1:ATR_VALOR p2:ATR_VALOR)
			{
				if(!ini.getPeople().containsKey(p1.getText()) || !ini.getPeople().containsKey(p2.getText()))
					error+="Invalid query argument in line "+r.getLine()+": Invalid Person ID\n";
				else {
					LinkedList<Object> aux=new LinkedList<Object>();
					aux.add(r.getText());
					aux.add(ini.getPeople().get(p1.getText()));
					aux.add(ini.getPeople().get(p2.getText()));
					ini.getQueries().add(aux);
				}
			}
		| #(c:CONNECTIONSFOR t:ATR_VALOR p:ATR_VALOR)
			{
				if(!ini.getValidConnectionTypes().contains(t.getText()))
					error+="Invalid query argument in line "+c.getLine()+": Invalid connection type \""+t.getText()+"\"\n";
				if(!ini.getPeople().containsKey(p.getText()))
					error+="Invalid query argument in line "+c.getLine()+": Invalid Person ID \""+p.getText()+"\"\n";
				else {
					LinkedList<Object> aux=new LinkedList<Object>();
					aux.add(c.getText());
					aux.add(t.getText());
					aux.add(ini.getPeople().get(p.getText()));
					ini.getQueries().add(aux);
				}
			}
		| #(l:LEVELCONNECTIONSFOR n:ATR_VALOR pc:ATR_VALOR)
			{
				int level;
				try{
					level = Integer.parseInt(n.getText());
					if(level<=0)
						error+="Invalid query argument in line "+l.getLine()+": the level must be equal or greater than 1"+"\n";
					if(!ini.getPeople().containsKey(pc.getText()))
						error+="Invalid query argument in line "+l.getLine()+": Invalid Person ID \""+pc.getText()+"\"\n";
					else {
						LinkedList<Object> aux=new LinkedList<Object>();
						aux.add(l.getText());
						aux.add(level);
						aux.add(ini.getPeople().get(pc.getText()));
						ini.getQueries().add(aux);
					}
						
				} catch (NumberFormatException e){
					error+="Invalid query argument in line "+l.getLine()+": "+n.getText()+" isn't an integer number"+"\n";
				}
				
			}
		| g:GRAPH
		{
			LinkedList<Object> aux=new LinkedList<Object>();
			aux.add(g.getText());
			ini.getQueries().add(aux);
		}
		;