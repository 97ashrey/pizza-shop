package order;

import server.IndexController;

public class CookOrder extends Thread {
    private Order order;
    private IndexController controller;


    public CookOrder(Order order,IndexController controller){
        this.order = order;
        this.controller = controller;
        // set time here with random func
        order.setId();
        int time = (int)(Math.random()*(50-10)+10);
//        int time = 10;
//        int time = (int)(Math.random()*10 + 1);
        order.setTime(time);
        controller.addNewOrder(order);
    }

    public void run(){
        while (true){
            if(order.getTime() <= 0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.setTime(order.getTime() - 1);
            controller.refreshOrderedTable();
        }
        controller.deliverOrder(order);
    }
}
