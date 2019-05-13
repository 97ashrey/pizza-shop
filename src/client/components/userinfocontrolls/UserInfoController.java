package client.components.userinfocontrolls;

import client.components.ErrorTextField;
import client.components.gridwrapper.GridWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import modalwindows.Alert;
import order.PaymentMethod;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInfoController implements Initializable {

    @FXML
    private GridWrapper layout;

    @FXML
    private ChoiceBox<String> paymentMethod;

    public final int ADDRESS = 0;
    public final int PHONE = 1;
    public final int MESSAGE = 2;
    private TextInputControl[] textInputs = {
            new ErrorTextField(), //address
            new ErrorTextField(), //phone
            new TextArea() //message
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addPaymentMethods();
        initInputs();
    }

    private void addPaymentMethods(){
        PaymentMethod[] values = PaymentMethod.values();
        ObservableList<String> items = paymentMethod.getItems();
        for(PaymentMethod method: values){
            items.add(method.toString());
        }
        paymentMethod.setValue(values[0].toString());
    }

    private void initInputs(){
        int rowStart = 1;
        int column = 1;
        // Remove error error styles from inputs if those styles are present
        for(int i=0; i<textInputs.length; i++){
            // Add inputs to the layout
            layout.add(textInputs[i],column,rowStart+i);
        }
        textInputs[MESSAGE].setMaxHeight(60);

        // Restrict input for the phone text box
        textInputs[PHONE].textProperty().addListener((observable,oldValue,newValue)->{
            // If it's not a digit
            if (!newValue.matches("\\d*")) {
                // replace all non digit chars with empty string
                textInputs[PHONE].setText(newValue.replaceAll("[^\\d]", ""));
            }
            // If the value is grater then 10 cut extra chars out
            if(newValue.length() > 10){
                textInputs[PHONE].setText(newValue.substring(0,10));
            }
        });
    }

    public String[] getInput(){
        Alert alert = new Alert(370,100);
        String[] output = new String[3];

        for(int i=0; i<textInputs.length ; i++){
            String input = textInputs[i].getText();
            // message is optional
            if(i != MESSAGE && input.equals("")) {
                alert.display("Input error","Please provide data in the text fields");
                ErrorTextField inputField = (ErrorTextField)textInputs[i];
                inputField.setError();
                inputField.requestFocus();
                return null;
            }
            output[i] = input;
        }
        // Check if phone is valid
        String phone = textInputs[PHONE].getText();
        if(!validPhone(phone)){
            String message = "The phone number you provided \"" + phone + "\" is not in valid format \n";
            message+= "Valid format 06[0-9] XXXXXXXX X = any digit \n";
            alert.display("Phone is not valid",message);
            ErrorTextField inputField = (ErrorTextField)textInputs[PHONE];
            inputField.setError();
            inputField.setText("");
            inputField.requestFocus();
            return null;
        }
        return output;
    }

    public boolean validPhone(String phone){
        return phone.matches("^06[0-9][0-9]{7}");
    }

    public PaymentMethod getPaymentMethod(){
        return PaymentMethod.valueOf(paymentMethod.getValue().toUpperCase());
    }

    public void clearInterface(){
        for (TextInputControl inputControl: textInputs){
            inputControl.setText("");
        }
        paymentMethod.setValue(paymentMethod.getItems().get(0));
    }
}
