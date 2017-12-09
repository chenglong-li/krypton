package com.assignment.cryptocurrency.UIView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class LoginView extends Application 
{

	public void start(Stage stage) throws Exception 
	{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root, 600, 275));
        stage.show();
        
    }
    
    public static void main(String[] args) 
    {
        Application.launch(LoginView.class, args);
    }

}
