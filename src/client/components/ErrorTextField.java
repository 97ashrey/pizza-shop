package client.components;

import javafx.scene.control.TextField;

public class ErrorTextField extends TextField {

    public ErrorTextField(){
        super();
        setOnKeyPressed(e->{
            if(this.getStyle().contains(errorStyle)){
                removeErrorOnInput();
            }
        });
    }

    String errorStyle = "-fx-focus-color: red;\n" +
                        "-fx-faint-focus-color: #ff000022;";

    public void setError(){
        this.setStyle(errorStyle);
    }


    public void removeErrorOnInput(){
        this.setStyle(null);
    }
}
