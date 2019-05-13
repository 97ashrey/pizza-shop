package pizza.factories;

import pizza.Pizza;
import pizza.PizzaPricing;
import pizza.decorations.DecorationType;
import pizza.pizas.Capricciosa;
import pizza.pizas.Margherita;
import pizza.pizas.PizzaType;
import pizza.pizas.Vegetariana;

public class PizzaFactory {
    private DecorationFactory dFactory = new DecorationFactory();
    private PizzaPricing pricing = PizzaPricing.getInstance();

    public Pizza makePizza(PizzaType pizzaType, int size, DecorationType[] decorations){
        Pizza pizza = null;
        switch (pizzaType){
            case MARGHERITA:
                pizza = new Margherita(pricing.getMargheritaPrice());
                break;
            case CAPRICCIOSA:
                pizza = new Capricciosa(pricing.getCapricciosaPrice());
                break;
            case VEGETARIANA:
                pizza = new Vegetariana(pricing.getVegetarianaPrice());
                break;
            default:
                System.out.println("No type of pizza found");
                break;
        }
        pizza = dFactory.makePizza(pizza,size,decorations);
        return pizza;
    }
}
