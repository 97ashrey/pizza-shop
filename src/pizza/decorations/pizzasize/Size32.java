package pizza.decorations.pizzasize;

import pizza.Decoration;
import pizza.Pizza;

public class Size32 extends Decoration {
    public Size32(Pizza piza, double price) {
        super(piza,price);
        this.name = "Size 32";
    }
}
