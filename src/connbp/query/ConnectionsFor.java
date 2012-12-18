package connbp.query;

import java.util.LinkedList;

import connbp.helper.*;

public class ConnectionsFor {
	private String type;
	private Person person;
	private Inicializador ini;
	private LinkedList<Connection> result;
	
	public ConnectionsFor(){
		ini = Inicializador.getInstance();
		result = new LinkedList<Connection>();
	}
	
	public ConnectionsFor(String t, Person p){
		this.type=t;
		this.person=p;
		ini = Inicializador.getInstance();
		result = new LinkedList<Connection>();
	}
	
	public void getConnectionsFor(){
		result.clear();
		for(Connection c:ini.getConnections()){
			if((c.getPerson1().equals(person) || c.getPerson2().equals(person)) && c.getRelation().equals(type))
				result.add(c);
		}
	}
	
	public String toString(){
		String s=type+" connections for "+person.getName()+" ["+person.getID()+"]:\n";
		for(Connection c:this.result){
			s+=c.toString()+"\n";
		}
		return s;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
