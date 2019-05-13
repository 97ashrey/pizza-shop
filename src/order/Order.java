package order;

import pizza.Pizza;

import java.io.Serializable;

public class Order implements Serializable {
    private Pizza pizza;
    private String address;
    private String phone;
    private String message;
    private PaymentMethod paymentMethod;
    private int id;
    private int time;
    private static int idGenerator = 0;


    public Order(Pizza pizza, String address, String phone, String message, PaymentMethod paymentMethod) {
        this.pizza = pizza;
        this.address = address;
        this.phone = phone;
        this.message = message;
        this.paymentMethod = paymentMethod;
    }

    public String getOrderName(){
        return pizza.getName();
    }

    public double getPrice(){
        return pizza.getPrice();
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public String getMessage(){
        return message;
    }

    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }

    public void setId(){
        id = ++idGenerator;
    }

    public int getId(){
        return id;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Order: " + pizza.getName() + " \n";
        output += "Address: " + address + " \n";
        output += "Phone: " + phone + " \n";
        output += "Message: " + message + " \n";
        output += "Total cost: " + getPrice() + " \n";
        output += "Payment method: " + paymentMethod.toString();
        return output;
    }
}
