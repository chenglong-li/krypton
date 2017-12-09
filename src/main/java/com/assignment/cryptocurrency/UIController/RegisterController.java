package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.api.UrlAssert;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;

import com.assignment.cryptocurrency.UIView.RegisterView;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.fxml.*;

public class RegisterController implements Initializable
{
	
	@FXML private Button registerNewUserAction;
	@FXML private TextField username;
	@FXML private TextField password;
	@FXML private TextField email;
	@FXML private TextField tel;
	//@FXML private TextField username;
	//@FXML private TextField username;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		
		registerNewUserAction.setOnAction(e ->
		{
			try 
			{
				JSONObject json = new JSONObject();
				json.put("username", username.getText());
				json.put("password", username.getText());
				json.put("last_name", username.getText());
				json.put("first_name", username.getText());
				json.put("email", email.getText());
				json.put("code", "1234");

				CloseableHttpClient httpClient = HttpClientBuilder.create().build();

				try {
				    HttpPost request = new HttpPost("http://localhost:8080/api/Users?inviteCode=1234");
				    StringEntity params = new StringEntity(json.toString());
				    request.addHeader("content-type", "application/json");
				    request.setEntity(params);
				    httpClient.execute(request);
				// handle response here...
				} catch (Exception ex) {
				    // handle exception here
				} finally {
				    httpClient.close();
				}
				
			} 
			catch (MalformedURLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	}
	
}




