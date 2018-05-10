package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.io.GraphIOException;
import edu.uci.ics.jung.io.GraphMLWriter;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;
import edu.uci.ics.jung.io.graphml.GraphMLReader2;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;
import edu.uci.ics.jung.io.graphml.NodeMetadata;
import edu.uci.ics.jung.samples.PersistentLayoutDemo;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import main.WholeSystem;
import edu.uci.ics.jung.visualization.layout.PersistentLayout;
import edu.uci.ics.jung.visualization.layout.PersistentLayoutImpl;

public class DisplayGraph {

	public static void parseTxtIntoGraph(Graph<VertexType, EdgeType> graphFromTxtFile) {
		// final String fileName =
		// WholeSystem.configTable.getString("baseDirectory")+"\\"+WholeSystem.configTable.getString("testName")+"\\"+
		// WholeSystem.configTable.getString("nameTxtConceptMapFile");
		String fileName = "E:\\Relationship\\teste\\conceptmap_teste.txt"; // For
																			// testing
																			// only
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String sCurrentLine;
			String composedTermOrigin = "";
			String composedTermRelation = "";
			String composedTermTarget = "";
			boolean origin = false;
			boolean relation = false;
			boolean target = false;
			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				System.out.println(sCurrentLine);
				Scanner scanTerm = new Scanner(sCurrentLine);
				// assumes the line has a certain structure: Term \t Relation \t
				// Target
				scanTerm.useDelimiter("\t");
				if (scanTerm.hasNext()) {
					composedTermOrigin = scanTerm.next();
					origin = true;
				}
				if (scanTerm.hasNext()) {
					composedTermRelation = scanTerm.next();
					relation = true;
				}
				if (scanTerm.hasNext()) {
					composedTermTarget = scanTerm.next();
					target = true;
				}
				if (relation == true) {
					EdgeType edge = new EdgeType(composedTermRelation);
					graphFromTxtFile.addEdge(edge, new VertexType(composedTermOrigin), new VertexType(composedTermTarget));
				} else if (origin == true) {
					graphFromTxtFile.addVertex(new VertexType(composedTermOrigin));
				}
				origin = false;
				relation = false;
				target = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	public static void generateVisualGraph(Graph<VertexType, EdgeType> receivedGraph,
			int selectedLayout, VisualizationViewer <VertexType, EdgeType> visualizationServer) {

		visualizationServer.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		visualizationServer.getRenderContext().setEdgeLabelTransformer(new EdgeLabelTransformer());
		visualizationServer.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		//visualizationServer.setGraphMouse(DisplayGraph.changeMouseMode(0));
	}

	public static PersistentLayoutImpl changeLayout(int selectedLayout, Graph<VertexType, EdgeType> graph) {

		AbstractLayout<VertexType, EdgeType> newLayout;
		newLayout = new CircleLayout<VertexType, EdgeType>(graph);
		switch (selectedLayout) {
		case 1:
			newLayout = new KKLayout<VertexType, EdgeType>(graph);
		case 2:
			newLayout = new FRLayout<VertexType, EdgeType>(graph);
		case 3:
			newLayout = new SpringLayout<VertexType, EdgeType>(graph);
		case 4:
			newLayout = new ISOMLayout<VertexType, EdgeType>(graph);
		}
		PersistentLayoutImpl persistentLayout = new PersistentLayoutImpl(newLayout);
		return persistentLayout;
	}
}