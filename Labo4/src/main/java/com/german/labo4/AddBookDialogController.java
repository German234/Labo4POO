package com.german.labo4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddBookDialogController {

    @FXML private TextField tituloField;
    @FXML private TextField autorField;
    @FXML private TextField editorialField;
    @FXML private TextField imageURLField;
    @FXML private Button addBtn;
    @FXML private Label errorLabel;

    private java.util.function.Consumer<Libro> onAdd;

    public void setOnAdd(java.util.function.Consumer<Libro> onAdd) {
        this.onAdd = onAdd;
    }

    @FXML
    private void initialize() {
        addBtn.setOnAction(e -> {
            String titulo    = tituloField.getText().trim();
            String autor     = autorField.getText().trim();
            String editorial = editorialField.getText().trim();
            String imageUrl  = imageURLField.getText().trim();
            if (titulo.isEmpty() || autor.isEmpty() || editorial.isEmpty()) {
                errorLabel.setText("Todos los campos excepto URL son obligatorios.");
                return;
            }
            Libro libro = new Libro(titulo, autor, editorial, imageUrl);
            if (onAdd != null) onAdd.accept(libro);
            // Cerrar diálogo
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
    }
}