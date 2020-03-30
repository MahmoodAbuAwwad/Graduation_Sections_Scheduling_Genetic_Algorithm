package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ScheduleController implements Initializable{
	private TableView<?> table1;
	private TableView<?> table2;

    @FXML
    private TableColumn<?, ?> day19;

    @FXML
    private TableColumn<?, ?> day110;

    @FXML
    private TableColumn<?, ?> day111;

    @FXML
    private TableColumn<?, ?> day112;

    @FXML
    private TableColumn<?, ?> day11;

    @FXML
    private Button back;

    @FXML
    private Button exit;

    @FXML
    private TextField fitness1;

    @FXML
    private TextField conflicts1;

    @FXML
    private Button generations1;

    @FXML
    private TextField fitness2;

    @FXML
    private TextField conflicts2;

    @FXML
    private Button generations2;

    @FXML
    private TableColumn<?, ?> day29;

    @FXML
    private TableColumn<?, ?> day210;

    @FXML
    private TableColumn<?, ?> day211;

    @FXML
    private TableColumn<?, ?> day212;

    @FXML
    private TableColumn<?, ?> day21;
    
    public static ObservableList<Discussion> Schedules = FXCollections.observableArrayList() ;

    @FXML
    void MouseShape(MouseEvent event) {
    	((Button) event.getSource()).setScaleX(1.1);
		((Button) event.getSource()).setScaleY(1.1);

    }

    @FXML
    void MouseShape1(MouseEvent event) {
    	((Button) event.getSource()).setScaleX(1);
		((Button) event.getSource()).setScaleY(1);

    }

    @FXML
    void back(ActionEvent event) {
    	Main.primaryStage1.setScene(Main.mainScene);
    	Main.primaryStage1.centerOnScreen();
    }

    @FXML
    void exit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void generations1(ActionEvent event) {
    	Main.primaryStage1.setScene(Main.day1generationsScene);
    	Main.primaryStage1.centerOnScreen();

    }

    @FXML
    void generations2(ActionEvent event) {
    	Main.primaryStage1.setScene(Main.day2generationsScene);
    	Main.primaryStage1.centerOnScreen();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Data data = null;
		try {
			data = new Data();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Population pop = new Population(3,data);
		//fitness1.setText(pop.getSchedules().get(0).getFitness());
		/*String text = pop.getSchedules().get(0).getChromosome()[0][0] + "\n"
		+ pop.getSchedules().get(0).getChromosome()[1][0]  + "\n"
		+ pop.getSchedules().get(0).getChromosome()[2][0] + "\n"
		+ pop.getSchedules().get(0).getChromosome()[3][0] + "\n"
		+ pop.getSchedules().get(0).getChromosome()[4][0];
		day19.setCellValueFactory(new PropertyValueFactory<Discussion,String>(pop.getSchedules().get(0).getChromosome()[1][0].toString()));
		day110.setCellValueFactory(new PropertyValueFactory<Schedule,String>("priority1"));
		day111.setCellValueFactory(new PropertyValueFactory<Schedule,String>("CPUBurst1"));
		day112.setCellValueFactory(new PropertyValueFactory<Schedule,String>("StartTime1"));
		day11.setCellValueFactory(new PropertyValueFactory<Schedule,String>("FinishTime")); 
		
		table1.setItems(Schedules);
		
		
		day29.setCellValueFactory(new PropertyValueFactory<GeneticAlgorithm,String>("pid1"));
		day210.setCellValueFactory(new PropertyValueFactory<GeneticAlgorithm,String>("priority1"));
		day211.setCellValueFactory(new PropertyValueFactory<GeneticAlgorithm,String>("CPUBurst1"));
		day212.setCellValueFactory(new PropertyValueFactory<GeneticAlgorithm,String>("StartTime1"));
		day21.setCellValueFactory(new PropertyValueFactory<GeneticAlgorithm,String>("FinishTime"));
		table2.setItems(Schedules);*/
		
		
	}

}
