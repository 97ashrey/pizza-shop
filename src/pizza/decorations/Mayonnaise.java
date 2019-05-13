package pizza.decorations;

import pizza.Decoration;
import pizza.Pizza;

public class Mayonnaise extends Decoration {
    public Mayonnaise(Pizza pizza) {
        super(pizza,0);
        this.name = DecorationType.MAYONNAISE.toString();
    }
}
