header {
	package connbp.grammar;
	import connbp.helper.*;
	import java.util.HashMap;
	import connbp.exceptions.ConnBPSemanticException;
	import java.util.LinkedList;
	import java.util.Map.Entry;
}

class PeopleFiller extends TreeParser;
options{
	importVocab=Anasint;
}

{
	HashMap<String,String> aux = new HashMap<String,String>();
	Inicializador ini = Inicializador.getInstance();
}

entrada throws ConnBPSemanticException: 
		#(PROGRAMA decl_personas);
		
decl_personas throws ConnBPSemanticException: 
		#(PEOPLE (persona)+);
			
persona throws ConnBPSemanticException: 
		#(p:PERSON (atributo)+) 
		{
				for(Entry<String, Boolean> e : ini.getValidAttrPeople().entrySet()){
					if(e.getValue() && !aux.containsKey(e.getKey()))
						throw new ConnBPSemanticException("Required attribute not included in line "+p.getLine()+": "+e.getKey());
				}
				if(ini.getPeople().containsKey(aux.get("ID")))
					throw new ConnBPSemanticException("Duplicated Person ID: "+aux.get("ID"));
				ini.getPeople().put(aux.get("ID"),new Person(aux));
				aux.clear();
		}
		;
		
atributo throws ConnBPSemanticException: 
		#(i:ATR_IDENT v:ATR_VALOR)
		{ 
			if(!ini.getValidAttrPeople().containsKey(i.getText())) 
				throw new ConnBPSemanticException("Invalid attribute in line "+i.getLine()+": "+i.getText());
			else {
				if(aux.containsKey(i.getText()))
					throw new ConnBPSemanticException("Duplicated attribute in line "+i.getLine()+": "+i.getText()+"="+v.getText());
				else
					aux.put(i.getText(),v.getText());
			}	
		}
		;