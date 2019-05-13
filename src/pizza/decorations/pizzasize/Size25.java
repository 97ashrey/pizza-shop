package pizza.decorations.pizzasize;

import pizza.Decoration;
import pizza.Pizza;

public class Size25 extends Decoration {
    public Size25(Pizza piza,double price) {
        super(piza,price);
        this.name = "Size 25";
    }
}
