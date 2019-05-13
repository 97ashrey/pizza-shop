package modalwindows;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class ModalWindow {

    protected Label messageLabel;
    protected Stage window;
    protected VBox layout;
    protected Scene scene;

    protected double height;
    protected double width;

    public ModalWindow(){
        this.width = 350;
        this.height = 100;
        makeWindow(width,height);
    }

    public ModalWindow(double width,double height){
        this.width = width;
        this.height = height;
        makeWindow(width,height);
    }

    private void makeWindow(double width,double height){
        this.window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        HBox outerLayout = new HBox();
        outerLayout.setPadding(new Insets(10,10,10,10));;
        outerLayout.setAlignment(Pos.CENTER);

        messageLabel = new Label();
        messageLabel.setAlignment(Pos.CENTER);
        messageLabel.setTextAlignment(TextAlignment.CENTER);
        HBox labelContainer = new HBox();
        labelContainer.setAlignment(Pos.CENTER);
        labelContainer.getChildren().add(messageLabel);


        layout = new VBox();
        layout.setSpacing(10);
        layout.getChildren().add(labelContainer);


        outerLayout.getChildren().add(layout);
        Scene scene = new Scene(outerLayout,width,height);
        window.setScene(scene);
    }

    public boolean display(String title, String message){
        window.setTitle(title);
        messageLabel.setText(message);
        window.showAndWait();
        return false;
    }
}
