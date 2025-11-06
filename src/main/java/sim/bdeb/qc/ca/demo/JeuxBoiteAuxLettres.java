package sim.bdeb.qc.ca.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class JeuxBoiteAuxLettres extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox(900);
        Scene scene = new Scene(root, 900, 580);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
