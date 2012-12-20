package connbp.helper;

public class Connection{
	private Person person;
	private String relation;
	
	public Connection(Person p, String relation){
		this.person=p;
		this.relation=relation;
	}
	public Person getPerson() {
		return person;
	}

	public String getRelation() {
		return relation;
	}

	public String toString(){
		return "[ "+person.getID()+" | "+relation+" ]";
	}
	@Override
	public boolean equals(Object o) {
		if(person.equals(((Connection)o).getPerson()))
			return true;
		return false;
	}
	
}
