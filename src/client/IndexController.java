package client;

import client.components.gridwrapper.GridWrapper;
import client.components.pizzacontrolls.PizzaController;
import client.components.userinfocontrolls.UserInfoController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import modalwindows.Alert;
import modalwindows.ConfirmWindow;
import modalwindows.CreditCardWindow;
import order.Order;
import order.PaymentMethod;
import pizza.Pizza;
import requesthandler.RequestHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    @FXML VBox layout;
    @FXML GridWrapper pizzaControls;
    @FXML private PizzaController pizzaControlsController;
    @FXML GridWrapper userInfo;
    @FXML private UserInfoController userInfoController;

    public Button orderButton;

    private RequestHandler rh;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rh = new RequestHandler();

        orderButton.setOnAction(e->{
          order();
        });

    }

    private void order(){
        String[] input = userInfoController.getInput();
        if(input == null)
            return;
        String address = input[userInfoController.ADDRESS];
        String phone = input[userInfoController.PHONE];
        String message = input[userInfoController.MESSAGE];
        Pizza pizza = pizzaControlsController.getPizza();
        PaymentMethod paymentMethod = userInfoController.getPaymentMethod();
        // This is just a question for the input it doesn't actually have any other logic
        if(paymentMethod == PaymentMethod.CARD){
            creditCardInput();
        }
        // Make order
        Order order = new Order(pizza,address,phone,message,paymentMethod);
        // Ask user if he is satisfied with his order
        String modalMessage = "Are you sure with choices in your order? \n";
        modalMessage += order.toString();
        boolean answer = new ConfirmWindow(300,180).display("Confirm order",modalMessage);
        // Make the request
        if(answer){
            String response = rh.order(order);
            new Alert().display("Order",response);
            // clear interface for new order
            pizzaControlsController.clearInterface();
            userInfoController.clearInterface();
        }

    }

    private void creditCardInput(){
        CreditCardWindow cdw = new CreditCardWindow(300,100);
        cdw.display("Credit card","Enter your credit card number");
    }

}
