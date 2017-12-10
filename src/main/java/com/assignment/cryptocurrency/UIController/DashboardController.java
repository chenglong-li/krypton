package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

//import java.event
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.assignment.cryptocurrency.UIView.RegisterView;

import javafx.fxml.*;

public class DashboardController implements Initializable
{

	@FXML private Button showViewAllOffersAction;
	@FXML private Button showPutNewOfferAction;
	@FXML private Button showViewMyOffersAction;
	@FXML private Button showAcceptOfferAction;
	@FXML private Button showExchangeAction;
	@FXML private Button showTransferAction;
	@FXML private Button showMakeOrderAction;
	@FXML private Button showViewAllOrdersAction;
	@FXML private Button showViewMyOrdersAction;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
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
	
	void showExchange()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/exchange.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("Exchange");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showTransfer()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/transfer.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("transfer");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showViewAllOrders()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/viewAllOrders.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("View all orders");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showMakeOrder()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/makeOrder.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("Make order");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showAcceptOffer()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/acceptOffer.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("Accept Offer");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showViewMyOffers()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/viewMyOffers.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("View my offers");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showPutNewOffer()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/putNewOffer.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("Put New Offer");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showViewAllOffers()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/viewAllOffers.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("View all Offers");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
	
	void showViewMyOrders()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/viewMyOrders.fxml"));
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Stage stage = new Stage();    
        stage.setTitle("View my orders");
        stage.setScene(new Scene(root, 600, 675));
        stage.show();
	}
}




