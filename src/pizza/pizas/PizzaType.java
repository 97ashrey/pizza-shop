package pizza.pizas;

public enum PizzaType {
    MARGHERITA("Margherita"),
    CAPRICCIOSA("Capricciosa"),
    VEGETARIANA("Vegateriana");

    private String type;

    PizzaType(String type){
        this.type = type;
    }

    public String toString(){
        return this.type;
    }
}
