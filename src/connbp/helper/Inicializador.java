package connbp.helper;
import java.util.HashMap;
import java.util.LinkedList;


public class Inicializador {

	private HashMap<String,Boolean> validAttrPeople;
	private LinkedList<String> validAttrConnections;
	private LinkedList<String> validConnectionTypes;
	private HashMap<String,Person> people;
	private LinkedList<Connection> connections;
	
	private static Inicializador instance = null;
	
	private Inicializador(){
		validAttrPeople=new HashMap<String,Boolean>();
		validAttrPeople.put("Name",true);
		validAttrPeople.put("Surname",false);
		validAttrPeople.put("ID",true);
		validAttrPeople.put("City",false);
		validAttrPeople.put("Email",false);
		
		validAttrConnections=new LinkedList<String>();
		validAttrConnections.add("ID1");
		validAttrConnections.add("ID2");
		validAttrConnections.add("Type");
		
		validConnectionTypes=new LinkedList<String>();
		validConnectionTypes.add("Relative");
		validConnectionTypes.add("Colleague");
		validConnectionTypes.add("Friend");
		validConnectionTypes.add("Acquaintance");
		
		people = new HashMap<String,Person>();
		connections = new LinkedList<Connection>();
	}
	
	public static synchronized Inicializador getInstance(){
		if(instance==null)
			instance=new Inicializador();
		return instance;
	}
	
	/* Only one connection will be allowed between two people.
	 * Therefore, different types of connections for the same people
	 * will return true. 
	 */
	public boolean containsConnection(Connection conn){
		for(Connection c:this.connections){
			if((c.getPerson1().equals(conn.getPerson1()) && c.getPerson2().equals(conn.getPerson2())) || (c.getPerson1().equals(conn.getPerson2()) && c.getPerson2().equals(conn.getPerson1())) ){
				return true;
			}
		}
		return false;
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
	
	public LinkedList<Connection> getConnections(){
		return this.connections;
	}

}
