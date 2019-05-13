package server.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import modalwindows.Alert;
import order.Order;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderTableController implements Initializable {
        @FXML
        private TableView<Order> table;

        public synchronized void addOrder(Order order){
            table.getItems().add(order);
        }

        public synchronized void removeOrder(Order order){
            int index = table.getItems().indexOf(order);
            table.getItems().remove(index);
        }

        public synchronized void refreshTable(){
            table.refresh();
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Alert alert = new Alert(350,200);
        // On double click open a new window with full order details
        table.setOnMouseClicked(e ->{
            if(e.getClickCount() == 2){
                String message = table.getSelectionModel().getSelectedItem().toString();
                alert.display("Order",message);
            }
        });
    }
}
