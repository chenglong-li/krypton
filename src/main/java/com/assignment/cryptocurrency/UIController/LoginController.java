package com.assignment.cryptocurrency.UIController;

import com.assignment.cryptocurrency.util.Storage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

//import java.event

public class LoginController implements Initializable {

  @FXML
  private Button registerAction;
  @FXML
  private Button loginAction;
  @FXML
  private TextField username;
  @FXML
  private TextField password;

  //----------------------------------------------------------------------
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    loginAction.setOnAction(e ->
    {
      StringBuilder builder = getUserInfo();
      System.out.println(builder.toString());
      if (builder != null) 
      {
        JSONObject jsonObj = new JSONObject(builder.toString());
        String id=Integer.toString(jsonObj.getInt("id"));
        Object firstName = jsonObj.get("first_name");
        Object lastName = jsonObj.get("last_name");
        Object mobile = jsonObj.get("mobile");
        Object status = jsonObj.get("status");
        Storage storage = Storage.getInstance();
        storage.save("userId", id);
        
        if (firstName != null) {
          storage.save("firstName", firstName.toString());
        }
        if (lastName != null) {
          storage.save("lastName", lastName.toString());
        }
        if (mobile != null) {
          storage.save("mobile", mobile.toString());
        }
        if (status != null) {
          storage.save("status", status.toString());
        }
      }
      showDashboardWindow();

    });
    registerAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showRegisterWindow();
    });
  }

  //----------------------------------------------------------------------
  StringBuilder getUserInfo() 
  {
    CloseableHttpClient httpClient = null;
    try 
    {
      httpClient = HttpClientBuilder.create().build();
      //username.setText("username6489");
      //password.setText("password6489");
      String getQuery ="http://localhost:8080/api/Users/Login?username=" + username.getText() + "&password="+ password.getText();
      HttpGet request = new HttpGet(getQuery);
      request.addHeader("content-type", "application/json");
      HttpResponse response = httpClient.execute(request);

      if (response.getStatusLine().getStatusCode() == 200) {
        BufferedReader reader = null;
        try 
        {
          reader = new BufferedReader(
              new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
          StringBuilder builder = new StringBuilder();
          for (String line = null; (line = reader.readLine()) != null; ) 
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
      } else {

      }
    } catch (Exception ex) {
    } finally {
      try {
        httpClient.close();
      } catch (IOException e1) {
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
    } catch (IOException e1) 
    {
      e1.printStackTrace();
    }
    Stage stage = (Stage) username.getScene().getWindow();
    stage.setTitle("Wallet");
    stage.setScene(new Scene(root, 800, 500));
    stage.show();
  }
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
  }
//-----------------------------------------------------------------------------------------

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
	        stage.setScene(new Scene(root, 600, 600));
	        stage.show();
	}
	//----------------------------------------------------------------------
}




