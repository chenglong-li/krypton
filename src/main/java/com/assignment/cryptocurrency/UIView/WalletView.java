package com.assignment.cryptocurrency.UIView;

import org.hibernate.boot.archive.scan.spi.ScanEnvironment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class WalletView extends Application 
{
	//----------------------------------------------------------------------
	public void start(Stage stage) throws Exception 
	{
        Parent root = FXMLLoader.load(getClass().getResource("wallet.fxml"));
       // Scene scene = new Scene(root);        
        stage.setTitle("Wallet");
      
       
		
		Scene scene=new Scene(root, 800, 475);
		
		 stage.setScene(scene);
	        stage.show();
	        
		//Scene scene=new Scene(gp);
		//stage.setScene(scene);
		
    }
	//----------------------------------------------------------------------
    public static void main(String[] args) 
    {
        Application.launch(WalletView.class, args);
    }
	//----------------------------------------------------------------------
}
