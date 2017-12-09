package com.assignment.cryptocurrency.UIController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterController implements Initializable {

  @FXML
  private Button registerNewUserAction;
  @FXML
  private TextField username;
  @FXML
  private TextField password;
  @FXML
  private TextField email;
  @FXML
  private TextField tel;
  //@FXML private TextField username;
  //@FXML private TextField username;


  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {

    registerNewUserAction.setOnAction(e ->
    {
      try {
        String randString = String.valueOf(new Random().nextInt(8000));
        username.setText("username" + randString);
        password.setText("password" + randString);
        email.setText("a" + randString + "@b" + randString + ".com");
        tel.setText("555-" + randString);
        JSONObject json = new JSONObject();
        json.put("username", username.getText());
        json.put("password", password.getText());
        json.put("last_name", username.getText());
        json.put("first_name", username.getText());
        json.put("email", email.getText());
        json.put("mobile", tel.getText());
        json.put("code", "1234");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
          HttpPost request = new HttpPost("http://localhost:8080/api/Users?inviteCode=1234");
          StringEntity params = new StringEntity(json.toString());
          request.addHeader("content-type", "application/json");
          request.setEntity(params);
          HttpResponse response = httpClient.execute(request);

          if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("***************************YESSSS***");
            //hideCurrentWindow();
            //showLoginWindow();
          } else {
            System.out.println("*********************NO!!!***");
            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.getStatusLine().getStatusCode());
          }
        } catch (Exception ex) {

        } finally {
          httpClient.close();
        }

      } catch (MalformedURLException e1) {
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

  void showLoginWindow() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/login.fxml"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    Stage stage = (Stage) root.getScene().getWindow();
    stage.setTitle("FXML Welcome");
    stage.setScene(new Scene(root, 600, 275));
    stage.show();
  }

  ;

  void hideCurrentWindow() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/register.fxml"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    Stage stage = (Stage) root.getScene().getWindow();
    stage.hide();
  }
}




