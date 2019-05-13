package pizza.decorations.pizzasize;

import pizza.Decoration;
import pizza.Pizza;

public class Size50 extends Decoration {
    public Size50(Pizza piza, double price) {
        super(piza,price);
        this.name = "Size 50";
    }
}
