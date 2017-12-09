package com.assignment.cryptocurrency.UIView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class RegisterView extends Application 
{

	public void start(Stage stage) throws Exception 
	{
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        
        stage.setTitle("Register new user");
        stage.setScene(new Scene(root, 600, 575));
        stage.show();
    }
    
    public static void main(String[] args) 
    {
        Application.launch(RegisterView.class, args);
    }

}
