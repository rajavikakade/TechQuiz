package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilities.User;

public class DashboardController implements Initializable
{
	
	//Declaration 
	@FXML
	private JFXButton CloseButton;
	
	@FXML
	private AnchorPane content_area;
	
	@FXML
	private Pane content_area_pane;
	
	@FXML
	private Label NameLabel;
	
	@FXML
	private JFXButton ManageAcc;
	
	@FXML
	private JFXButton LearningRes;
	
	@FXML
	private JFXButton Signout;
	
	@FXML
	private JFXButton PrefReview;
	
	@FXML
	private JFXButton TakeTest;
	
	
	//When Signout clicked, change to Login Page
	@FXML
	private void openLoginPage(MouseEvent event) throws IOException 
	{
		content_area.getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}
	
	//Change to Learning Resources Page
	@FXML
	private void LearnResc(MouseEvent event) throws IOException 
	{
		Parent fxml = FXMLLoader.load(getClass().getResource("LearningResources.fxml"));
		content_area_pane.getChildren().removeAll();
		content_area_pane.getChildren().setAll(fxml);
	}
	@FXML
	private void manageAccount(MouseEvent event) throws IOException
	{
		Parent fxml = FXMLLoader.load(getClass().getResource("ManageAccounts.fxml"));
		content_area_pane.getChildren().removeAll();
		content_area_pane.getChildren().setAll(fxml);
	}

	@FXML
	private void performanceReview(MouseEvent event) throws IOException
	{
		Parent fxml = FXMLLoader.load(getClass().getResource("PerformanceReview.fxml"));
		content_area_pane.getChildren().removeAll();
		content_area_pane.getChildren().setAll(fxml);
	}
		
	@FXML
	private void instructionPage(MouseEvent event) throws IOException
	{
		content_area_pane.getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("InstructionPage.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
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
		NameLabel.setText(User.name);
	}
}
