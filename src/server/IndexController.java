package server;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import order.Order;
import server.components.OrderTableController;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    @FXML VBox orderedTable;
    @FXML private OrderTableController orderedTableController;
    @FXML VBox deliveredTable;
    @FXML private OrderTableController deliveredTableController;

    private boolean refreshing = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        DecorationType[] decorations = {
//                DecorationType.CHILI,
//                DecorationType.KETCHUP,
//                DecorationType.MAYONNAISE,
//                DecorationType.OREGANO
//        };
//
//        Pizza pizza = new PizzaFactory().makePizza(PizzaType.CAPRICCIOSA,32,decorations);
//        Order order = new Order(pizza,"Tosin Bunar","12313","Jep se", PaymentMethod.CARD);
//        order.setId();
//        order.setTime(39);
//        addNewOrder(order);
//        addDeliveredOrder(order);
    }

    public synchronized void addNewOrder(Order order){
        orderedTableController.addOrder(order);
    }

    public synchronized void deliverOrder(Order order){
        deliveredTableController.addOrder(order);
        orderedTableController.removeOrder(order);
    }

    public synchronized void refreshOrderedTable(){
        orderedTableController.refreshTable();
    }
}
