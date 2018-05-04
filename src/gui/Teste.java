package gui;

import javax.swing.JFrame;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.layout.PersistentLayout;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class Teste {
	public static void main(String[] args) {

		int layoutNumber = 0;
		JFrame graphFrame = new JFrame("Graph Frame Test");
		graphFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graph<VertexType, EdgeType> graphTest = new DirectedSparseMultigraph<>();
		DisplayGraph.parseTxtIntoGraph(graphTest);
		VisualizationViewer<VertexType, EdgeType> currentVV = new VisualizationViewer<VertexType, EdgeType>(DisplayGraph.changeLayout(layoutNumber, graphTest));
		DisplayGraph.generateVisualGraph(graphTest, layoutNumber, currentVV);
		GraphZoomScrollPane scrollPanel = new GraphZoomScrollPane(currentVV);
		graphFrame.getContentPane().add(scrollPanel);
		graphFrame.pack();
		graphFrame.setVisible(true);
		//******************************************************************************************
		GraphPersistence.saveGraphInfo("E:\\Relationship\\teste\\graph_info.xml", graphTest);
		GraphPersistence.saveGraphPositionInTXT(currentVV, "E:\\Relationship\\teste\\graph_persistence.txt");
		Graph<VertexType, EdgeType> loadedGraphTest = new DirectedSparseMultigraph<>();
		loadedGraphTest = GraphPersistence.loadGraphInfo("E:\\Relationship\\teste\\graph_info.xml");
		edu.uci.ics.jung.visualization.VisualizationViewer<VertexType, EdgeType> loadedVV = 
				GraphPersistence.loadGraphPositionFromTXT("E:\\Relationship\\teste\\graph_persistence.txt", loadedGraphTest);
		GraphZoomScrollPane loadedScrollPanel = new GraphZoomScrollPane(loadedVV);
		loadedVV.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		loadedVV.getRenderContext().setEdgeLabelTransformer(new EdgeLabelTransformer());
		loadedVV.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		loadedVV.setGraphMouse(DisplayGraph.changeMouseMode(1));
		JFrame loadedGraphFrame = new JFrame("Restore Test");
		loadedGraphFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadedGraphFrame.getContentPane().add(loadedScrollPanel);
		loadedGraphFrame.pack();
		loadedGraphFrame.setVisible(true);
		
		GraphPersistence.saveGraphInfo("E:\\Relationship\\teste\\aaaaaaaaaaaaaaaaa.xml", loadedGraphTest);
	}
}
