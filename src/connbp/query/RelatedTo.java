package connbp.query;

import java.util.Iterator;
import java.util.LinkedList;

import connbp.helper.Connection;
import connbp.helper.Person;

public class RelatedTo {
	private Person person1;
	private Person person2;
	
	public RelatedTo(){
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}
	
	public void isRelatedTo(){
		LinkedList<Connection> visited=new LinkedList<Connection>();
		boolean found;
		found=searchRelation(new Connection(person1, ""),visited);
		if(found){
			String tab="";
			System.out.println("Relation between "+person1.getName()+" ["+person1.getID()+"] and "+person2.getName()+" ["+person2.getID()+"]:");
			for(Connection c:visited){
				tab+="\t";
				System.out.println(tab+"| "+c.getPerson().getName()+" ["+c.getPerson().getID()+"] -> "+c.getRelation());
			}
		} else {
			System.out.println(person1.getName()+" ["+person1.getID()+"] is not related to "+person2.getName()+" ["+person2.getID()+"]");
		}
	}
	
	private boolean searchRelation(Connection conn, LinkedList<Connection> visited){
		visited.add(conn);
		Iterator<Connection> it = conn.getPerson().getConnections().iterator();
		while(it.hasNext()){
			Connection c = it.next();
			if(c.getPerson().equals(person2)){
				visited.add(c);
				return true;
			}
			else if(!visited.contains(c))
				return searchRelation(c,visited);
		}
		visited.remove(conn);
		return false;
	}
}
