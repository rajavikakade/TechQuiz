package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilities.JDBC;
import utilities.User;

public class ManageAccountsController implements Initializable 
{
	
	//Declaration	
		@FXML
		private AnchorPane content_area;
		
		@FXML
		private JFXButton CloseButton;
		
		@FXML
		private JFXButton SaveButton;
		
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
		private Label saveLabel;
		
		@FXML
		private ComboBox<String> ComboBox;
		
		@FXML
		private Label cp1;
		
		@FXML
		private Line cp2, cp3, cp4, cp5, cp6;
		
		ObservableList<String> yearList = FXCollections.observableArrayList("FE", "SE", "TE", "BE");

		//Change to Sign In Page
		@FXML
		private void save(MouseEvent event) throws IOException, InterruptedException 
		{
			JDBC jdbc = new JDBC();
			int ID = jdbc.getID(User.email);
			String name = Name.getText();
			String email = Email.getText();
			String college = College.getText();
			String year = ComboBox.getValue();
			String pass = Password.getText();
			String confirmPass = ConfirmPassword.getText();
			
			if(!confirmPass.equals(pass))	
			{
				errorLabel.setText("Password doesn't match");
				return;
			}
			
			jdbc.updateRecord(ID, email, confirmPass, name, college, year);
			if(!jdbc.isUnique)
			{
				errorLabel.setText("Email ID already exists");
				return;
			}
			errorLabel.setVisible(false);
			saveLabel.setText("Changes Saved!");
			User.name = name;
			User.email = email;
			User.pass = pass;
			User.college = college;
			User.year = year;
			Thread.sleep(2000);
			content_area.getScene().getWindow().hide();
    		Stage stage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    		Scene scene = new Scene(root);
    		stage.initStyle(StageStyle.TRANSPARENT);
    		stage.setScene(scene);
    		stage.show();
			
		}
		
		@FXML
		private void editName(MouseEvent event) throws IOException 
		{
			Name.setDisable(false);
			Name.setEditable(true);
			Name.setOpacity(1.0);
		}
		@FXML
		private void editEmail(MouseEvent event) throws IOException 
		{
			Email.setDisable(false);
			Email.setEditable(true);
			Email.setOpacity(1.0);
		}
		@FXML
		private void editCollege(MouseEvent event) throws IOException 
		{
			College.setDisable(false);
			College.setEditable(true);
			College.setOpacity(1.0);
		}
		@FXML
		private void editYear(MouseEvent event) throws IOException 
		{
			ComboBox.setDisable(false);
			ComboBox.setOpacity(1.0);
		}
		@FXML
		private void editPassword(MouseEvent event) throws IOException 
		{
			Password.setDisable(false);
			Password.setEditable(true);
			ConfirmPassword.setVisible(true);
			cp1.setVisible(true);
			cp2.setVisible(true);
			cp3.setVisible(true);
			cp4.setVisible(true);
			cp5.setVisible(true);
			cp6.setVisible(true);
			Password.setOpacity(1.0);
		}
		
		//Close tab
		@FXML
		private void close(MouseEvent event) throws IOException 
		{
			System.exit(0);
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) 
		{
			// TODO Auto-generated method stub
			ComboBox.setItems(yearList);
			Name.setText(User.name);
			Email.setText(User.email);
			College.setText(User.college);
			ComboBox.setValue(User.year);
			ComboBox.setEditable(false);
			Password.setText(User.pass);
			ConfirmPassword.setText(User.pass);
			ConfirmPassword.setVisible(false);
			cp1.setVisible(false);
			cp2.setVisible(false);
			cp3.setVisible(false);
			cp4.setVisible(false);
			cp5.setVisible(false);
			cp6.setVisible(false);
			Name.setDisable(true);
			Email.setDisable(true);
			College.setDisable(true);
			Password.setDisable(true);
			ComboBox.setDisable(true);
		}

}
