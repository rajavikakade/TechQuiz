package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.input.MouseEvent;
import utilities.JDBC;
import utilities.User;

public class PerformanceReviewController  implements Initializable 
{
   @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

	@FXML
	private JFXButton CloseButton;
		
	private JDBC jdbc = new JDBC();
		
	//Close tab
	@FXML
	private void close(MouseEvent event) throws IOException 
	{
		System.exit(0);
	}
	
	 
	@SuppressWarnings("unchecked")
	private void populateLineGraph()
	{
		xAxis.setLabel("Date and Time");
		yAxis.setLabel("Marks");
		/*if(jdbc.marksY.size() < 2)
		{
			errorLabel.setVisible(true);
			return;
		}*/
		XYChart.Series<String, Number> series = new Series<String, Number>();
		for(int i = 0; i < jdbc.marksY.size(); i++)
		{
			System.out.println("Date: " + jdbc.dateX.get(i) + " Marks: " + jdbc.marksY.get(i));
			series.getData().add(new XYChart.Data<String, Number>(jdbc.dateX.get(i), jdbc.marksY.get(i)));
		}
		lineChart.getData().addAll(series);
	}
		
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		jdbc.fetchResults(User.email);
		populateLineGraph();
		// TODO Auto-generated method stub
		
	}

}
