package pizza;

public abstract class Decoration extends Pizza {

    private Pizza piza;

    public Decoration(Pizza piza,double price) {
        super(price);
        this.piza = piza;
    }

    public String getName(){
        return piza.getName() + " " + this.name;
    }

    public double getPrice(){
        return piza.getPrice() + this.price;
    }
}
