package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
//import com.jfoenix.controls.JFXButton;

public class MainController implements Initializable {
	
	//Declaration
	@FXML
	private AnchorPane content_area;
	
	@FXML
	private JFXButton CloseButton;
	
	@FXML
	private JFXButton StudentButton;
	
	@FXML
	private JFXButton AdminButton;
	
	//Change to Student Login Page
	@FXML
	private void openLoginPage(MouseEvent event) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		content_area.getChildren().removeAll();
		content_area.getChildren().setAll(fxml);
	}
	
	//Close tab
	@FXML
	private void close (MouseEvent event) throws IOException {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
