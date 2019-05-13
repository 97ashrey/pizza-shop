package modalwindows;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class Alert extends ModalWindow {

    public Alert(){
        super();
        adjustWindow();
    }

    public Alert(double width, double height){
        super(width,height);
        adjustWindow();
    }

    private void adjustWindow(){
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e->window.close());

        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(closeButton);
    }
}
