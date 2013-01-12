package connbp.query;

import java.util.HashMap;
import java.util.Map.*;
import javax.swing.JFrame;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import connbp.helper.Connection;
import connbp.helper.Inicializador;
import connbp.helper.Person;

public class Graph extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConnBPGraph graph;
	private HashMap<String,Object> mxVertices;
	private Object mainParent;
	
	public Graph(){
		super("Connection Graph");
		this.graph = new ConnBPGraph();
		this.mxVertices=new HashMap<String,Object>();
		mainParent = graph.getDefaultParent();
	}
	
	public void drawGraph(){
		System.out.println("Drawing connection graph...");
		graph.getModel().beginUpdate();
		try
		{
			paintAllVertices(mainParent);
			paintAllEdges();
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = graph.getGraphComponent();
		graphComponent.setConnectable(false);
		getContentPane().add(graphComponent);
		new mxCircleLayout(graph).execute(graph.getDefaultParent());
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	private void paintAllEdges() {
		for(Entry<String,Person> p:Inicializador.getInstance().getPeople().entrySet()){
			for(Connection n:p.getValue().getConnections()){
				graph.insertEdge(mainParent, null, n.getRelation(), mxVertices.get(p.getKey()), mxVertices.get(n.getPerson().getID()));
			}
		}
	}

	private void paintAllVertices(Object mainParent){
		for(Entry<String,Person> p:Inicializador.getInstance().getPeople().entrySet()){
			Object vertex = graph.insertVertex(mainParent, null, p.getValue(), 1, 1, 100, 30);
			mxVertices.put(p.getKey(),vertex);
		}
	}
}
