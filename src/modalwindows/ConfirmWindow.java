package modalwindows;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ConfirmWindow extends ModalWindow {

    private boolean answer;

    public ConfirmWindow(){
        super();
        adjustWindow();
    }

    public ConfirmWindow(double width, double height){
        super(width,height);
        adjustWindow();
    }

    public void adjustWindow(){
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        yesBtn.setOnAction(e->{
            answer = true;
            window.close();
        });

        noBtn.setOnAction(e->{
            answer = false;
            window.close();
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(yesBtn,noBtn);

        layout.getChildren().add(hBox);
    }

    public boolean display(String title, String message){
        super.display(title,message);
        return answer;
    }
}
