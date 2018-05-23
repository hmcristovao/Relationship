package gui;

import javax.swing.JPanel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
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
	private ComboBox<String> mouseModeSelection;
	@FXML
	private AnchorPane graphDisplayPane;
	@FXML
	private ComboBox<String> layoutSelection;

	ObservableList<String> mouseModeList = FXCollections.observableArrayList("PICKING", "TRANSFORMING");
	ObservableList<String> layoutList = FXCollections.observableArrayList("Circle", "Kamada Kawai", "Self Organizing Map", "Fruchterman Reingold");
	VisualizationInstance visualizationObject = new VisualizationInstance();
	SwingNode swingNode = new SwingNode();

	@FXML
	private void initialize() {
		mouseModeSelection.setValue("TRANSFORMING");
		mouseModeSelection.setItems(mouseModeList);
		layoutSelection.setValue("Circle");
		layoutSelection.setItems(layoutList);
	}

	private void updatePane() {
		graphDisplayPane.getChildren().remove(swingNode);
		swingNode.setContent(visualizationObject.getScrollPanel());
		graphDisplayPane.getChildren().add(swingNode);
	}

	@FXML
	private void startGraph() {
		swingNode.setContent(visualizationObject.getScrollPanel());
		graphDisplayPane.getChildren().add(swingNode);
	}

	@FXML
	private void selectMouseMode() {
		if (mouseModeSelection.getValue().equals("PICKING")){
			visualizationObject.setMouseMode(1);
		}
		if (mouseModeSelection.getValue().equals("TRANSFORMING")){
			visualizationObject.setMouseMode(0);
		}
		updatePane();
	}
	@FXML
	private void selectLayout(){
		if (layoutSelection.getValue().equals("Circle")) {
			visualizationObject.setLayoutNumber(0);
		}
		if (layoutSelection.getValue().equals("Kamada Kawai")) {
			visualizationObject.setLayoutNumber(1);
		}
		if (layoutSelection.getValue().equals("Self Organizing Map")) {
			visualizationObject.setLayoutNumber(2);
		}
		if (layoutSelection.getValue().equals("Fruchterman Reingold")) {
			visualizationObject.setLayoutNumber(3);
		}
		updatePane();
		selectMouseMode();	
	}
}
