package connbp.helper;

public class Connection {
	private Person person1;
	private Person person2;
	private String relation;
	
	public Connection(Person p1, Person p2, String relation){
		this.person1=p1;
		this.person2=p2;
		this.relation=relation;
	}
	public Person getPerson1() {
		return person1;
	}

	public Person getPerson2() {
		return person2;
	}

	public String getRelation() {
		return relation;
	}

	public String toString(){
		return "[ "+person1.getID()+" | "+person2.getID()+" | "+relation+" ]";
	}
	
}
