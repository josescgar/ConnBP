package connbp.query;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import connbp.helper.Person;
import connbp.swing.InfoFrame;

public class ConnBPGraph extends mxGraph {
	private mxGraphComponent graphComponent;
	
	public ConnBPGraph(){
		super();
		this.graphComponent = new mxGraphComponent(this);
		graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				mxCell cell = (mxCell) graphComponent.getCellAt(e.getX(), e.getY());
				if(cell != null){
					InfoFrame info = new InfoFrame((Person)cell.getValue(), e.getX(),e.getY());
					info.showInfo();
				}
			}
		});
		this.setCellsEditable(false);
		this.setCellsDisconnectable(false);
		this.setCellsResizable(false);
		this.setConnectableEdges(false);
		this.setAllowDanglingEdges(false);
	}

	public mxGraphComponent getGraphComponent() {
		return graphComponent;
	}
}
