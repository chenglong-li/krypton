package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.assignment.cryptocurrency.UIView.RegisterView;

import javafx.fxml.*;

public class LoginController implements Initializable
{
	
	@FXML private Button registerAction;
	@FXML private Button loginAction;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		loginAction.setOnAction(e ->
		{
			System.out.println("login");
		});
		
		registerAction.setOnAction(e ->
		{
			 Parent root = null;
			try 
			{
				root = FXMLLoader.load(getClass().getResource("../UIView/register.fxml"));
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 Stage stage = new Stage();    
	        stage.setTitle("Register new user");
	        stage.setScene(new Scene(root, 600, 575));
	        stage.show();
	        ((Node) e.getSource()).getScene().getWindow().hide();
		});
		
		
		
	}
	
}




