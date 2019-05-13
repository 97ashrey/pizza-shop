package pizza.factories;

import pizza.Decoration;
import pizza.Pizza;
import pizza.PizzaPricing;
import pizza.decorations.*;
import pizza.decorations.pizzasize.Size25;
import pizza.decorations.pizzasize.Size32;
import pizza.decorations.pizzasize.Size50;

public class DecorationFactory {

    PizzaPricing pricing = PizzaPricing.getInstance();

    private Pizza addSize(Pizza pizza, int size){
        switch (size){
            case 25:
                pizza = new Size25(pizza,pricing.getSize25Price());
                break;
            case 32:
                pizza = new Size32(pizza,pricing.getSize32Price());
                break;
            case 50:
                pizza = new Size50(pizza,pricing.getSize50Price());
                break;
        }
        return pizza;
    }

    private Pizza decoratePizza(Pizza pizza, DecorationType type){
        switch (type){
            case KETCHUP:
                pizza = new Ketchup(pizza);
                break;
            case CHILI:
                pizza = new Chili(pizza);
                break;
            case OREGANO:
                pizza = new Oregano(pizza);
                break;
            case MAYONNAISE:
                pizza = new Mayonnaise(pizza);
                break;
        }

        return pizza;
    }

    public Pizza makePizza(Pizza pizza,int size, DecorationType[] types){
        pizza = addSize(pizza,size);
        for(DecorationType type: types){
            pizza = decoratePizza(pizza,type);
        }
        return pizza;
    }
}
