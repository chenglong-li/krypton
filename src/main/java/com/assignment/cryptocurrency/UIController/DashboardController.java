package com.assignment.cryptocurrency.UIController;

import com.assignment.cryptocurrency.util.Storage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import javafx.scene.control.*;

//import java.event
//-----------------------------------------------------------------------------------------
public class DashboardController implements Initializable 
{
  @FXML  private Label firstNameLbl;
  @FXML  private Label lastNameLbl;
  @FXML  private Label statusLbl;
  @FXML  private TextField emailTxt;
  
//-----------------------------------------------------------------------------------------
  @FXML  private Button inviteUserBtn;
  @FXML  private Button getVerifiedBtn;
  
  @FXML  private Button showExchangeAction;
  @FXML  private Button showTransferAction;
  @FXML  private Button showWalletAction;
  @FXML  private Button signOutAction;
  @FXML  private Label myInviteCode;
//-----------------------------------------------------------------------------------------
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) 
  {
    Object firstName = Storage.getInstance().get("firstName");
    Object lastName = Storage.getInstance().get("lastName");
    Object status = Storage.getInstance().get("userStatus");
    if (firstName != null) 
      firstNameLbl.setText(firstName.toString());
    if (lastName != null) 
      lastNameLbl.setText(lastName.toString());
    if (status != null)
    {
      statusLbl.setText(status.toString());
      if (!status.toString().equalsIgnoreCase("new"))
    	  getVerifiedBtn.setVisible(false);
      if (status.toString().equalsIgnoreCase("new") || status.toString().equalsIgnoreCase("waiting"))
      {
    	  showExchangeAction.setVisible(false);
    	  showTransferAction.setVisible(false);
      }
    }
    
    try {
		myInviteCode.setText(showMyInviteCode());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    getVerifiedBtn.setOnAction(e ->
    {
    	if (getVerified(Storage.getInstance().get("userId").toString()))
    	{
    		statusLbl.setText("WAITING");
    		getVerifiedBtn.setVisible(false);
    	}
    });
    
    inviteUserBtn.setOnAction(e ->
    {
    	if (inviteUser(emailTxt.getText()))
    		emailTxt.setText("");
    });
    
    
    signOutAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showLoginWindow();
    });

    showWalletAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showWalletWindow();
    });

    showExchangeAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showExchange();
    });

    showTransferAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showTransfer();
    });
  }
//-----------------------------------------------------------------------------------------
  @FXML  public boolean inviteUser(String email)// throws IOException 
  {
		CloseableHttpClient httpClient=null;
		try 
		{
			String userId= Storage.getInstance().get("userId").toString();
			String url="http://localhost:8080/api/Users/"+userId+"/Invite?email="+email;
			httpClient = HttpClientBuilder.create().build();
		    HttpGet request = new HttpGet(url);
		    HttpResponse  response = httpClient.execute(request);
		    if(response.getStatusLine().getStatusCode()==200)
		    {
		    	return true;
		    }
		} 
		catch (Exception ex) 
		{
		} 
		return false;
  }
//-----------------------------------------------------------------------------------------
  @FXML  public boolean getVerified(String userId)// throws IOException 
  {
		CloseableHttpClient httpClient=null;
		try 
		{
			String url="http://localhost:8080/api/Users/"+userId+"?status=waiting";
			System.out.println(url);
			httpClient = HttpClientBuilder.create().build();
		    HttpPut request = new HttpPut(url);
		    HttpResponse  response = httpClient.execute(request);
		    if(response.getStatusLine().getStatusCode()==200)
		    {
		    	return true;
		    }
		} 
		catch (Exception ex) 
		{
		} 
		return false;
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
    Stage stage = (Stage) signOutAction.getScene().getWindow();
    stage.setTitle("Login");
    stage.setScene(new Scene(root, 600, 500));
    stage.show();
  }

  //-----------------------------------------------------------------------------------------
  void showWalletWindow() 
  {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/wallet.fxml"));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    Stage stage = (Stage) showWalletAction.getScene().getWindow();
    stage.setTitle("Wallet");
    stage.setScene(new Scene(root, 1300, 700));
    stage.show();
  }

//-----------------------------------------------------------------------------------------
  void showExchange() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/exchange.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("Exchange");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showTransfer() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/transfer.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("transfer");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showViewAllOrders() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/viewAllOrders.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("View all orders");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showMakeOrder() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/makeOrder.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("Make order");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showAcceptOffer() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/acceptOffer.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("Accept Offer");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showViewMyOffers() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/viewMyOffers.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("View my offers");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showPutNewOffer() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/putNewOffer.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("Put New Offer");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showViewAllOffers() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/viewAllOffers.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("View all Offers");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  void showViewMyOrders() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/viewMyOrders.fxml"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("View my orders");
    stage.setScene(new Scene(root, 600, 675));
    stage.show();
  }
//-----------------------------------------------------------------------------------------
  @FXML  public String showMyInviteCode() throws IOException {
    Storage storInstance = Storage.getInstance();
    String userId = (String) storInstance.get("userId");

    CloseableHttpClient httpClient = null;
    Map<String, Object> resultMap = new HashMap<>();
    httpClient = HttpClientBuilder.create().build();

    HttpGet request = new HttpGet(
        "http://localhost:8080/api/vouchers/search/findByUserId?userId=" + userId);
    request.addHeader("content-type", "application/json");
    HttpResponse response = httpClient.execute(request);

    if (response.getStatusLine().getStatusCode() == 200) {
      BufferedReader reader;
      reader = new BufferedReader(
          new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
      StringBuilder builder = new StringBuilder();
      for (String line; (line = reader.readLine()) != null; ) {
        builder.append(line).append("\n");
      }
      String result = builder.toString();
      ObjectMapper mapper = new ObjectMapper();
      resultMap = mapper.readValue(result, Map.class);
    }
    httpClient.close();
    return resultMap.get("code").toString();
  }
//-----------------------------------------------------------------------------------------
}
