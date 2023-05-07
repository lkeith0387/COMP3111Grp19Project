package src.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main class starts the application.
 */
public class Main extends Application {

    public static Stage stage;
    public static Scene scene;

    /**
     * Creates the primary stage for this application.
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage=primaryStage;
         scene=new Scene(FXMLLoader.load(getClass().getResource("/ppc1.fxml")));
       stage.setScene(scene);
        stage.show();
    }
}
