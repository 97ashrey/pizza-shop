package pizza.decorations;

import pizza.Decoration;
import pizza.Pizza;

public class Chili extends Decoration {
    public Chili(Pizza pizza) {
        super(pizza,0);
        this.name = DecorationType.CHILI.toString();
    }
}
