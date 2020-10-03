package application;

import java.io.IOException;
import utilities.JDBC;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class SignUpPageController implements Initializable  {

	//Declaration	
	@FXML
	private AnchorPane content_area;
	
	@FXML
	private JFXButton BackButton;
	
	@FXML
	private JFXButton CloseButton;
	
	@FXML
	private JFXButton RegisterButton;
	
	@FXML
	private TextField Name;
	
	@FXML
	private PasswordField Password;
	
	@FXML
	private TextField Email;
	
	@FXML
	private PasswordField ConfirmPassword;
	
	@FXML
	private TextField College;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private ComboBox<String> ComboBox;
	
	ObservableList<String> yearList = FXCollections.observableArrayList("FE", "SE", "TE", "BE");
	
	//When Register clicked, change to Login Page
	@FXML
	private void openLoginPage(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		Launch.primaryStage.getScene().setRoot(root);
		/*Parent fxml = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		content_area.getChildren().removeAll();
		content_area.getChildren().setAll(fxml);*/
	}
	
	//Back Button pressed, change to Login Page
	@FXML
	private void backToLoginPage(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		Launch.primaryStage.getScene().setRoot(root);
		/*Parent fxml = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		content_area.getChildren().removeAll();
		content_area.getChildren().setAll(fxml);*/
	}
	
	@FXML
	private void signUp(MouseEvent event) throws IOException, InterruptedException
	{
		String name = Name.getText();
		String email = Email.getText();
		String college = College.getText();
		String pwd = Password.getText();
		String confirmPwd = ConfirmPassword.getText();
		String year = ComboBox.getValue();
		
		JDBC jdbc = new JDBC();
		if(name.isEmpty() || email.isEmpty() || college.isEmpty() || pwd.isEmpty() || year.isEmpty())
		{
			errorLabel.setText("Fields cannot be empty");
			return;
		}
		
		if(!confirmPwd.equals(pwd))	
		{
			errorLabel.setText("Password doesn't match");
			return;
		}
		
		jdbc.insertRecord(name, email, college, year, pwd);
		if(!jdbc.isUnique)
		{
			errorLabel.setText("Account already exists");
			return;
		}
		
		errorLabel.setTextFill(Color.LIMEGREEN); 
		errorLabel.setText("Account created successfully");
		
		Thread.sleep(2000);
		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		Launch.primaryStage.getScene().setRoot(root);
	}

	//Close tab
	@FXML
	private void close(MouseEvent event) throws IOException {
		System.exit(0);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ComboBox.setItems(yearList);
	}
}
