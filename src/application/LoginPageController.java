package application;

import java.io.IOException;
import utilities.JDBC;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;



//import com.jfoenix.controls.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginPageController implements Initializable  {

	//Declaration
	@FXML
	private Pane content_area;
	
	@FXML
	private AnchorPane content_area_pane;
	
	@FXML
	private JFXButton SignUpButton;
	
	@FXML
	private JFXButton CloseButton;
	
	@FXML
	private JFXButton BackButton;
	
	@FXML
	private JFXButton LoginButton;
	
	@FXML
	private TextField Username;
	
	@FXML
	private PasswordField Password;
	
	@FXML
	private Label errorLabel;
	
	//Change to Sign In Page
	@FXML
	private void openSignUpPage(MouseEvent event) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
		content_area.getChildren().removeAll();
		content_area.getChildren().setAll(fxml);
	}
	
	@FXML
	private void signIn(MouseEvent event) throws IOException, SQLException
	{
		String emailId = Username.getText().trim();
        String password = Password.getText().trim();

        JDBC jdbc = new JDBC();

        if (jdbc.validate(emailId, password)) 
        {
        	content_area.getScene().getWindow().hide();
    		Stage stage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    		Scene scene = new Scene(root);
    		stage.initStyle(StageStyle.TRANSPARENT);
    		stage.setScene(scene);
    		stage.show();
        	
        } 
        else 
        {
        	 errorLabel.setText("Invalid Email or Password");
        }
	}
	
	//Back Button, back to main page
	@FXML
	private void openMainPage(MouseEvent event) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		content_area_pane.getChildren().removeAll();
		content_area_pane.getChildren().setAll(fxml);
	}
	
	//Close tab
	@FXML
	private void close(MouseEvent event) throws IOException {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
