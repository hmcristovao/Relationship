package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
	private Button savePDF;
	@FXML
	private Button saveSVG;
	@FXML
	private ColorPicker selectColor;
	@FXML
	private ComboBox<String> mouseModeSelection;
	@FXML
	private AnchorPane graphDisplayPane;
	@FXML
	private ComboBox<String> layoutSelection;

	ObservableList<String> mouseModeList = FXCollections.observableArrayList("PICKING", "TRANSFORMING");
	ObservableList<String> layoutList = FXCollections.observableArrayList("Static", "Circle", "Kamada Kawai",
			 "Fruchterman Reingold", "Self Organizing Map");
	VisualizationInstance visualizationObject = new VisualizationInstance();
	SwingNode swingNode = new SwingNode();


	@FXML
	private void initialize() {
		mouseModeSelection.setValue("TRANSFORMING");
		mouseModeSelection.setItems(mouseModeList);
		layoutSelection.setValue("Static");
		layoutSelection.setItems(layoutList);
		//javafx.scene.paint.Color fxColor = new javafx.scene.paint.Color(255.0,0.0,0.0,0.0); //Red as deafult
		selectColor.setValue(javafx.scene.paint.Color.RED);
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
		if (mouseModeSelection.getValue().equals("PICKING")) {
			visualizationObject.setMouseMode(1);
		}
		if (mouseModeSelection.getValue().equals("TRANSFORMING")) {
			visualizationObject.setMouseMode(0);
		}
	}

	@FXML
	private void selectLayout() {
		if (layoutSelection.getValue().equals("Static")) {
			visualizationObject.setLayoutNumber(0);
		}
		if (layoutSelection.getValue().equals("Circle")) {
			visualizationObject.setLayoutNumber(1);
		}
		if (layoutSelection.getValue().equals("Kamada Kawai")) {
			visualizationObject.setLayoutNumber(2);
		}
		if (layoutSelection.getValue().equals("Self Organizing Map")) {
			visualizationObject.setLayoutNumber(3);
		}
		if (layoutSelection.getValue().equals("Fruchterman Reingold")) {
			visualizationObject.setLayoutNumber(4);
		}
	}

	@FXML
	private void save() {
		layoutSelection.setValue("Static");
		visualizationObject.saveGraph();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Saving Process");
		alert.setHeaderText("The graph was successfully saved.");
		alert.show();
	}

	@FXML
	private void load() {
		visualizationObject.loadGraph();
		updatePane();
	}
	
	@FXML
	private void changeColor() {
		visualizationObject.setVertexColor(selectColor.getValue()); 
	}
	@FXML
	private void saveGraphInPDF() {
		visualizationObject.saveInPDF();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Saving in PDF Process");
		alert.setHeaderText("The graph was successfully saved.");
		alert.show();
	}
	@FXML
	private void saveGraphInSVG() {
		visualizationObject.saveInSVG();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Saving in SVG Process");
		alert.setHeaderText("The graph was successfully saved.");
		alert.show();
	}
}
