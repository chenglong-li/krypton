package com.assignment.cryptocurrency.UIView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class DashboardView extends Application 
{

	public void start(Stage stage) throws Exception 
	{
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root, 600, 475));
        stage.show();
    }
    
    public static void main(String[] args) 
    {
        Application.launch(DashboardView.class, args);
    }

}
