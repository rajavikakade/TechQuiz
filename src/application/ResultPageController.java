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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilities.User;

public class ResultPageController implements Initializable{
	
	//Declaration 
	@FXML
	private JFXButton Back;
	
	@FXML
	private AnchorPane content_area;
	
	@FXML
	private Label Result;
	
	@FXML
	private ImageView GIF;
	
	
	//When Back clicked, change to Dashboard Page
	@FXML
	private void backToDashboardPage(MouseEvent event) throws IOException 
	{
		content_area.getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		
		Result.setText(Integer.toString(User.marks));
		
		Image image1 = new Image("/images/Good_GIF.gif");
		Image image2 = new Image("/images/Loser.gif");
		
		if(User.marks >= 10)
			GIF.setImage(image1);
		else
		{
			Result.setTextFill(Color.ORANGERED);;
			GIF.setImage(image2);
		}
	}
}