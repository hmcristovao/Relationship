package gui;

import javax.swing.JFrame;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

public class Teste {
	public static void main(String[] args) {
		
	
	JFrame graphFrame = new JFrame("Graph Frame Test");
	graphFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Graph<String, EdgeType> graphTest = new DirectedSparseMultigraph<>();
	graphTest = DisplayGraph.parseTxtIntoGraph();
	graphFrame.getContentPane().add(DisplayGraph.GenerateVisualGraph(graphTest));
	graphFrame.pack();
	graphFrame.setVisible(true);
	}
}
