package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

//import java.event
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.assignment.cryptocurrency.UIView.RegisterView;

import javafx.fxml.*;

public class TransferController implements Initializable
{
	
	@FXML private Button showDashboardAction;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
	
		
		showDashboardAction.setOnAction(e ->
		{
			((Node) e.getSource()).getScene().getWindow().hide();
			showDashboard();
		});
	}
	
	void showDashboard()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/dashboard.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("Back to dashboard");
        stage.setScene(new Scene(root, 600, 475));
        stage.show();
	}
}




