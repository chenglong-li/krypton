package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;
import javafx.scene.control.*;

import java.io.BufferedReader;
//import java.event
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.eclipse.persistence.internal.libraries.antlr.runtime.debug.DebugEventHub;
import org.json.JSONObject;


import com.assignment.cryptocurrency.UIView.RegisterView;
import com.assignment.cryptocurrency.util.Storage;

import javafx.fxml.*;

public class LoginController implements Initializable
{
	@FXML private Button registerAction;
	@FXML private Button loginAction;
	@FXML private TextField username;
	@FXML private TextField password;
	//----------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		loginAction.setOnAction(e ->
		{
			StringBuilder builder= getUserInfo();
			if (builder!=null)
			{
				JSONObject jsonObj = new JSONObject(builder.toString());
				Storage storage = Storage.getInstance();
				storage.save("userId", jsonObj.getInt("id"));
				
				storage.save("firstName", jsonObj.getString("first_name"));
				storage.save("lastName", jsonObj.getString("last_name"));
				storage.save("mobile", jsonObj.getString("mobile"));
				storage.save("status", jsonObj.getString("status"));
				((Node) e.getSource()).getScene().getWindow().hide();
				showDashboardWindow();
			}
			
		});
		registerAction.setOnAction(e ->
		{
			((Node) e.getSource()).getScene().getWindow().hide();
			 showRegisterWindow();
		});
	}
	//----------------------------------------------------------------------
	StringBuilder  getUserInfo()
	{
		CloseableHttpClient httpClient=null;
		try 
		{
			httpClient = HttpClientBuilder.create().build();
			username.setText("username7539");
			password.setText("password7539");
			HttpGet request = new HttpGet("http://localhost:8080/api/Users/Login?username=" + username.getText()+"&password="+password.getText());
		    request.addHeader("content-type", "application/json");
		    HttpResponse  response = httpClient.execute(request);
		    
		    if(response.getStatusLine().getStatusCode()==200)
		    {
		    	BufferedReader reader = null;
				try 
				{
					reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
					StringBuilder builder = new StringBuilder();
					for (String line = null; (line = reader.readLine()) != null;) 
					{
					    builder.append(line).append("\n");
					}
					return builder;
				}
				catch (Exception ex) 
				{
				} 
				finally 
				{
					
				}
		    	//hideCurrentWindow();
			    //showLoginWindow();
		    }
		    else
		    {
		    	
		    }
		} 
		catch (Exception ex) 
		{
		} 
		finally 
		{
			try 
			{
				httpClient.close();
			} 
			catch (IOException e1) 
			{
			}
		}
		return null;
	}
	
	//-----------------------------------------------------------------------------------------
	void showWalletWindow()
		{
			Parent root = null;
			try 
			{
				root = FXMLLoader.load(getClass().getResource("../UIView/wallet.fxml"));
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			 Stage stage = (Stage) username.getScene().getWindow();
	        stage.setTitle("Wallet");
	        stage.setScene(new Scene(root, 800, 500));
	        stage.show();
		};
		//-----------------------------------------------------------------------------------------
		void showDashboardWindow()
			{
				Parent root = null;
				try 
				{
					root = FXMLLoader.load(getClass().getResource("../UIView/dashboard.fxml"));
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				 Stage stage = (Stage) username.getScene().getWindow();
		        stage.setTitle("My Dashboard");
		        stage.setScene(new Scene(root, 800, 500));
		        stage.show();
			};
	//----------------------------------------------------------------------
	void showRegisterWindow()
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
		 Stage stage = (Stage) registerAction.getScene().getWindow();
	        stage.setTitle("Register new user");
	        stage.setScene(new Scene(root, 600, 500));
	        stage.show();
	}
	//----------------------------------------------------------------------
}




