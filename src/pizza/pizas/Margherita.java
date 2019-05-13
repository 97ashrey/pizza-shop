package pizza.pizas;

import pizza.Pizza;

public class Margherita extends Pizza {
    public Margherita(double price) {
        super(price);
        this.name = PizzaType.MARGHERITA.toString();
    }
}
