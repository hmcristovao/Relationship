package gui;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class DisplayGraph {
	public static Graph<String, EdgeType> parseTxtIntoGraph(){
		//final String fileName = WholeSystem.configTable.getString("baseDirectory")+"\\"+WholeSystem.configTable.getString("testName")+"\\"+
		//          WholeSystem.configTable.getString("nameTxtConceptMapFile");
		String fileName = "E:\\Documents\\UFES\\TCC\\Relationship\\teste2\\conceptmap_teste2.txt";      
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		Graph<String, EdgeType> graphFromTxtFile = new DirectedSparseMultigraph<String, EdgeType>();
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String sCurrentLine;
			String composedTermOrigin ="";
		    String composedTermRelation = "";
		    String composedTermTarget = "";
		    boolean origin = false;
		    boolean relation = false;
		    boolean target = false;
		    while ((sCurrentLine = bufferedReader.readLine()) != null) {
				System.out.println(sCurrentLine);
				Scanner scanTerm = new Scanner(sCurrentLine);
				//assumes the line has a certain structure: Term \t Relation \t Target
				scanTerm.useDelimiter("\t");
			    if (scanTerm.hasNext()){
			      composedTermOrigin = scanTerm.next();
			      origin = true;
			    }
			    if (scanTerm.hasNext()) {
			      composedTermRelation = scanTerm.next();
			      relation = true;
			    }
			    if (scanTerm.hasNext()){
			      composedTermTarget = scanTerm.next();
			      target = true;
			    }
			    if (relation == true){
			      EdgeType edge = new EdgeType(composedTermRelation);
			      graphFromTxtFile.addEdge(edge,composedTermOrigin, composedTermTarget); 
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
				if (fileReader != null){
					fileReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
	return graphFromTxtFile;
	}
	
	public static GraphZoomScrollPane GenerateVisualGraph(Graph<String, EdgeType> receivedGraph){
		//Define layout style -- To do: add a button to allow the user to choose it 
		 Layout<String, EdgeType> layout = new CircleLayout<String, EdgeType>(receivedGraph);
		 layout.setSize(new Dimension(1000,1000)); 
		 VisualizationViewer<String,EdgeType> visualizationServer = new VisualizationViewer<String, EdgeType>(layout);
		 visualizationServer.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		 visualizationServer.getRenderContext().setEdgeLabelTransformer(new EdgeLabelTransformer());
		 visualizationServer.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		 DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
		 graphMouse.setMode(DefaultModalGraphMouse.Mode.PICKING);
		 visualizationServer.setGraphMouse(graphMouse);
		 GraphZoomScrollPane scrollPanel = new GraphZoomScrollPane(visualizationServer);
		 return scrollPanel;
	}
	
}

