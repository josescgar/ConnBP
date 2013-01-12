package connbp.helper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private String surname;
	private String email;
	private String city;
	private LinkedList<Connection> connections;
	
	public Person(){}
	
	public Person(HashMap<String,String> atributos){
		if(atributos.containsKey("ID"))
			this.ID=atributos.get("ID");
		if(atributos.containsKey("Name"))
			this.name=atributos.get("Name");
		if(atributos.containsKey("Surname"))
			this.surname=atributos.get("Surname");
		if(atributos.containsKey("Email"))
			this.email=atributos.get("Email");
		if(atributos.containsKey("City"))
			this.city=atributos.get("City");
		this.connections=new LinkedList<Connection>();
	}
	
	public String toString(){
		String s=this.name+" ["+this.ID+"]";
		return s;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LinkedList<Connection> getConnections() {
		return connections;
	}

	public void setConnections(LinkedList<Connection> connections) {
		this.connections = connections;
	}
}
