package pizza.pizas;

import pizza.Pizza;

public class Vegetariana extends Pizza {
    public Vegetariana(double price) {
        super(price);
        this.name = PizzaType.VEGETARIANA.toString();
    }
}
