package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	public static Scene mainScene ; 
	public static Scene scheduleScene;
	public static Scene searchScene;
	public static Scene day1generationsScene;
	public static Scene day2generationsScene;
	public static Stage primaryStage1 ;
//  
	@Override
	public void start(Stage primaryStage) {
		
			
			try {
				primaryStage1=primaryStage ; 
				
				
			AnchorPane Welcome = (AnchorPane)FXMLLoader.load(getClass().getResource("mainView.fxml"));
			mainScene = new Scene(Welcome,900.0,600.0);
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ScheduleView.fxml"));
			scheduleScene = new Scene(root,1920.0,1034);
			scheduleScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
		/*	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("searchView.fxml"));
			searchScene = new Scene(root,1920.0,1034);
			searchScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("day1View.fxml"));
			day1generationsScene = new Scene(root,1920.0,1034);
			day1generationsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("day2View.fxml"));
			day2generationsScene = new Scene(root,1920.0,1034);
			day2generationsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			*/
			primaryStage.setScene(mainScene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
