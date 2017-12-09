package com.assignment.cryptocurrency.UIView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class ProfileView extends Application 
{

	public void start(Stage stage) throws Exception 
	{
        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        
        stage.setTitle("Profile");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }
    
    public static void main(String[] args) 
    {
        Application.launch(ProfileView.class, args);
    }

}
