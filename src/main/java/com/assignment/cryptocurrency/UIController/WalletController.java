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

import javafx.fxml.*;

public class WalletController  implements Initializable
{
	//---------------------------------------------------------------------
	
	@FXML private Label firstNameLbl;
	@FXML private Label lastNameLbl;
	@FXML private Button showDashboardAction;
	
	@FXML private Label walletAddress1;
	@FXML private Label coinLbl1;
	@FXML private Label amount1;
	@FXML private Label walletAddress2;
	@FXML private Label coinLbl2;
	@FXML private Label amount2;
	@FXML private Label walletAddress3;
	@FXML private Label coinLbl3;
	@FXML private Label amount3;
	@FXML private Label walletAddress4;
	@FXML private Label coinLbl4;
	@FXML private Label amount4;
	@FXML private Label walletAddress5;
	@FXML private Label coinLbl5;
	@FXML private Label amount5;
	@FXML private Label price1;
	@FXML private Label price2;
	@FXML private Label price3;
	@FXML private Label price4;
	@FXML private Label price5;
	
	Timer t;
	String coinLabel1, coinLabel2,coinLabel3,coinLabel4,coinLabel5;
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
			fillLabelsFromStringBuilder(builder);
		}
		Object firstName=Storage.getInstance().get("firstName");
		Object lastName=Storage.getInstance().get("lastName");
		if (firstName!=null)
			firstNameLbl.setText(firstName.toString());
		if (lastName!=null)
			lastNameLbl.setText(lastName.toString());
		
		updatePrices();
		
		 /*t = new Timer( );
		t.scheduleAtFixedRate(new TimerTask() 
		{

		    @Override
		    public void run() 
		    {
		      updatePrices();

		    }
		}, 1000,10000);
		 
		*/
	}
	//---------------------------------------------------------------------
	void updatePrices()
	{
		if (coinLabel1!="" && coinLabel1!=null)
		{
			String price1s= new CoinUtil().getCoinPriceByName(coinLabel1);
			if (price1!=null)
				price1.setText(price1s.toString());
		}
		
		if (coinLabel2!="" && coinLabel2!=null)
		{
			String price2s= new CoinUtil().getCoinPriceByName(coinLabel2);
			if (price2!=null)
				price2.setText(price2s.toString());
		}
		
		if (coinLabel3!="" && coinLabel3!=null)
		{
			String price3s= new CoinUtil().getCoinPriceByName(coinLabel3);
			if (price3!=null)
				price3.setText(price3s.toString());
		}
		
		if (coinLabel4!="" && coinLabel4!=null)
		{
			String price4s= new CoinUtil().getCoinPriceByName(coinLabel4);
			if (price4!=null)
				price4.setText(price4s.toString());
		}
		
		if (coinLabel5!="" && coinLabel5!=null)
		{
			String price5s= new CoinUtil().getCoinPriceByName(coinLabel5);
			if (price5!=null)
				price5.setText(price5s.toString());
		}
	}	
	//---------------------------------------------------------------------
	String getCoinName(int id)
	{
		return getCoinName(Integer.toString(id));
	}
	//---------------------------------------------------------------------
	String getCoinName(String id)
	{
		String name="";
		switch (id) {
		case "1":
			name="Bitcoin";
			break;
		case "2":
			name="Ethereum";
			break;
		case "3":
			name="Litecoin";
			break;
		case "4":
			name="Iota";
			break;
		case "5":
			name="Neo";
			break;
		default:
			break;
		}
		return name;
	}
	//---------------------------------------------------------------------
	void fillLabelsFromStringBuilder(StringBuilder builder)
	{
		System.out.println("******************FILLING...");
		JSONObject jsonObj = new JSONObject(builder.toString());
		JSONArray arr = jsonObj.getJSONObject("_embedded").getJSONArray("wallet_list");
		System.out.println(jsonObj.toString());
		for (int i = 0; i < arr.length(); i++) 
		{
			
			//scene.lookup("#history");
			if (i==0)
			{
				JSONObject walletJson= arr.getJSONObject(0);
				String address1=walletJson.getString("address");
				if (address1.length()>14)
					address1=address1.substring(0,14)+"...";
				walletAddress1.setText(address1);
				int coinId=walletJson.getInt("coin_id");
				//System.out.println()
				coinLbl1.setText(getCoinName(coinId));
				coinLabel1=getCoinName(coinId);
				amount1.setText(Double.toString(walletJson.getDouble("amount")));
			}
			else if (i==1)
			{
				JSONObject walletJson= arr.getJSONObject(1);
				String address2=walletJson.getString("address");
				if (address2.length()>14)
					address2=address2.substring(0,14)+"...";
				walletAddress2.setText(address2);
				int coinId=walletJson.getInt("coin_id");
				//System.out.println()
				coinLbl2.setText(getCoinName(coinId));
				coinLabel2=getCoinName(coinId);
				amount2.setText(Double.toString(walletJson.getDouble("amount")));
			}
			else if (i==2)
			{
				JSONObject walletJson= arr.getJSONObject(2);
				String address3=walletJson.getString("address");
				if (address3.length()>14)
					address3=address3.substring(0,14)+"...";
				walletAddress3.setText(address3);
				int coinId=walletJson.getInt("coin_id");
				//System.out.println()
				coinLbl3.setText(getCoinName(coinId));
				coinLabel3=getCoinName(coinId);
				amount3.setText(Double.toString(walletJson.getDouble("amount")));
			}
			else if (i==3)
			{
				JSONObject walletJson= arr.getJSONObject(3);
				String address4=walletJson.getString("address");
				if (address4.length()>14)
					address4=address4.substring(0,14)+"...";
				walletAddress4.setText(address4);
				int coinId=walletJson.getInt("coin_id");
				//System.out.println()
				coinLbl4.setText(getCoinName(coinId));
				coinLabel4=getCoinName(coinId);
				amount4.setText(Double.toString(walletJson.getDouble("amount")));
			}
			else if (i==4)
			{
				JSONObject walletJson= arr.getJSONObject(4);
				String address5=walletJson.getString("address");
				if (address5.length()>14)
					address5=address5.substring(0,14)+"...";
				walletAddress5.setText(address5);
				int coinId=walletJson.getInt("coin_id");
				//System.out.println()
				coinLbl5.setText(getCoinName(coinId));
				coinLabel5=getCoinName(coinId);
				amount5.setText(Double.toString(walletJson.getDouble("amount")));
			}
		}
		
	}
	//---------------------------------------------------------------------
	void showDashboard()
	{
		if (t!=null)
			t.cancel();
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
	
}




