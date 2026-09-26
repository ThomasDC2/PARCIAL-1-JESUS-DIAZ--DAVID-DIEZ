package co.edu.uniquindio.poo.parcial1;

import co.edu.uniquindio.poo.parcial1.config.AplicacionRentCar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AplicacionRentCar aplicacion = new AplicacionRentCar();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/rentcar-view.fxml"));
        loader.setControllerFactory(aplicacion::crearControlador);
        Scene scene = new Scene(loader.load(), 640, 420);
        stage.setTitle("RentCar");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
