package com.assignment.cryptocurrency.UIController;

import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.assignment.cryptocurrency.util.CoinUtil;
import com.assignment.cryptocurrency.util.Storage;
import com.fasterxml.jackson.databind.node.IntNode;

import javafx.fxml.*;

public class reportController  implements Initializable
{
	//---------------------------------------------------------------------
	
	@FXML private Label totalUsers;
	@FXML private Label totalExchanges;
	@FXML private Label totalTransfers;
	@FXML private Button showDashboardAction;
	
	//---------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		StringBuilder builder= getReport();
		if (builder!=null)
			fillLabelsFromStringBuilder(builder);
		
		
		showDashboardAction.setOnAction(e ->
	    {
	    	((Node) e.getSource()).getScene().getWindow().hide();
	    	showDashboard();
	    });
	}
	//---------------------------------------------------------------------
	void fillLabelsFromStringBuilder(StringBuilder builder)
	{
		JSONObject jsonObj = new JSONObject(builder.toString());
		totalUsers.setText(Integer.toString(jsonObj.getInt("total_users")));
		totalExchanges.setText(Integer.toString(jsonObj.getInt("total_exchanges")));
		totalTransfers.setText(Integer.toString(jsonObj.getInt("total_transfers")));
	}
	//---------------------------------------------------------------------
	void showDashboard()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/adminDashboard.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("Back to dashboard");
        stage.setScene(new Scene(root, 1300,500));
        stage.show();
	}
	//---------------------------------------------------------------------
	StringBuilder getReport()
	{
		String id=Storage.getInstance().get("adminId").toString();
		CloseableHttpClient httpClient=null;
		try
		{
			httpClient = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet("http://localhost:8080/api/Admin/"+id+"/Report");
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
	
}




