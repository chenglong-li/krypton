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
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

//import java.event

public class DashboardController implements Initializable {

  @FXML
  private Label firstNameLbl;
  @FXML
  private Label lastNameLbl;

  
  @FXML
  private Button showExchangeAction1;
  
  @FXML  private Button showViewAllOffersAction;
  @FXML  private Button showPutNewOfferAction;
  @FXML  private Button showViewMyOffersAction;
  @FXML  private Button showAcceptOfferAction;
  @FXML  private Button showExchangeAction;
  @FXML  private Button showTransferAction;
  @FXML  private Button showMakeOrderAction;
  @FXML  private Button showViewAllOrdersAction;
  @FXML  private Button showViewMyOrdersAction;
  @FXML  private Button showWalletAction;
  @FXML  private Button signOutAction;
  @FXML  private Label myInviteCode;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    Object firstName = Storage.getInstance().get("firstName");
    Object lastName = Storage.getInstance().get("lastName");
    if (firstName != null) {
      firstNameLbl.setText(firstName.toString());
    }
    if (lastName != null) {
      lastNameLbl.setText(lastName.toString());
    }

    showExchangeAction1.setOnAction(e ->
    {
      //((Node) e.getSource()).getScene().getWindow().hide();
    	try {
			myInviteCode.setText(showMyInviteCode());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

    showViewAllOffersAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showViewAllOffers();
    });

    showViewMyOrdersAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showViewMyOrders();
    });

    showPutNewOfferAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showPutNewOffer();
    });

    showViewMyOffersAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showViewMyOffers();
    });

    showAcceptOfferAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showAcceptOffer();
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

    showMakeOrderAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showMakeOrder();
    });

    showViewAllOrdersAction.setOnAction(e ->
    {
      ((Node) e.getSource()).getScene().getWindow().hide();
      showViewAllOrders();
    });
  }

  //-----------------------------------------------------------------------------------------
  void showLoginWindow() {
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

  ;

  //-----------------------------------------------------------------------------------------
  void showWalletWindow() {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("../UIView/wallet.fxml"));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    Stage stage = (Stage) showWalletAction.getScene().getWindow();
    stage.setTitle("Wallet");
    stage.setScene(new Scene(root, 1100, 700));
    stage.show();
  }

  ;

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

  @FXML
  public String showMyInviteCode() throws IOException {
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

}
