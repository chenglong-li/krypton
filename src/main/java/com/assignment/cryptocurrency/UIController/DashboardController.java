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

public class DashboardController implements Initializable
{
	
	@FXML private Button showViewMyOrdersAction;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
	
		
		showViewMyOrdersAction.setOnAction(e ->
		{
			((Node) e.getSource()).getScene().getWindow().hide();
			showViewMyOrders();
		});
	}
	
	void showViewMyOrders()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/viewMyOrders.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("View my orders");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
}




