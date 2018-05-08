package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class BasicGUIController {
	@FXML
	private Button startButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button loadButton;
	@FXML
	private ColorPicker selectCollor;
	@FXML
	private ChoiceBox<String> mouseModeSelection;
	@FXML
	private AnchorPane graphDisplayPane;

	ObservableList<String> mouseModeList = FXCollections.observableArrayList("PICKING", "TRANSFORMING");

	@FXML
	private void initialize() {
		mouseModeSelection.setValue("PICKING");
		mouseModeSelection.setItems(mouseModeList);
	}
	
	private void updatePane(JPanel graphPanel) {
		//graphPanel.setSize((int)graphDisplayPane.getWidth(), (int)graphDisplayPane.getHeight());
		SwingNode swingNode = new SwingNode();
		
		swingNode.setContent(graphPanel);
		graphDisplayPane.getChildren().add(swingNode);
	}

	@FXML
	private void startGraph() {
		Graph<VertexType, EdgeType> graphTest = new DirectedSparseMultigraph<>();
		DisplayGraph.parseTxtIntoGraph(graphTest);
		Dimension dimension = new Dimension();
		dimension.setSize(graphDisplayPane.getWidth(), graphDisplayPane.getHeight());
		VisualizationViewer<VertexType, EdgeType> currentVV = new VisualizationViewer<VertexType, EdgeType>(
				DisplayGraph.changeLayout(0, graphTest), dimension);
		DisplayGraph.generateVisualGraph(graphTest, 0, currentVV);
		GraphZoomScrollPane scrollPanel = new GraphZoomScrollPane(currentVV);
		updatePane(scrollPanel);
	}
}
