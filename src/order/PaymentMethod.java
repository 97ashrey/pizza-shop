package order;

public enum PaymentMethod {
    CASH("Cash"),
    CARD("Card");

    private String value;
    PaymentMethod(String value){
        this.value = value;
    }

    public String toString(){
        return this.value;
    }
}
