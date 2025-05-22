package com.german.labo4;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class LibroController {

    @FXML private TilePane cardsPane;

    @FXML
    private void onAgregarLibro() {

        TextInputDialog dlg1 = new TextInputDialog();
        dlg1.setTitle("Agregar Libro");
        dlg1.setHeaderText("Ingrese el título:");
        dlg1.setContentText("Título:");
        Optional<String> tituloOpt = dlg1.showAndWait();
        if (tituloOpt.isEmpty() || tituloOpt.get().isBlank()) return;
        String titulo = tituloOpt.get();

        TextInputDialog dlg2 = new TextInputDialog();
        dlg2.setTitle("Agregar Libro");
        dlg2.setHeaderText("Ingrese el autor:");
        dlg2.setContentText("Autor:");
        Optional<String> autorOpt = dlg2.showAndWait();
        if (autorOpt.isEmpty() || autorOpt.get().isBlank()) return;
        String autor = autorOpt.get();

        TextInputDialog dlg3 = new TextInputDialog();
        dlg3.setTitle("Agregar Libro");
        dlg3.setHeaderText("Ingrese la editorial:");
        dlg3.setContentText("Editorial:");
        Optional<String> editorialOpt = dlg3.showAndWait();
        if (editorialOpt.isEmpty() || editorialOpt.get().isBlank()) return;
        String editorial = editorialOpt.get();

        TextInputDialog dlg4 = new TextInputDialog();
        dlg4.setTitle("Agregar Libro");
        dlg4.setHeaderText("Ingrese la URL de la portada (opcional):");
        dlg4.setContentText("URL:");
        Optional<String> urlOpt = dlg4.showAndWait();
        String imageUrl = urlOpt.filter(u -> !u.isBlank()).orElse("");

        Libro nuevo = new Libro(titulo, autor, editorial);
        cardsPane.getChildren().add(createCard(nuevo, imageUrl));
    }

    private VBox createCard(Libro libro, String imageUrl) {
        ImageView iv = new ImageView();
        iv.setFitWidth(100);
        iv.setFitHeight(111);
        iv.setPreserveRatio(true);
        if (!imageUrl.isBlank()) {
            iv.setImage(new Image(imageUrl, true));
        }

        Label title     = new Label(libro.getTitulo());
        Label author    = new Label(libro.getAutor());
        Label referencia = new Label(libro.generarReferenciaAPA());
        referencia.setWrapText(true);

        VBox card = new VBox(10, iv, title, author, referencia);
        card.setAlignment(Pos.BOTTOM_LEFT);
        card.setPadding(new Insets(10));
        card.setStyle(
                "-fx-border-color: lightgray; " +
                        "-fx-border-width: 1; " +
                        "-fx-border-radius: 5; " +
                        "-fx-background-radius: 5; " +
                        "-fx-background-color: white;"
        );
        return card;
    }
}
