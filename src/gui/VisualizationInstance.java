package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.lang.reflect.Constructor;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.layout.LayoutTransition;
import edu.uci.ics.jung.visualization.renderers.GradientVertexRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.visualization.util.Animator;
import main.WholeSystem;

public class VisualizationInstance {
	private Graph<VertexType, EdgeType> graph;
	private int layoutNumber = 0;
	private VisualizationViewer<VertexType, EdgeType> currentVV;
	private GraphZoomScrollPane scrollPanel;
	private int mouseMode = 0;
	private DefaultModalGraphMouse<VertexType, EdgeType> graphMouse;
	private AbstractLayout<VertexType, EdgeType> layout;
	private StaticLayout<VertexType, EdgeType> sLayout;

	private Dimension dimension;


	VisualizationInstance() {
		graph = new DirectedSparseMultigraph<>();
		GenerateGraph.parseTxtIntoGraph(graph, "E:\\Relationship\\teste\\conceptmap_teste.txt"); // For Testing only
		/*
		 * GenerateGraph.parseTxtIntoGraph(graph,
		 * WholeSystem.configTable.getString("baseDirectory") + "\\" +
		 * WholeSystem.configTable.getString("testName") + "\\" +
		 * WholeSystem.configTable.getString("nameTxtConceptMapFile"));
		 */
		dimension = new Dimension(1138, 718);
		layout = new StaticLayout<VertexType, EdgeType>(graph);
		currentVV = new VisualizationViewer<VertexType, EdgeType>(layout, dimension);
		applyVVRenderer();
		scrollPanel = new GraphZoomScrollPane(currentVV);
		graphMouse = new DefaultModalGraphMouse<VertexType, EdgeType>();
		changeMouseMode();
	}

	private void applyVVRenderer() {
		currentVV.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		currentVV.getRenderContext().setEdgeLabelTransformer(new EdgeLabelTransformer());
		currentVV.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		currentVV.getRenderer().setVertexRenderer(new GradientVertexRenderer<VertexType, EdgeType>(Color.white,
				Color.red, Color.white, Color.orange, currentVV.getPickedVertexState(), false));
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
	private void changeLayout2() {
		switch (layoutNumber) {
		case 1:
			layout = new CircleLayout<VertexType, EdgeType>(graph);
			currentVV.setGraphLayout(layout);
			break;
		case 2:
			layout = new KKLayout<VertexType, EdgeType>(graph);
			currentVV.setGraphLayout(layout);
			break;
		case 3:
			layout = new ISOMLayout<VertexType, EdgeType>(graph);
			currentVV.setGraphLayout(layout);
			break;
		case 4:
			layout = new FRLayout<VertexType, EdgeType>(graph);
			currentVV.setGraphLayout(layout);
			break;
		default:
			sLayout = new StaticLayout<VertexType, EdgeType>(graph, layout);
			currentVV.setGraphLayout(sLayout);
			break;
		}
	}/*
	private void changeLayout() {
		Class<? extends Layout<VertexType, EdgeType>> layoutC = (Class<? extends Layout<VertexType, EdgeType>>) getSelectedLayout();
		try {
			Constructor<? extends Layout<VertexType, EdgeType>> constructor = layoutC
					.getConstructor(new Class[] { Graph.class });
			Object o = constructor.newInstance(graph);
			Layout<VertexType, EdgeType> l = (Layout<VertexType, EdgeType>) o;
			l.setInitializer(currentVV.getGraphLayout());
			l.setSize(currentVV.getSize());

			LayoutTransition<VertexType, EdgeType> layoutTransition = new LayoutTransition<VertexType, EdgeType>(
					currentVV, currentVV.getGraphLayout(), l);
			Animator animator = new Animator(layoutTransition);
			animator.start();
			currentVV.getRenderContext().getMultiLayerTransformer().setToIdentity();
			currentVV.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public void saveGraph() {
		setLayoutNumber(0);
		GraphPersistence.saveGraphInfo("E:\\Relationship\\teste\\graph_info.xml", getGraph(), getsLayout());
	}
	public void loadGraph() {
		graph = GraphPersistence.loadGraphInfo("E:\\Relationship\\teste\\graph_info.xml");
		StaticLayout<VertexType, EdgeType> sLayout = new StaticLayout<VertexType, EdgeType>(graph,
				new Transformer<VertexType, Point2D>() {
					public Point2D transform(VertexType vertex) {
						Point2D p = new Point2D.Double(vertex.getX(), vertex.getY());
						return p;
					}
				});
		currentVV.setGraphLayout(sLayout);
	}

	private Class<? extends Layout> getSelectedLayout() {
		switch (layoutNumber) {
		case 1:
			return CircleLayout.class;
		case 2:
			return KKLayout.class;
		case 3:
			return FRLayout.class;
		case 4:
			return ISOMLayout.class;
		default:
			return StaticLayout.class;
		}
	}

	public int getLayoutNumber() {
		return layoutNumber;
	}

	public void setLayoutNumber(int layout) {
		layoutNumber = layout;
		changeLayout2();
	}

	public int getMouseMode() {
		return mouseMode;
	}

	public void setMouseMode(int mouseMode) {
		this.mouseMode = mouseMode;
		changeMouseMode();
	}

	public Graph<VertexType, EdgeType> getGraph() {
		return graph;
	}

	public void setGraph(Graph<VertexType, EdgeType> graphTest) {
		this.graph = graphTest;
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
	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	public StaticLayout<VertexType, EdgeType> getsLayout() {
		return sLayout;
	}

	public void setsLayout(StaticLayout<VertexType, EdgeType> sLayout) {
		this.sLayout = sLayout;
	}
}
