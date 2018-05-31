package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.io.GraphIOException;
import edu.uci.ics.jung.io.GraphMLWriter;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;
import edu.uci.ics.jung.io.graphml.GraphMLReader2;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;
import edu.uci.ics.jung.io.graphml.NodeMetadata;

public class GraphPersistence {
	public static void saveGraphInfo(String fileName, Graph<VertexType, EdgeType> graph, StaticLayout<VertexType, EdgeType> sLayout) {
		try {
			GraphMLWriter<VertexType, EdgeType> graphWriter = new GraphMLWriter<VertexType, EdgeType>();
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			graphWriter.addEdgeData("label", null, "0", new Transformer<EdgeType, String>() {
				@Override
				public String transform(EdgeType v) {
					return v.toString();
				}
			});
			graphWriter.addVertexData("x", null, "0", new Transformer<VertexType, String>() {
				public String transform(VertexType v) {
					return Double.toString(sLayout.getX(v));
				}
			});
			graphWriter.addVertexData("y", null, "0", new Transformer<VertexType, String>() {
				public String transform(VertexType v) {
					return Double.toString(sLayout.getY(v));
				}
			});
			graphWriter.addVertexData("color", null, "0", new Transformer<VertexType, String>() {
				public String transform(VertexType v) {
					return v.getColor().toString();
				}
			});
			graphWriter.save(graph, out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Graph<VertexType, EdgeType> loadGraphInfo(String fileName) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
			Transformer<GraphMetadata, Graph<VertexType, EdgeType>> graphTransformer = new Transformer<GraphMetadata, Graph<VertexType, EdgeType>>() {
				public Graph<VertexType, EdgeType> transform(GraphMetadata metaData) {
					return new DirectedSparseMultigraph<VertexType, EdgeType>();
				}
			};
			Transformer<NodeMetadata, VertexType> vertexTransformer = new Transformer<NodeMetadata, VertexType>() {
				public VertexType transform(NodeMetadata metaData) {
					VertexType vertex = new VertexType(metaData.getId());
					vertex.setX(Double.parseDouble(metaData.getProperty("x")));
					vertex.setY(Double.parseDouble(metaData.getProperty("y")));
					vertex.setColor(ColorHandler.stringToColor(metaData.getProperty("color")));
					return vertex;
				}
			};
			Transformer<EdgeMetadata, EdgeType> edgeTransformer = new Transformer<EdgeMetadata, EdgeType>() {
				public EdgeType transform(EdgeMetadata metaData) {
					EdgeType edge = new EdgeType(metaData.getProperty("label"));
					return edge;
				}
			};
			Transformer<HyperEdgeMetadata, EdgeType> hyperEdgeTransformer = new Transformer<HyperEdgeMetadata, EdgeType>() {
				public EdgeType transform(HyperEdgeMetadata metaData) {
					EdgeType edge = new EdgeType(metaData.getProperty("label"));
					return edge;
				}
			};
			GraphMLReader2<Graph<VertexType, EdgeType>, VertexType, EdgeType> graphReader = new GraphMLReader2<Graph<VertexType, EdgeType>, VertexType, EdgeType>(
					fileReader, graphTransformer, vertexTransformer, edgeTransformer, hyperEdgeTransformer);
			Graph<VertexType, EdgeType> restoredGraph = new DirectedSparseMultigraph<>();
			restoredGraph = graphReader.readGraph();
			return restoredGraph;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (GraphIOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
