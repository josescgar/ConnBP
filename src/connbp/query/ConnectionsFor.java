package connbp.query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
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
				String s="[";
				Set<String> atributos = Inicializador.getInstance().getValidAttrPeople().keySet();
				for(String attr:atributos){
					try {
						Method method = c.getPerson().getClass().getDeclaredMethod("get"+attr);
						if(method.invoke(c.getPerson())!=null)
							s+=" "+attr+": "+method.invoke(c.getPerson());

					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
						return;
					}
				}
				s+=" ]";
				System.out.println(s);
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
