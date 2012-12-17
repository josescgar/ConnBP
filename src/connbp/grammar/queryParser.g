header {
	package connbp.grammar;
	import connbp.helper.Inicializador;
	import connbp.exceptions.*;
}

class QueryParser extends TreeParser;

options {
	importVocab=Anasint;
}

{
	Inicializador ini=Inicializador.getInstance();
}

entrada throws ConnBPSemanticException: #(PROGRAMA . . decl_consultas) ;

decl_consultas throws ConnBPSemanticException: #(QUERIES (consulta)*) ;

consulta throws ConnBPSemanticException: #(r:RELATEDTO p1:ATR_VALOR p2:ATR_VALOR)
			{
				if(!ini.getPeople().containsKey(p1.getText()) || !ini.getPeople().containsKey(p2.getText()))
					throw new ConnBPSemanticException("Invalid query argument in line "+r.getLine()+": Invalid Person ID");
			}
		| #(c:CONNECTIONSFOR t:ATR_VALOR p:ATR_VALOR)
			{
				if(!ini.getValidConnectionTypes().contains(t.getText()))
					throw new ConnBPSemanticException("Invalid query argument in line "+c.getLine()+": Invalid connection type \""+t.getText()+"\"");
				if(!ini.getPeople().containsKey(p.getText()))
					throw new ConnBPSemanticException("Invalid query argument in line "+c.getLine()+": Invalid Person ID");
			}
		| #(l:LEVELCONNECTIONSFOR n:ATR_VALOR pc:ATR_VALOR)
			{
				int level;
				try{
					level = Integer.parseInt(n.getText());
				} catch (NumberFormatException e){
					throw new ConnBPSemanticException("Invalid query argument in line "+l.getLine()+": "+n.getText()+" isn't an integer number");
				}
				if(level<=0)
					throw new ConnBPSemanticException("Invalid query argument in line "+l.getLine()+": the level must be equal or greater than 1");
				if(!ini.getPeople().containsKey(pc.getText()))
					throw new ConnBPSemanticException("Invalid query argument in line "+l.getLine()+": Invalid Person ID");
			}
		| GRAPH
		;