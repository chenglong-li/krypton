package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.BufferedReader;
//import java.awt.TextField;
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
import org.json.JSONObject;

import com.assignment.cryptocurrency.UIView.RegisterView;
import com.assignment.cryptocurrency.util.CoinUtil;
import com.assignment.cryptocurrency.util.Storage;

import javafx.fxml.*;

public class ExchangeController implements Initializable
{
	
	@FXML private TextField originTypeTxt;
	@FXML private TextField destTypeTxt;
	@FXML private TextField originAmountTxt;

	@FXML private Button showDashboardAction;
	@FXML private Button submit;
	@FXML private Button getOriginPrice;
	@FXML private Button getDestPrice;
	
	@FXML private Label originPriceLbl;
	@FXML private Label destPriceLbl;
	
	
	@FXML private Label destAmountLbl;

	double originPrice;
	double destPrice;
	 //----------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		showDashboardAction.setOnAction(e ->
		{
			((Node) e.getSource()).getScene().getWindow().hide();
			showDashboard();
		});
		
		getOriginPrice.setOnAction(e ->
		{
			if (originTypeTxt.getText().length()>0)
			{
				originPrice=Double.parseDouble(new CoinUtil().getCoinPriceByName(originTypeTxt.getText()));
				originPriceLbl.setText(Double.toString(originPrice)+" $");
			}
		});
		
		getDestPrice.setOnAction(e ->
		{
			if (originAmountTxt.getText().length()>0 && destTypeTxt.getText().length()>0)
			{
				destPrice=Double.parseDouble(new CoinUtil().getCoinPriceByName(destTypeTxt.getText()));
				destPriceLbl.setText(Double.toString(destPrice)+" $");
				double originAmount=Double.parseDouble(originAmountTxt.getText());
				double destAmount=originAmount*originPrice/destPrice;
				destAmountLbl.setText(Double.toString(destAmount));
			}
		});
		
		submit.setOnAction(e ->
		{
			if (originAmountTxt.getText().length()>0 && destAmountLbl.getText().length()>0)
			{
				if(sendFormDataToServer(Storage.getInstance().get("userId").toString()))
				{
					((Node) e.getSource()).getScene().getWindow().hide();
					showDashboard();
				}
			}
		});
	}
	//----------------------------------------------------------------------
	boolean sendFormDataToServer(String userId)
	{
		CloseableHttpClient httpClient=null;
		
		JSONObject json = new JSONObject();
		json.put("user_id", userId);
		json.put("origin_type", originTypeTxt.getText().toUpperCase());
		json.put("dest_type", destTypeTxt.getText().toUpperCase());
		json.put("origin_amount", originAmountTxt.getText());
		json.put("dest_amount", destAmountLbl.getText());
		json.put("origin_price", Double.toString(originPrice));
		json.put("dest_price", Double.toString(destPrice));
		
		httpClient = HttpClientBuilder.create().build();
		String url="http://localhost:8080/api/Users/"+userId+"/Exchange";
	    HttpPost request = new HttpPost(url);
	    System.out.println("**************");
	    System.out.println(json.toString());
	    StringEntity params;
		try 
		{
			params = new StringEntity(json.toString());
			
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    HttpResponse  response = httpClient.execute(request);
		    if(response.getStatusLine().getStatusCode()==200)
		    {
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
		}
		catch (Exception ex) 
		{
		} 
		return false;
	    
	}
	//----------------------------------------------------------------------
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
	//----------------------------------------------------------------------
}




