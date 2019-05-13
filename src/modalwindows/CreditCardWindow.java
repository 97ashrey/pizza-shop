package modalwindows;

import client.components.ErrorTextField;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class CreditCardWindow extends ModalWindow {

    ErrorTextField cardNumber;
    ErrorTextField backNumber;

    public CreditCardWindow(){
        super();
        adjust();
    }

    public CreditCardWindow(double width, double height){
        super(width,height);
        adjust();
    }

    private void initTextFields(){
        cardNumber = new ErrorTextField();
        backNumber = new ErrorTextField();
        double cardNumberWidth = 0.85;
        cardNumber.setMaxWidth(width * cardNumberWidth);
        backNumber.setMaxWidth(width * (1 - cardNumberWidth));

        // Set limits to the input fields
        cardNumber.textProperty().addListener((observable,oldValue,newValue)->{
            // If it's not a digit
            if (!newValue.matches("\\d*")) {
                // replace all non digit chars with empty string
                cardNumber.setText(newValue.replaceAll("[^\\d]", ""));
            }
            // If the value is grater then 16 cut extra chars out
            if(newValue.length() > 16){
                cardNumber.setText(newValue.substring(0,16));
            }
        });

        backNumber.textProperty().addListener((observable,oldValue,newValue)->{
            // If it's not a digit
            if (!newValue.matches("\\d*")) {
                // replace all non digit chars with empty string
                backNumber.setText(newValue.replaceAll("[^\\d]", ""));
            }
            // If the value is grater then 3 cut extra chars out
            if(newValue.length() > 3){
                backNumber.setText(newValue.substring(0,3));
            }
        });

    }

    private boolean validateInput(){
        Alert alert = new Alert(350,100);
        ErrorTextField[] inputs = {
                cardNumber,
                backNumber
        };
        for (ErrorTextField input: inputs){
            String text = input.getText();
            if(text.equals("")){
                input.setError();
                input.requestFocus();
                alert.display("Invalid input","Please provide text fields with data.");
                return false;
            }
        }

        if(cardNumber.getText().length() < 16){
            cardNumber.setError();
            cardNumber.requestFocus();
            cardNumber.setText("");
            // alert
            alert.display("Invalid input","Your card number should be 16 digits long");
            return false;
        }

        if(backNumber.getText().length() < 3){
            backNumber.setError();
            backNumber.requestFocus();
            backNumber.setText("");
            // alert
            alert.display("Invalid input","Your back card number should be 3 digits long");
            return false;
        }

        return true;
    }

    public void adjust(){

        initTextFields();
        // Input container
        HBox inputContainer = new HBox();
        inputContainer.setSpacing(10);
        inputContainer.getChildren().addAll(cardNumber,backNumber);

        HBox btnContainer = new HBox();
        btnContainer.setAlignment(Pos.CENTER);
        Button confirm = new Button("Confirm");
        confirm.setOnAction(e->{
            if(validateInput()){
                window.close();
            }
        });

        btnContainer.getChildren().add(confirm);
        layout.getChildren().addAll(inputContainer,btnContainer);
    }


}
