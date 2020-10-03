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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InstructionPageController implements Initializable
{
	
	//Declaration 
	@FXML
	private JFXButton CloseButton;
	
	@FXML
	private JFXButton StartTest;
	
	@FXML
	private AnchorPane content_area;
	
	@FXML
	private Label Instructions;
	
	//When StartTest clicked, change to Question Page
	@FXML
	private void openQuestionPage(MouseEvent event) throws IOException 
	{
		content_area.getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("QuestionPage.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}
	
	//Back button
	@FXML
	private void openDashboard(MouseEvent event) throws IOException 
	{
		content_area.getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}
	
	
	//Close tab
	@FXML
	private void close(MouseEvent event) throws IOException {
		System.exit(0);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//To display the Instructions
		Instructions.setText(" 1. The test consists of 10 questions that will test the candidate's technical knowledge preparing them\n     for placements.\n\n "
				+ "2. Each question will be of 2 marks. So, the candidate will be scored out of 20 marks.\n\n "
				+ "3. The total time available for the test is 5 minutes. The test will get submitted automatically once\n     the time is up.\n\n "
				+ "4. All the questions are compulsory. Candidate can only proceed after attempting the current question.\n\n "
				+ "5. There is no negative marking in the test.\n\n "
				+ "6. There is only one correct option for every question.\n\n "
				+ "7. All the questions are compulsory.\n\n "
				+ "8. An answer once marked can't be changed during the test.\n\n "
				+ "9. Use of calculator/compiler is strictly prohibited.");
	}
}