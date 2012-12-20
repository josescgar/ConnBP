package connbp.query;

import java.util.HashMap;
import java.util.LinkedList;

import connbp.helper.Connection;
import connbp.helper.Inicializador;
import connbp.helper.Person;

public class LevelConnectionsFor {
	private Person person;
	private int level;
	
	public LevelConnectionsFor(){
	}
	
	public LevelConnectionsFor(int level,Person p){
		this.person=p;
		this.level=level;
	}
	
	public void getLevelConnectionsFor(){
		LinkedList<Person> visited = new LinkedList<Person>();
		String tab="";
		String header = "Level "+level+" connections for "+person.getName()+" ["+person.getID()+"]:";
		System.out.println(header);

		getConnections(person,visited,tab,0,level);
	}
	
	private void getConnections(Person p,LinkedList<Person> visited, String tab, int currentLevel, int level) {
		if(currentLevel<level){	
			tab+="\t";
			visited.add(p);
			for(Connection n:p.getConnections()){
				if(!visited.contains(n.getPerson())){
					System.out.println(tab+"| "+n.getPerson().getID()+" ["+n.getPerson().getName()+"] -> "+n.getRelation());
					getConnections(n.getPerson(),visited,tab,currentLevel+1,level);
				}
			}
			visited.remove(p);
			if(tab.length()>0)
				tab.substring(0, tab.length()-1);
		}
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
