package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Launch extends Application {
	
	public static Stage primaryStage = null;;
	private double xOffset = 0;
	private double yOffset = 0;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			/*BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
			//Launching Main Page
			Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			
			root.setOnMousePressed((MouseEvent event) -> {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			});
			
			root.setOnMouseDragged((MouseEvent event) -> {
				primaryStage.setX(event.getSceneX() - xOffset);
				primaryStage.setY(event.getSceneY() - yOffset);
			});
			
			primaryStage.setScene(scene);
			Launch.primaryStage = primaryStage;
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
