package com.assignment.cryptocurrency.UIView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.assignment.cryptocurrency.util.Storage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AdminDashboardView extends Application 
{
//----------------------------------------------------------------------
	Parent root;
	//----------------------------------------------------------------------
	public void start(Stage stage) throws Exception 
	{
		root = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));
        
        stage.setTitle("Admin Dashboard");
        stage.setScene(new Scene(root, 1100, 500));
        stage.show();
        //prepareDashboard();
    }
	//-----------------------------------------------------------------------------------------
    public static void main(String[] args) 
    {
        Application.launch(AdminDashboardView.class, args);
    }
  
    //-----------------------------------------------------------------------------------------
    void showLoginWindow() 
    {
      Parent root = null;
      try {
        root = FXMLLoader.load(getClass().getResource("../UIView/login.fxml"));
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      /*Stage stage = (Stage) signOutAction.getScene().getWindow();
      stage.setTitle("Login");
      stage.setScene(new Scene(root, 600, 295));
      stage.show();*/
    }
  //-----------------------------------------------------------------------------------------
}
