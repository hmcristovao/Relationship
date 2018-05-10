package gui;


import java.awt.Dimension;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;

public class VisualizationInstance {
	private Graph<VertexType, EdgeType> graphTest;
	private int layoutNumber = 0;
	private VisualizationViewer<VertexType, EdgeType> currentVV;
	private GraphZoomScrollPane scrollPanel;
	private int mouseMode = 0;
	private DefaultModalGraphMouse<VertexType, EdgeType> graphMouse;
	
	VisualizationInstance(){
		graphTest = new DirectedSparseMultigraph<>();
		DisplayGraph.parseTxtIntoGraph(graphTest);
		Dimension dimension = new Dimension();
		dimension.setSize(1138, 718);
		currentVV = new VisualizationViewer<VertexType, EdgeType>(DisplayGraph.changeLayout(layoutNumber, graphTest), dimension);
		DisplayGraph.generateVisualGraph(graphTest, layoutNumber, currentVV);
		scrollPanel = new GraphZoomScrollPane(currentVV);
		graphMouse = new DefaultModalGraphMouse<VertexType, EdgeType>();
		changeMouseMode();
	}
	
	private void changeMouseMode() {
		if (mouseMode == 1) {
			graphMouse.setMode(DefaultModalGraphMouse.Mode.PICKING);
			currentVV.setGraphMouse(graphMouse);
		} else {
			graphMouse.setMode(DefaultModalGraphMouse.Mode.TRANSFORMING);
			currentVV.setGraphMouse(graphMouse);
		}
	}
	
	public int getMouseMode() {
		return mouseMode;
	}
	public void setMouseMode(int mouseMode) {
		this.mouseMode = mouseMode;
		changeMouseMode();
	}
	public Graph<VertexType, EdgeType> getGraphTest() {
		return graphTest;
	}
	public void setGraphTest(Graph<VertexType, EdgeType> graphTest) {
		this.graphTest = graphTest;
	}
	public VisualizationViewer<VertexType, EdgeType> getCurrentVV() {
		return currentVV;
	}
	public void setCurrentVV(VisualizationViewer<VertexType, EdgeType> currentVV) {
		this.currentVV = currentVV;
	}
	public GraphZoomScrollPane getScrollPanel() {
		return scrollPanel;
	}
	public void setScrollPanel(GraphZoomScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}
}
