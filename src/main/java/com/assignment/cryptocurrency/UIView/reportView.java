package com.assignment.cryptocurrency.UIView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class reportView extends Application 
{
//----------------------------------------------------------------------
	public void start(Stage stage) throws Exception 
	{
        Parent root = FXMLLoader.load(getClass().getResource("report.fxml"));
        
        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root, 600, 295));
        stage.show();
    }
    
    public static void main(String[] args) 
    {
        Application.launch(reportView.class, args);
    }

}
