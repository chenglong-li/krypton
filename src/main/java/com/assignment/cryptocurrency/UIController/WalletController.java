package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import net.minidev.json.JSONArray;
import javafx.scene.control.*;

//import java.awt.Button;
import java.io.BufferedReader;
//import java.event
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.json.JsonObject;
import javax.validation.constraints.Null;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.assignment.cryptocurrency.UIView.RegisterView;
import com.assignment.cryptocurrency.util.Storage;

import javafx.fxml.*;

public class WalletController implements Initializable
{
	//---------------------------------------------------------------------
	
	@FXML private Label firstNameLbl;
	@FXML private Label lastNameLbl;
	
	
	@FXML private Button showDashboardAction;
	
	@FXML private Label walletAddress1;
	@FXML private Label coin1;
	@FXML private Label amount1;
	@FXML private Label walletAddress2;
	@FXML private Label coin2;
	@FXML private Label amount2;
	@FXML private Label walletAddress3;
	@FXML private Label coin3;
	@FXML private Label amount3;
	//---------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		showDashboardAction.setOnAction(e ->
		{
			((Node) e.getSource()).getScene().getWindow().hide();
			showDashboard();
		});
		
		StringBuilder builder= getUserWalletInfo();
		if (builder!=null)
		{
			JSONObject jsonObj = new JSONObject(builder.toString());
			System.out.println(jsonObj);
			JSONArray arr = jsonObj.getJSONObject("_embedded").getJSONArray("wallet_list");
			System.out.println(arr.length());
			for (int i = 0; i < arr.length(); i++) 
			{
				JSONObject walletJson= arr.getJSONObject(i);
				//scene.lookup("#history");
				if (i==0)
				{
					
					walletAddress1.setText(walletJson.getString("address"));
					coin1.setText(Integer.toString(walletJson.getInt("coin_id")));
					amount1.setText(Double.toString(walletJson.getDouble("amount")));
				}
				else if (i==1)
				{
					
					walletAddress2.setText(walletJson.getString("address"));
					coin2.setText(Integer.toString(walletJson.getInt("coin_id")));
					amount2.setText(Double.toString(walletJson.getDouble("amount")));
				}
			}
			
		}
			
		Object firstName=Storage.getInstance().get("firstName");
		Object lastName=Storage.getInstance().get("lastName");
		if (firstName!=null)
			firstNameLbl.setText(firstName.toString());
		if (lastName!=null)
			lastNameLbl.setText(lastName.toString());
		
		
	}
	//---------------------------------------------------------------------
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
        stage.setScene(new Scene(root, 800,500));
        stage.show();
	}
	//---------------------------------------------------------------------
	StringBuilder getUserWalletInfo()
	{
		Object id=Storage.getInstance().get("userId");
		//System.out.println(id.toString());
		if (id==null)
			return null;
		CloseableHttpClient httpClient=null;
		try 
		{
			httpClient = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet("http://localhost:8080/api/wallets/search/findByUserId?userId="+id.toString());
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
	//---------------------------------------------------------------------
}




