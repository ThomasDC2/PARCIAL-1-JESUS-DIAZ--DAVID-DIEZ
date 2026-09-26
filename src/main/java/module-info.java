module co.edu.uniquindio.poo.parcial1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.parcial1 to javafx.fxml;
    exports co.edu.uniquindio.poo.parcial1;
}