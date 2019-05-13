package pizza.decorations;

import pizza.Decoration;
import pizza.Pizza;

public class Oregano extends Decoration {
    public Oregano(Pizza pizza) {
        super(pizza,0);
        this.name = DecorationType.OREGANO.toString();
    }
}
