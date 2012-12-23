package connbp.query;

import java.util.LinkedList;
import javax.swing.JFrame;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import connbp.helper.Connection;
import connbp.helper.Person;

public class LevelConnectionsFor extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person;
	private int level;
	private mxGraph graph;
	private Object mainParent;
	
	public LevelConnectionsFor(){
		super("LevelConnectionsFor");
		this.graph = new mxGraph();
		graph.setCellsEditable(false);
		graph.setCellsDisconnectable(false);
		graph.setCellsResizable(false);
		graph.setConnectableEdges(false);
		graph.setAllowDanglingEdges(false);
		this.mainParent = graph.getDefaultParent();
	}
	
	public void getLevelConnectionsFor(){
		this.setTitle("Level "+this.level+" connections for "+this.person.getName()+" ["+this.person.getID()+"]");
		
		LinkedList<Person> visited = new LinkedList<Person>();
		String tab="";
		
		String header = "Level "+level+" connections for "+person.getName()+" ["+person.getID()+"]:";
		System.out.println(header);
		try
		{
			Object parent = graph.insertVertex(mainParent, null, person.getName()+" ["+person.getID()+"]", 1, 1, 100, 30);
			getConnections(person,visited,tab,0,level,parent);
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		System.out.println("Drawing graph...");
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setConnectable(false);
		getContentPane().add(graphComponent);
		new mxHierarchicalLayout(graph).execute(mainParent);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	private void getConnections(Person p,LinkedList<Person> visited, String tab, int currentLevel, int level, Object parent) {
		if(currentLevel<level){	
			tab+="\t";
			visited.add(p);
			for(Connection n:p.getConnections()){
				if(!visited.contains(n.getPerson())){
					System.out.println(tab+"| "+n.getPerson().getID()+" ["+n.getPerson().getName()+"] -> "+n.getRelation());
					String label=n.getPerson().getName()+" ["+n.getPerson().getID()+"]";
					Object currentVertex = graph.insertVertex(mainParent, null, label, 1, 1, 100, 30);
					graph.insertEdge(mainParent, null, n.getRelation(), parent, currentVertex);
					getConnections(n.getPerson(),visited,tab,currentLevel+1,level,currentVertex);
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
