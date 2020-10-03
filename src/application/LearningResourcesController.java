package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class LearningResourcesController implements Initializable {
	
	//Declaration 
	@FXML
	private JFXButton CloseButton;

	//DSA Hyperlink
	@FXML
	private void dsa1() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.geeksforgeeks.org/data-structures/"));
	}
	
	//DSA Hyperlink
	@FXML
	private void dsa2() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.youtube.com/watch?v=0IAPZzGSbME&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O"));
	}
	
	//DBSM Hyperlink
	@FXML
	private void dbms1() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.javatpoint.com/dbms-tutorial"));
	}
	
	//DBSM Hyperlink
	@FXML
	private void dbms2() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.w3schools.in/dbms/"));
	}
	
	//OOP Hyperlink
	@FXML
	private void oop1() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/"));
	}
	
	//OOP Hyperlink
	@FXML
	private void oop2() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.tutorialspoint.com/cplusplus/cpp_object_oriented.htm"));
	}
	
	//SPOS Hyperlink
	@FXML
	private void spos1() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.tutorialspoint.com/operating_system/index.htm"));
	}
	

	//SPOS Hyperlink
	@FXML
	private void spos2() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI ("https://www.youtube.com/watch?v=vBURTt97EkA&list=PLBlnK6fEyqRiVhbXDGLXDk_OQAeuVcp2O"));
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
