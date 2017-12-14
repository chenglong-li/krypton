package com.assignment.cryptocurrency.UIController;

import com.assignment.cryptocurrency.util.Storage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

//import java.event
//-----------------------------------------------------------------------------------------
public class DashboardAdminController implements Initializable 
{
	@FXML  private Label noUsersTitle;
	
	@FXML  private Label title1;
	@FXML  private Label title2;
	@FXML  private Label title3;
	@FXML  private Label title4;
	@FXML  private Label title5;
	
	@FXML  private Label firstName1;
	@FXML  private Label lastName1;
	@FXML  private Label email1;
	@FXML  private Label phone1;
	@FXML  private Label status1;
	@FXML  private Button verify1Btn;
	@FXML  private Button block1Btn;
	
	@FXML  private Label firstName2;
	@FXML  private Label lastName2;
	@FXML  private Label email2;
	@FXML  private Label phone2;
	@FXML  private Label status2;
	@FXML  private Button verify2Btn;
	@FXML  private Button block2Btn;
	
	@FXML  private Label firstName3;
	@FXML  private Label lastName3;
	@FXML  private Label email3;
	@FXML  private Label phone3;
	@FXML  private Label status3;
	@FXML  private Button verify3Btn;
	@FXML  private Button block3Btn;
	
	@FXML  private Label firstName4;
	@FXML  private Label lastName4;
	@FXML  private Label email4;
	@FXML  private Label phone4;
	@FXML  private Label status4;
	@FXML  private Button verify4Btn;
	@FXML  private Button block4Btn;
	
	@FXML  private Label firstName5;
	@FXML  private Label lastName5;
	@FXML  private Label email5;
	@FXML  private Label phone5;
	@FXML  private Label status5;
	@FXML  private Button verify5Btn;
	@FXML  private Button block5Btn;
	
	@FXML  private Button signOutAction;
	String userId1;
	String userId2;
	String userId3;
	String userId4;
	String userId5;
	//-----------------------------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		prepareDashboard();
		
		signOutAction.setOnAction(e ->
	    {
	    	showLoginWindow();
	    });
	 
		
		
		verify1Btn.setOnAction(e ->
		    {
		    	if (verifyUser(userId1))
		    	{
		    		status1.setText("Verified");
		    		verify1Btn.setVisible(false);
		    		block1Btn.setVisible(false);
		    	}
		    });
		 
		verify2Btn.setOnAction(e ->
		    {
		    	if (verifyUser(userId2))
		    	{
		    		status2.setText("Verified");
		    		verify2Btn.setVisible(false);
		    		block2Btn.setVisible(false);
		    	}
		    });
		 
		verify3Btn.setOnAction(e ->
	    {
	    	if (verifyUser(userId3))
	    	{
	    		status3.setText("Verified");
	    		verify3Btn.setVisible(false);
	    		block3Btn.setVisible(false);
	    	}
	    });
		
		verify4Btn.setOnAction(e ->
	    {
	    	if (verifyUser(userId4))
	    	{
	    		status4.setText("Verified");
	    		verify4Btn.setVisible(false);
	    		block4Btn.setVisible(false);
	    	}
	    });
		
		verify5Btn.setOnAction(e ->
	    {
	    	if (verifyUser(userId5))
	    	{
	    		status5.setText("Verified");
	    		verify5Btn.setVisible(false);
	    		block5Btn.setVisible(false);
	    	}
	    });
		
		block1Btn.setOnAction(e ->
	    {
	    	if (blockUser(userId1))
	    	{
	    		status1.setText("Blocked");
	    		verify1Btn.setVisible(false);
	    		block1Btn.setVisible(false);
	    	}
	    });
		
		block2Btn.setOnAction(e ->
	    {
	    	if (blockUser(userId2))
	    	{
	    		status2.setText("Blocked");
	    		verify2Btn.setVisible(false);
	    		block2Btn.setVisible(false);
	    	}
	    });
		
		block3Btn.setOnAction(e ->
	    {
	    	if (blockUser(userId3))
	    	{
	    		status3.setText("Blocked");
	    		verify3Btn.setVisible(false);
	    		block3Btn.setVisible(false);
	    	}
	    });
		
		block4Btn.setOnAction(e ->
	    {
	    	if (blockUser(userId4))
	    	{
	    		status4.setText("Blocked");
	    		verify4Btn.setVisible(false);
	    		block4Btn.setVisible(false);
	    	}
	    });
		
		block5Btn.setOnAction(e ->
	    {
	    	if (blockUser(userId5))
	    	{
	    		status5.setText("Blocked");
	    		verify5Btn.setVisible(false);
	    		block5Btn.setVisible(false);
	    	}
	    });
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
	    stage.setScene(new Scene(root, 600, 295));
	    stage.show();
	  }
	//-----------------------------------------------------------------------------------------
	  @FXML  public boolean blockUser(String userId)// throws IOException 
	  {
			CloseableHttpClient httpClient=null;
			try 
			{
				String url="http://localhost:8080/api/Users/"+userId+"?status=blocked";
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
	  @FXML  public boolean verifyUser(String userId)// throws IOException 
	  {
			CloseableHttpClient httpClient=null;
			try 
			{
				String url="http://localhost:8080/api/Users/"+userId+"?status=verified";
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
	  void prepareDashboard()
	  {
	  	Object adminId = Storage.getInstance().get("adminId");
	      if (adminId != null) 
	      {
	      	StringBuilder builder=getWaitingUsersList(adminId.toString());
	      	if (builder!=null)
	      	{
	      		JSONObject jsonObj = new JSONObject(builder.toString());
	      		JSONArray arr = jsonObj.getJSONArray("content");
	      		if (arr.length()>0)
	      			addWaitingUsersToView(arr);
	      		else
	      		{
	      			title1.setVisible(false);
	      			title2.setVisible(false);
	      			title3.setVisible(false);
	      			title4.setVisible(false);
	      			title5.setVisible(false);
	      			noUsersTitle.setVisible(true);
	      		}
	      	}
	      }
	  }
	//-----------------------------------------------------------------------------------------
	  void addWaitingUsersToView(JSONArray jsonArray)
	  {
			for (int i = 0; i < jsonArray.length(); i++) 
			{
				
				JSONObject userJson= jsonArray.getJSONObject(i);
				System.out.println(userJson);
				if (i==0)
				{
					firstName1.setText(userJson.getString("first_name"));
					lastName1.setText(userJson.getString("last_name"));
					phone1.setText(userJson.getString("mobile"));
					email1.setText(userJson.getString("email"));
					status1.setText(userJson.getString("status"));
					verify1Btn.setVisible(true);
					block1Btn.setVisible(true);
					userId1=Integer.toString(userJson.getInt("id"));
				}
				
				if (i==1)
				{
					firstName2.setText(userJson.getString("first_name"));
					lastName2.setText(userJson.getString("last_name"));
					phone2.setText(userJson.getString("mobile"));
					email2.setText(userJson.getString("email"));
					status2.setText(userJson.getString("status"));
					verify2Btn.setVisible(true);
					block2Btn.setVisible(true);
					userId2=Integer.toString(userJson.getInt("id"));
				}
				
				if (i==2)
				{
					firstName3.setText(userJson.getString("first_name"));
					lastName3.setText(userJson.getString("last_name"));
					phone3.setText(userJson.getString("mobile"));
					email3.setText(userJson.getString("email"));
					status3.setText(userJson.getString("status"));
					verify3Btn.setVisible(true);
					block3Btn.setVisible(true);
					userId3=Integer.toString(userJson.getInt("id"));
				}
				
				if (i==3)
				{
					firstName4.setText(userJson.getString("first_name"));
					lastName4.setText(userJson.getString("last_name"));
					phone4.setText(userJson.getString("mobile"));
					email4.setText(userJson.getString("email"));
					status4.setText(userJson.getString("status"));
					verify4Btn.setVisible(true);
					block4Btn.setVisible(true);
					userId4=Integer.toString(userJson.getInt("id"));
				}
				
				if (i==4)
				{
					firstName5.setText(userJson.getString("first_name"));
					lastName5.setText(userJson.getString("last_name"));
					phone5.setText(userJson.getString("mobile"));
					email5.setText(userJson.getString("email"));
					status5.setText(userJson.getString("status"));
					verify5Btn.setVisible(true);
					block5Btn.setVisible(true);
					userId5=Integer.toString(userJson.getInt("id"));
				}
			}
	  }
	  //-----------------------------------------------------------------------------------------
	  StringBuilder getWaitingUsersList(String adminId)
	  {
		  CloseableHttpClient httpClient = null;
		    try 
		    {
		      httpClient = HttpClientBuilder.create().build();
		      //username.setText("chenglong");
		      //password.setText("1234");
		      String url="http://localhost:8080/api/Admin/"+adminId+"/Users?status=waiting";
		      System.out.println(url);
		      String getQuery =url; 
		      HttpGet request = new HttpGet(getQuery);
		      request.addHeader("content-type", "application/json");
		      HttpResponse response = httpClient.execute(request);
		
		      if (response.getStatusLine().getStatusCode() == 200) 
		      {
		    	  BufferedReader reader = null;
		    	  try 
		          {
		            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
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
		      }
		    }
		    catch (Exception ex) 
		    {
		    } 
		   return null;
	  }
	  //----------------------------------------------------------------------
	  
  }
//-----------------------------------------------------------------------------------------
  