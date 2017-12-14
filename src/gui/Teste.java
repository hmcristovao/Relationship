package gui;

import javax.swing.JFrame;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization3d.VisualizationViewer;

public class Teste {
	public static void main(String[] args) {

		int layoutNumber = 0;
		JFrame graphFrame = new JFrame("Graph Frame Test");
		graphFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graph<String, EdgeType> graphTest = new DirectedSparseMultigraph<>();
		graphTest = DisplayGraph.parseTxtIntoGraph();
		edu.uci.ics.jung.visualization.VisualizationViewer<String, EdgeType> currentVV = DisplayGraph.GenerateVisualGraph(graphTest, layoutNumber);
		GraphZoomScrollPane scrollPanel = new GraphZoomScrollPane(currentVV);
		graphFrame.getContentPane().add(scrollPanel);
		graphFrame.pack();
		graphFrame.setVisible(true);

		//currentVV.setGraphMouse(DisplayGraph.ChangeMouseMode(1));
		//currentVV.ChangeLa
	}
}
