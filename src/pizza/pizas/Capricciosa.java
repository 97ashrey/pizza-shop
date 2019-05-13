package pizza.pizas;

import pizza.Pizza;

public class Capricciosa extends Pizza {
    public Capricciosa(double price) {
        super(price);
        this.name = PizzaType.CAPRICCIOSA.toString();
    }
}
