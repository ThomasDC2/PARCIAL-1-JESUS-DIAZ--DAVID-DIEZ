module co.edu.uniquindio.poo.parcial1 {
    requires javafx.controls;
    requires javafx.fxml;


    exports co.edu.uniquindio.poo.parcial1;
    exports co.edu.uniquindio.poo.parcial1.model;
    opens co.edu.uniquindio.poo.parcial1.controller to javafx.fxml;
}
