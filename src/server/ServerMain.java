package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.serverlogic.Server;

public class ServerMain extends Application{

    private Server server;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("index.fxml"));
        Parent root = loader.load();
        IndexController controller = loader.getController();
        primaryStage.setTitle("Pizza shop server");
        Scene scene = new Scene(root, 1024, 400);
        scene.getStylesheets().add("server/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e ->{
            server.shutDown();
        });

        // START SERVER
        server = new Server(controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
