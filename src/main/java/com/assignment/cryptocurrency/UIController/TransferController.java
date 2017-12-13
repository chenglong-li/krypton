package com.assignment.cryptocurrency.UIController;
//import java.event
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.text.Text;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.assignment.cryptocurrency.util.CoinUtil;
import com.assignment.cryptocurrency.util.Storage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransferController implements Initializable
{
	
	@FXML private Button showDashboardAction;
	@FXML private Button showPriceBtn;
	@FXML private Button transferBtn;

	
	@FXML private TextField usernameTxt;
	@FXML private TextField coinNameTxt;
	@FXML private TextField amountTxt;
	
	@FXML private Label priceLbl;
	@FXML private Label totalPriceLbl;
	@FXML private Text transferNoticeText;

	double price,totalPrice;
	//---------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		showDashboardAction.setOnAction(e ->
		{
			((Node) e.getSource()).getScene().getWindow().hide();
			showDashboard();
		});
		
		showPriceBtn.setOnAction(e ->		
		{
//			usernameTxt.setText("username7163");
//			coinNameTxt.setText("bitcoin");
//			amountTxt.setText("2");
			if (coinNameTxt.getText().length()>0)
			{
				if (coinNameTxt.getText().length()>0)
				{
					price=Double.parseDouble(new CoinUtil().getCoinPriceByName(coinNameTxt.getText()));
					priceLbl.setText(Double.toString(price)+" $");
					if (amountTxt.getText().length()>0)
					{
						totalPrice=price*Double.parseDouble(amountTxt.getText());
						totalPriceLbl.setText(totalPrice+" $");
					}
				}
			}
		});
		
		transferBtn.setOnAction(e ->
		{
			if (sentAmountToUser()) {
				((Node) e.getSource()).getScene().getWindow().hide();
				showDashboard();
			} else {
				transferNoticeText.setText("Something went wrong");
			}
		   
		});
		
	}
	//---------------------------------------------------------------------
	boolean sentAmountToUser()
	{
		CloseableHttpClient httpClient=null;
		
		JSONObject json = new JSONObject();
		String userId=Storage.getInstance().get("userId").toString();
		json.put("crypton_type", coinNameTxt.getText());
		json.put("crypton_amount", amountTxt.getText());
		json.put("crypton_price", price);
		json.put("dest_username", usernameTxt.getText());
		
		httpClient = HttpClientBuilder.create().build();
		String url="http://localhost:8080/api/Users/"+userId+"/Transfers";
	    HttpPost request = new HttpPost(url);
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
			transferNoticeText.setText(ex.getMessage());
		} 
		return false;
	    
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
}




