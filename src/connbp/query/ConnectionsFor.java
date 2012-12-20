package connbp.query;

import connbp.helper.*;

public class ConnectionsFor {
	private String type;
	private Person person;
	
	public ConnectionsFor(){
	}
	
	public ConnectionsFor(String t, Person p){
		this.type=t;
		this.person=p;
	}
	
	public void getConnectionsFor(){
		System.out.println(type+" connections for "+person.getName()+" ["+person.getID()+"]:");
		for(Connection c:person.getConnections()){
			if(c.getRelation().equals(type)){
				System.out.println(c.getPerson());
			}
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
