package sim.bdeb.qc.ca.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class JeuxBoiteAuxLettres extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox(900);
        Scene scene = new Scene(root, 900, 580);

        Image iconFenetre = new Image("journal.png");
        stage.getIcons().add(iconFenetre);
        stage.setTitle("Camelot à vélo");
        stage.setScene(scene);
        stage.show();
    }
}
