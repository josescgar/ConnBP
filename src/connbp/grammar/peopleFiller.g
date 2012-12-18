header {
	package connbp.grammar;
	import connbp.helper.*;
	import java.util.HashMap;
	import connbp.exceptions.ConnBPPeopleException;
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
	String error="";
}

entrada throws ConnBPPeopleException: 
		#(PROGRAMA decl_personas)
		{	
			if(!error.isEmpty()){
				ini.getPeople().clear();
				throw new ConnBPPeopleException(error);
			}
		};
		
decl_personas: 
		#(PEOPLE (persona)+);
			
persona: 
		#(p:PERSON (atributo)+) 
		{
				for(Entry<String, Boolean> e : ini.getValidAttrPeople().entrySet()){
					if(e.getValue() && !aux.containsKey(e.getKey()))
						error+="Required attribute not included in line "+p.getLine()+": "+e.getKey()+"\n";
				}
				if(ini.getPeople().containsKey(aux.get("ID")))
					error+="Duplicated Person ID in line "+p.getLine()+": "+aux.get("ID")+"\n";
				
				ini.getPeople().put(aux.get("ID"),new Person(aux));
				aux.clear();
		}
		;
		
atributo: 
		#(i:ATR_IDENT v:ATR_VALOR)
		{ 
			if(!ini.getValidAttrPeople().containsKey(i.getText())) 
				error+="Invalid attribute in line "+i.getLine()+": "+i.getText()+"\n";
			else {
				if(aux.containsKey(i.getText()))
					error+="Duplicated attribute in line "+i.getLine()+": "+i.getText()+"="+v.getText()+"\n";
				else
					aux.put(i.getText(),v.getText());
			}	
		}
		;