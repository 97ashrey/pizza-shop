package client.components.pricingtable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import pizza.PizzaPricing;
import pizza.pizas.PizzaType;

import java.net.URL;
import java.util.ResourceBundle;

public class PricingTableController implements Initializable {

    PizzaPricing pricing = PizzaPricing.getInstance();

    @FXML GridPane layout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();
    }

    private void setTable(){
        int columnCount = 4;
        PizzaType[] values = PizzaType.values();
        for(int i=0; i<values.length; i++){
            PizzaType type = values[i];
            int row = i + 2;
            Label pizzaName = new Label(type.toString());
            layout.add(pizzaName,0,row);
            for(int j=1; j<columnCount; j++){
                Label price = new Label(getPrice(type,j));
                layout.add(price,j,row);
            }
        }
    }

    private String getPrice(PizzaType type, int column){
      double price = 0;
      switch (type){
          case MARGHERITA:
              price = pricing.getMargheritaPrice();
              break;
          case CAPRICCIOSA:
              price = pricing.getCapricciosaPrice();
              break;
          case VEGETARIANA:
              price = pricing.getVegetarianaPrice();
              break;
      }

      switch (column){
          case 1:
              price += pricing.getSize25Price();
              break;
          case 2:
              price += pricing.getSize32Price();
              break;
          case 3:
              price += pricing.getSize50Price();
              break;
      }

      return "" + price;
    }
}
