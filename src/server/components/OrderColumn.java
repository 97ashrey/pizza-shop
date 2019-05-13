package server.components;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import order.Order;

public class OrderColumn extends PercentageColumn<Order,String> {

    // Column to display the name of the pizza object in order object
    public OrderColumn(){
        setCellValueFactory(new Callback<CellDataFeatures<Order, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Order, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().getOrderName());
            }
        });
    }
}
