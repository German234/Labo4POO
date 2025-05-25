package com.german.labo4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibroController implements Initializable {

    @FXML private TilePane cardsPane;
    @FXML private Button addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Libro ejemplo = new Libro(
                "Cuentos de los hermanos Grimm",
                "Wilhelm Grimm",
                "Editorial Random",
                "https://cdn.shopify.com/s/files/1/2482/2494/files/Cuentos_de_los_hermanos_Grimm_480x480.jpg?v=1629400827"
        );
        cardsPane.getChildren().add(createCard(ejemplo));

        addButton.setOnAction(e -> openAddDialog());
    }

    private void openAddDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/german/labo4/add-book-dialog.fxml")
            );
            VBox root = loader.load();

            AddBookDialogController dialogCtrl = loader.getController();
            dialogCtrl.setOnAdd(libro -> cardsPane.getChildren().add(createCard(libro)));

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setTitle("Agregar Libro");
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private VBox createCard(Libro libro) {
        VBox card = new VBox(10);
        card.setPrefWidth(180);
        card.setAlignment(Pos.TOP_LEFT);
        card.setPadding(new Insets(10));
        card.setStyle(
                "-fx-border-color: lightgray; " +
                        "-fx-border-width: 1; " +
                        "-fx-border-radius: 5; " +
                        "-fx-background-radius: 5; " +
                        "-fx-background-color: white;"
        );

        ImageView iv = new ImageView();
        iv.setFitWidth(200);
        iv.setFitHeight(250);
        iv.setPreserveRatio(true);
        if (libro.getImageURL() != null && !libro.getImageURL().isBlank()) {
            iv.setImage(new Image(libro.getImageURL(), true));
        }

        Label title      = new Label("Titulo: "+ libro.getTitulo());
        title.setWrapText(true);
        Label author     = new Label("Autor: "+ libro.getAutor());
        Label referencia = new Label("APA: "+libro.generarReferenciaAPA());
        referencia.setWrapText(true);
        referencia.setMaxWidth(card.getPrefWidth() - 20);

        card.getChildren().addAll(iv, title, author, referencia);
        return card;
    }
}
