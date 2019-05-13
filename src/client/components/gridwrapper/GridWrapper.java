package client.components.gridwrapper;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class GridWrapper extends GridPane{

    public GridWrapper() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "grid-wrapper.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
