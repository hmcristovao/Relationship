package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class DisplayGraph {
	public static Graph<String, EdgeType> parseTxtIntoGraph() {
		// final String fileName =
		// WholeSystem.configTable.getString("baseDirectory")+"\\"+WholeSystem.configTable.getString("testName")+"\\"+
		// WholeSystem.configTable.getString("nameTxtConceptMapFile");
		String fileName = "H:\\New folder\\git\\Relationship\\teste2\\conceptmap_teste2.txt";
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		Graph<String, EdgeType> graphFromTxtFile = new DirectedSparseMultigraph<String, EdgeType>();
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
				// assumes the line has a certain structure: Term \t Relation \t Target
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
					graphFromTxtFile.addEdge(edge, composedTermOrigin, composedTermTarget);
				} else if (origin == true) {
					graphFromTxtFile.addVertex(composedTermOrigin);
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
		return graphFromTxtFile;
	}

	public static VisualizationViewer<String, EdgeType> GenerateVisualGraph(Graph<String, EdgeType> receivedGraph,
			int selectedLayout) {

		VisualizationViewer<String, EdgeType> visualizationServer = new VisualizationViewer<String, EdgeType>(
				DisplayGraph.ChangeLayout(selectedLayout, receivedGraph));
		visualizationServer.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		visualizationServer.getRenderContext().setEdgeLabelTransformer(new EdgeLabelTransformer());
		visualizationServer.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		visualizationServer.setGraphMouse(DisplayGraph.ChangeMouseMode(0));
		return visualizationServer;
	}

	public static AbstractLayout<String, EdgeType> ChangeLayout(int selectedLayout, Graph<String, EdgeType> graph) {

		AbstractLayout<String, EdgeType> newLayout;
		newLayout = new CircleLayout<String, EdgeType>(graph);
		switch (selectedLayout) {
		case 1:
			newLayout = new KKLayout<String, EdgeType>(graph);
		case 2:
			newLayout = new FRLayout<String, EdgeType>(graph);
		case 3:
			newLayout = new SpringLayout<String, EdgeType>(graph);
		case 4:
			newLayout = new ISOMLayout<String, EdgeType>(graph);
		}
		return newLayout;
	}

	public static DefaultModalGraphMouse<String, EdgeType> ChangeMouseMode(int selectedMouse) {
		DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
		if (selectedMouse == 1) {
			graphMouse.setMode(DefaultModalGraphMouse.Mode.PICKING);
		}
		else {
			graphMouse.setMode(DefaultModalGraphMouse.Mode.TRANSFORMING);
		}
		return graphMouse;
	}
}
