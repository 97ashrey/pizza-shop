package components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class Title extends HBox {
    private StringProperty title = new SimpleStringProperty("");
    Label label;

    public Title(){
        label = new Label();
        this.setStyle(titleStyle);
        this.getChildren().add(label);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.setVisible(true);
    }

    private String titleStyle = "-fx-font-size: 20px;\n" +
                                "-fx-font-weight: bold;";

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
        label.setText(title);
    }
}
