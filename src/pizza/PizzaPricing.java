package pizza;

public class PizzaPricing {
    private double margheritaPrice = 400;
    private double capricciosaPrice = 500;
    private double vegetarianaPrice = 600;
    private double size25Price = 50;
    private double size32Price = 75;
    private double size50Price = 100;

    private static PizzaPricing instance;

    private PizzaPricing(){

    }

    public static PizzaPricing getInstance(){
        if(instance == null){
            instance = new PizzaPricing();
        }
        return instance;
    }

    public double getMargheritaPrice() {
        return margheritaPrice;
    }

    public void setMargheritaPrice(double margheritaPrice) {
        this.margheritaPrice = margheritaPrice;
    }

    public double getCapricciosaPrice() {
        return capricciosaPrice;
    }

    public void setCapricciosaPrice(double capricciosaPrice) {
        this.capricciosaPrice = capricciosaPrice;
    }

    public double getVegetarianaPrice() {
        return vegetarianaPrice;
    }

    public void setVegetarianaPrice(double vegetarianaPrice) {
        this.vegetarianaPrice = vegetarianaPrice;
    }

    public double getSize25Price() {
        return size25Price;
    }

    public void setSize25Price(double size25Price) {
        this.size25Price = size25Price;
    }

    public double getSize32Price() {
        return size32Price;
    }

    public void setSize32Price(double size32Price) {
        this.size32Price = size32Price;
    }

    public double getSize50Price() {
        return size50Price;
    }

    public void setSize50Price(double size50Price) {
        this.size50Price = size50Price;
    }
}
