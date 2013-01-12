package connbp.helper;
import java.util.HashMap;
import java.util.LinkedList;


public class Inicializador {

	private HashMap<String,Boolean> validAttrPeople;
	private LinkedList<String> validAttrConnections;
	private LinkedList<String> validConnectionTypes;
	private HashMap<String,Person> people;
	private LinkedList<LinkedList<Object>> queries;
	
	private static Inicializador instance = null;
	
	private Inicializador(){
		/* Valid attributes for a Person */
		validAttrPeople=new HashMap<String,Boolean>();
		validAttrPeople.put("Name",true);
		validAttrPeople.put("Surname",false);
		validAttrPeople.put("ID",true);
		validAttrPeople.put("City",false);
		validAttrPeople.put("Email",false);
		
		/* Valid attributes for a Connection */
		validAttrConnections=new LinkedList<String>();
		validAttrConnections.add("ID1");
		validAttrConnections.add("ID2");
		validAttrConnections.add("Type");
		
		/* Valid relation types for a given Connection */
		validConnectionTypes=new LinkedList<String>();
		validConnectionTypes.add("Relative");
		validConnectionTypes.add("Colleague");
		validConnectionTypes.add("Friend");
		validConnectionTypes.add("Acquaintance");
		
		people = new HashMap<String,Person>();
		queries = new LinkedList<LinkedList<Object>>();
	}
	
	public static synchronized Inicializador getInstance(){
		if(instance==null)
			instance=new Inicializador();
		return instance;
	}
	

	public HashMap<String,Boolean> getValidAttrPeople() {
		return validAttrPeople;
	}

	public LinkedList<String> getValidAttrConnections() {
		return validAttrConnections;
	}

	public LinkedList<String> getValidConnectionTypes() {
		return validConnectionTypes;
	}

	public HashMap<String, Person> getPeople() {
		return people;
	}


	public LinkedList<LinkedList<Object>> getQueries() {
		return queries;
	}
	

}
