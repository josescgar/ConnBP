header {
	package connbp.grammar;
	import connbp.helper.Person;
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
}

entrada [HashMap<String,Person> people, HashMap<String,Boolean> attr] throws ConnBPSemanticException: 
		#(PROGRAMA decl_personas[people,attr]);
		
decl_personas [HashMap<String,Person> people, HashMap<String,Boolean> attr] throws ConnBPSemanticException: 
		#(PEOPLE (persona[people,attr])+);
			
persona [HashMap<String,Person> people, HashMap<String,Boolean> attr] throws ConnBPSemanticException: 
		#(p:PERSON (atributo[people,attr])+) 
		{
				for(Entry<String, Boolean> e : attr.entrySet()){
					if(e.getValue() && !aux.containsKey(e.getKey()))
						throw new ConnBPSemanticException("Required attribute not included in line "+p.getLine()+": "+e.getKey());
				}
				if(people.containsKey(aux.get("ID")))
					throw new ConnBPSemanticException("Duplicated Person ID: "+aux.get("ID"));
				people.put(aux.get("ID"),new Person(aux));
				aux.clear();
		}
		;
		
atributo [HashMap<String,Person> people, HashMap<String,Boolean> attr] throws ConnBPSemanticException: 
		#(i:ATR_IDENT v:ATR_VALOR)
		{ 
			if(!attr.containsKey(i.getText())) 
				throw new ConnBPSemanticException("Invalid attribute in line "+i.getLine()+": "+i.getText());
			else {
				if(aux.containsKey(i.getText()))
					throw new ConnBPSemanticException("Duplicated attribute in line "+i.getLine()+": "+i.getText()+"="+v.getText());
				else
					aux.put(i.getText(),v.getText());
			}	
		}
		;
		
