module com.german.labo4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.german.labo4 to javafx.fxml;
    exports com.german.labo4;
}