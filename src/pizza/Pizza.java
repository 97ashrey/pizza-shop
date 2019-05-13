package pizza;

import java.io.Serializable;

public abstract class Pizza implements Serializable {

    protected String name;
    protected double price;

    public Pizza(double price){
        this.price =  price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

}
