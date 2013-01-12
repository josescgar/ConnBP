package connbp.query;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import connbp.helper.Connection;
import connbp.helper.Person;

public class RelatedTo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person1;
	private Person person2;
	private ConnBPGraph graph;
	private Object mainParent;
	
	public RelatedTo(){
		super("RelatedTo");
		this.graph = new ConnBPGraph();
		this.mainParent = graph.getDefaultParent();
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}
	
	public void isRelatedTo(){
		this.setTitle("Is "+person1.getName()+" ["+person1.getID()+"] related to "+person2.getName()+" ["+person2.getID()+"]?");
		LinkedList<Connection> visited=new LinkedList<Connection>();
		boolean found;
		
		try {
			
			found=searchRelation(new Connection(person1, ""),visited);
		}
		finally
		{
			graph.getModel().endUpdate();
		}
		
		if(found){
			String tab="";
			System.out.println("Relation between "+person1.getName()+" ["+person1.getID()+"] and "+person2.getName()+" ["+person2.getID()+"]:");
			Object parent = null;
			for(Connection c:visited){
				tab+="\t";
				System.out.println(tab+"| "+c.getPerson().getName()+" ["+c.getPerson().getID()+"] -> "+c.getRelation());
				Object currentVertex = graph.insertVertex(mainParent, null, c.getPerson(), 1, 1, 100, 30);
				graph.insertEdge(mainParent, null, c.getRelation(), parent, currentVertex);
				parent = currentVertex;
			}
			System.out.println("Drawing graph...");
			mxGraphComponent graphComponent = graph.getGraphComponent();
			graphComponent.setConnectable(false);
			getContentPane().add(graphComponent);
			new mxHierarchicalLayout(graph).execute(mainParent);
			
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.pack();
			this.setVisible(true);
		} else {
			System.out.println(person1.getName()+" ["+person1.getID()+"] is not related to "+person2.getName()+" ["+person2.getID()+"]");
		}
	}
	
	private boolean searchRelation(Connection conn, LinkedList<Connection> visited){
		visited.add(conn);
		Iterator<Connection> it = conn.getPerson().getConnections().iterator();
		boolean found = false;
		while(it.hasNext() && !found){
			Connection c = it.next();
			if(c.getPerson().equals(person2)){
				visited.add(c);
				found = true;
			}
			else if(!visited.contains(c))
				found = searchRelation(c,visited);
		}
		if(!found)
			visited.remove(conn);
		return found;
	}
}
