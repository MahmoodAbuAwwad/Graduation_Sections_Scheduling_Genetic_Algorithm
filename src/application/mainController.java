package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class mainController implements Initializable {

    @FXML
    private Button readData;

    @FXML
    private Button schedules;

    @FXML
    private Button search;

    @FXML
    private Button exit;


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
    void exit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void getSchedules(ActionEvent event) {
    	Main.primaryStage1.setScene(Main.scheduleScene);
    	Main.primaryStage1.centerOnScreen();

    }

    @FXML
    void readData(ActionEvent event) throws IOException {
    	 Data data = new Data();
    	
    	FadeTransition ft = new FadeTransition(Duration.millis(1000), readData);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);


		ft.setOnFinished(e->{ 	
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Data is successfully read!" + "\n" + "Genetic Algorithm is generated.");
			alert.show();
			schedules.setDisable(false);
			search.setDisable(false);

		});
		ft.play();
    }

    @FXML
    void search(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
			schedules.setDisable(true);
			search.setDisable(true);
	}
}
