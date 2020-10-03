package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilities.JDBC;
import utilities.Question;
import utilities.User;

public class QuestionPageController implements Initializable
{
	@FXML
	private AnchorPane content_area;
	
	@FXML
	private Label Minutes;
	
	@FXML
	private Label Seconds;
	
	@FXML
	private Label QuestionNo;
	
	@FXML
	private JFXButton Next;
	
	@FXML
	private JFXRadioButton Opt1;
	
	@FXML
	private JFXRadioButton Opt2;
	
	@FXML
	private JFXRadioButton Opt3;
	
	@FXML
	private JFXRadioButton Opt4;
	
	@FXML
	private ToggleGroup OptAns;
	
	@FXML
	private Label Question;
	
	@FXML
	private Circle one, two, three, four, five, six, seven, eight, nine;
	
	int currentQuesNo = 0;
	
	int totalQuesCount = 10;
	
	int marks = 0;
	
	Question question[] = new Question[10]; //Array of objects
	
	public String getSelectedAns() throws Exception //Returns the selected answer
	{
		String selAns = null;
		
		if(Opt1.isSelected())
		{
			selAns = Opt1.getText();
		}
		else if(Opt2.isSelected())
		{
			selAns = Opt2.getText();
		}
		else if(Opt3.isSelected())
		{
			selAns = Opt3.getText();
		}
		else if(Opt4.isSelected())
		{
			selAns = Opt4.getText();
		}
		
		return selAns;
	}
	
	public void clearOptionSelection()
	{
		Opt1.setSelected(false);
		Opt2.setSelected(false);
		Opt3.setSelected(false);
		Opt4.setSelected(false);
	}
	
	public List<Integer> generateRandomNumbers() //Generates random question IDs to fetch from database
	{
		Random rand = new Random();
		List<Integer> randomNumbers = new ArrayList<Integer>();	//ArrayList for 10 questions
		
		while(randomNumbers.size() != totalQuesCount)
		{
			int num = rand.nextInt(26) + 1;//Random Numbers from 1 to 100
			if(!randomNumbers.contains(num))//To generate unique random numbers
			{
				randomNumbers.add(num);
			}
		}
		return randomNumbers;
	}
	
	public void assignQuestions()	//Store all questions in an array of objects (question)
	{
		List<Integer> questionNumber = generateRandomNumbers();
		JDBC jdbc = new JDBC();
		for(int i = 0; i < 10; i++)
		{
			question[i] = jdbc.fetchQuestion(questionNumber.get(i));
		}
	}
	
	@FXML
	public void nextBtn(MouseEvent event) throws Exception 
	{
		String selectedAns = getSelectedAns();
		clearOptionSelection();
		if(selectedAns == null)
		{
			//errorLabel.setText("Please select an option before proceeding!"); 
			System.out.println("Please select an option before proceeding!");
			return;
		}
		//errorLabel.setText("");
		if(selectedAns.equals(question[currentQuesNo].ans)) marks += 2;
		
		colorVisitedQuestion();
		
		currentQuesNo++;
		
		if(currentQuesNo < totalQuesCount)
			setQuestion(currentQuesNo);
	}
	
	void colorVisitedQuestion() throws IOException
	{
		switch(currentQuesNo)
		{
			case 0: one.setFill(Color.web("#88d66f")); break;
			case 1: two.setFill(Color.web("#88d66f")); break;
			case 2: three.setFill(Color.web("#88d66f")); break;
			case 3: four.setFill(Color.web("#88d66f")); break;
			case 4: five.setFill(Color.web("#88d66f")); break;
			case 5: six.setFill(Color.web("#88d66f")); break;
			case 6: seven.setFill(Color.web("#88d66f")); break;
			case 7: eight.setFill(Color.web("#88d66f")); break;
			
			case 8: nine.setFill(Color.web("#88d66f"));
					Next.setText("SUBMIT");
					Next.setStyle("-fx-background-color: #88d66f;");
					break;
			
			case 9: calculateResult();
			default: return;
		}
	}
	
	//Calculate Final Result after submitting the test
	public void calculateResult() throws IOException
	{
		System.out.println("TOTAL MARKS: \n\t" + marks + " OUT OF 20");
		JDBC jdbc = new JDBC();
		User.marks = marks;
		jdbc.insertResult(User.marks, User.email);
		
		content_area.getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ResultPage.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}
	
	public void setQuestion(int quesNo) throws Exception
	{
		QuestionNo.setText(Integer.toString(quesNo+1));
		Question.setText(question[quesNo].ques);
		Opt1.setText(question[quesNo].op1);
		Opt2.setText(question[quesNo].op2);
		Opt3.setText(question[quesNo].op3);
		Opt4.setText(question[quesNo].op4);
	}
	
	public void startTimer() 
	{
	    Timer timer = new Timer();
	    
	    TimerTask task = new TimerTask() 
	    {
	    	int minutes = 4;
	    	int seconds = 60;
	        public void run() 
	        {
	        	if(minutes <= 0 && seconds <= 0)	
	        	{
	        		timer.cancel();
	        		try 
	        		{
						calculateResult();
					} 
	        		catch (IOException e) 
	        		{
						e.printStackTrace();
					}
	        	}
	        	
	        	else if(minutes >= 0)
	            {
	        		seconds--;
	        		if(seconds%10 == seconds) 
	        			Platform.runLater(() -> Seconds.setText("0" + Integer.toString(seconds)));
	        		else
	        			Platform.runLater(() -> Seconds.setText(Integer.toString(seconds)));
	        		
	                
	        		Platform.runLater(() -> Minutes.setText(Integer.toString(minutes)));
	                if(seconds == 0)
	                {
		        		seconds = 59;
	                	minutes--;
	                	Platform.runLater(() -> Minutes.setText(Integer.toString(minutes)));
		                Platform.runLater(() -> Seconds.setText(Integer.toString(seconds)));
	                }
	            }
	        }
	    };
	    
	    timer.scheduleAtFixedRate(task, 1000,1000);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		assignQuestions(); //All questions' data stored in an object (End of Database Operations)
		startTimer();
		
		try 
		{
			setQuestion(currentQuesNo);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
