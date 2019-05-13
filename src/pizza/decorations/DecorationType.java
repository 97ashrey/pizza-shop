package pizza.decorations;

public enum DecorationType {
    KETCHUP("Ketchup"),
    OREGANO("Oregano"),
    CHILI("Chili"),
    MAYONNAISE("Mayonnaise"),
    ;

    private String type;

    DecorationType(String type){
        this.type = type;
    }

    public String toString(){
        return this.type;
    }
}
