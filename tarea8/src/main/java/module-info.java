module org.example.tarea8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires objectdb;
    requires javax.persistence;

    opens org.example.tarea8 to javafx.fxml, objectdb;
    exports org.example.tarea8;
}