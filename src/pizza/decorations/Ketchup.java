package pizza.decorations;

import pizza.Decoration;
import pizza.Pizza;
import pizza.pizas.PizzaType;

public class Ketchup extends Decoration {
    public Ketchup(Pizza pizza) {
        super(pizza,0);
        this.name = DecorationType.KETCHUP.toString();
    }
}
