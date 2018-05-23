package gui;


import java.awt.Dimension;
import java.lang.reflect.Constructor;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.layout.LayoutTransition;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.visualization.util.Animator;

public class VisualizationInstance {
	private Graph<VertexType, EdgeType> graph;
	private int layoutNumber = 0;
	private VisualizationViewer<VertexType, EdgeType> currentVV;
	private GraphZoomScrollPane scrollPanel;
	private int mouseMode = 0;
	private DefaultModalGraphMouse<VertexType, EdgeType> graphMouse;
	
	VisualizationInstance(){
		graph = new DirectedSparseMultigraph<>();
		GenerateGraph.parseTxtIntoGraph(graph);
		Dimension dimension = new Dimension();
		dimension.setSize(1138, 718);
		currentVV = new VisualizationViewer<VertexType, EdgeType>(new CircleLayout<VertexType, EdgeType>(graph), dimension);
		applyVVRenderer();
		scrollPanel = new GraphZoomScrollPane(currentVV);
		graphMouse = new DefaultModalGraphMouse<VertexType, EdgeType>();
		changeMouseMode();
	}
	
	private void applyVVRenderer() {
		currentVV.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		currentVV.getRenderContext().setEdgeLabelTransformer(new EdgeLabelTransformer());
		currentVV.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
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
	private void changeLayout() {
		Class<? extends Layout<VertexType,EdgeType>> layoutC = 
                (Class<? extends Layout<VertexType,EdgeType>>) getSelectedLayout();
            try
            {
                Constructor<? extends Layout<VertexType, EdgeType>> constructor = layoutC
                        .getConstructor(new Class[] {Graph.class});
                Object o = constructor.newInstance(graph);
                Layout<VertexType,EdgeType> l = (Layout<VertexType,EdgeType>) o;
                l.setInitializer(currentVV.getGraphLayout());
                l.setSize(currentVV.getSize());
                
				LayoutTransition<VertexType,EdgeType> layoutTransition =
					new LayoutTransition<VertexType,EdgeType>(currentVV, currentVV.getGraphLayout(), l);
				Animator animator = new Animator(layoutTransition);
				animator.start();
				currentVV.getRenderContext().getMultiLayerTransformer().setToIdentity();
				currentVV.repaint();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

	
	private Class<? extends Layout> getSelectedLayout() {
		switch (layoutNumber) {
		case 1:
			return KKLayout.class;
		case 2:
			return FRLayout.class;
		case 3:
			return ISOMLayout.class;
		default:
			return CircleLayout.class;
		}
    }
	public int getLayoutNumber() {
		return layoutNumber;
	}
	public void setLayoutNumber(int layout) {
		layoutNumber = layout;
		changeLayout();
	}
	public int getMouseMode() {
		return mouseMode;
	}
	public void setMouseMode(int mouseMode) {
		this.mouseMode = mouseMode;
		changeMouseMode();
	}
	public Graph<VertexType, EdgeType> getGraphTest() {
		return graph;
	}
	public void setGraphTest(Graph<VertexType, EdgeType> graphTest) {
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
}
