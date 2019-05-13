package client.components.pizzacontrolls;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.FlowPane;
import pizza.Pizza;
import pizza.decorations.DecorationType;
import pizza.factories.PizzaFactory;
import pizza.pizas.PizzaType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PizzaController implements Initializable {

    private PizzaFactory pizzaFactory = new PizzaFactory();

    @FXML
    private ChoiceBox<String> pizzaSize;
    @FXML
    private ChoiceBox<String> pizzaType;

    private CheckBox[] decorations;

    @FXML
    private FlowPane checkBoxContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addPizzaTypes();
        addDecorations();

    }

    private void addDecorations(){
        DecorationType[] values = DecorationType.values();
        decorations = new CheckBox[values.length];
        ObservableList<Node> children = checkBoxContainer.getChildren();
        for(int i=0; i<decorations.length; i++){
            decorations[i]=new CheckBox(values[i].toString());
            children.add(decorations[i]);
        }
    }


    private void addPizzaTypes(){
        PizzaType[] values= PizzaType.values();
        ObservableList<String> items = pizzaType.getItems();
        for(PizzaType type: values){
            items.add(type.toString());
        }
        pizzaType.setValue(values[0].toString());
    }

    public Pizza getPizza(){
        int pizzaSize = Integer.parseInt(this.pizzaSize.getValue());
        String pType = this.pizzaType.getValue().toUpperCase();
        PizzaType pizzaType = PizzaType.valueOf(pType);

        ArrayList<DecorationType> result = getAdditives();
        DecorationType[] additives = new DecorationType[result.size()];
        additives = result.toArray(additives);

        return pizzaFactory.makePizza(pizzaType,pizzaSize,additives);
    }


    private ArrayList<DecorationType> getAdditives(){
        ArrayList<DecorationType> result = new ArrayList<>();
        for(CheckBox box: decorations){
            if(box.isSelected())
                result.add(DecorationType.valueOf(box.getText().toUpperCase()));
        }
        return result;
    }

    public void clearInterface(){
        pizzaSize.setValue(pizzaSize.getItems().get(0));
        pizzaType.setValue(pizzaType.getItems().get(0));
        for(CheckBox box: decorations){
            box.setSelected(false);
        }
    }
}
