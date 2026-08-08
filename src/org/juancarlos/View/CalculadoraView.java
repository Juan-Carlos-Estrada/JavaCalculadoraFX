
package org.juancarlos.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.juancarlos.Controller.CalculadoraController;

public class CalculadoraView {

    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;

    private CalculadoraController controlador;

    public CalculadoraView() {

        controlador = new CalculadoraController();

        // Contenedor principal
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #1E1E2E;");

        // Pantalla
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);

        pantalla.setStyle(
                "-fx-background-color: #2A2A3C;" +
                "-fx-text-fill: #CDD6F4;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 0 10 0 10;"
        );

        // Cuadro de botones
        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);

        // Botones numéricos
        Button btnPunto = nuevoBoton(".");
        Button btnCero = nuevoBoton("0");
        Button btnUno = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");

        // Operadores
        Button btnMas = nuevoBotonOperacion("+");
        Button btnMenos = nuevoBotonOperacion("-");
        Button btnMultiplicacion = nuevoBotonOperacion("*");
        Button btnDivision = nuevoBotonOperacion("/");
        Button btnRaiz = nuevoBotonOperacion("√");
        Button btnPorcentaje = nuevoBotonOperacion("%");
        Button btnPotencia = nuevoBotonOperacion("^");

        // Botones especiales
        Button btnIgual = nuevoBotonOperacion2("=");
        Button btnClear = nuevoBotonOperacion2("C");

        // Posición de botones
        cuadroBotones.add(btnPotencia, 0, 0);
        cuadroBotones.add(btnPorcentaje, 1, 0);
        cuadroBotones.add(btnRaiz, 2, 0);
        cuadroBotones.add(btnDivision, 3, 0);

        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnMultiplicacion, 3, 1);

        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMenos, 3, 2);

        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);

        cuadroBotones.add(btnClear, 0, 4);
        cuadroBotones.add(btnCero, 1, 4);
        cuadroBotones.add(btnPunto, 2, 4);
        cuadroBotones.add(btnIgual, 3, 4);

        // Agregar pantalla y botones
        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }

    // Botones numéricos
    private Button nuevoBoton(String texto) {

        Button btn = new Button(texto);

        btn.setPrefSize(50, 50);

        btn.setStyle(
                "-fx-background-color: #313244;" +
                "-fx-text-fill: #CDD6F4;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"
        );

        btn.setOnMousePressed(e -> {
            btn.setStyle(
                    "-fx-background-color: #45475A;" +
                    "-fx-text-fill: #FFFFFF;" +
                    "-fx-background-radius: 10px;"
            );

            btn.setTranslateY(2);
        });

        btn.setOnMouseReleased(e -> {
            btn.setStyle(
                    "-fx-background-color: #313244;" +
                    "-fx-text-fill: #CDD6F4;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-cursor: hand;"
            );

            btn.setTranslateY(0);
        });

        btn.setOnAction(e ->
                controlador.procesoDeEntrada(texto, pantalla)
        );

        return btn;
    }

    // Botones de operaciones
    private Button nuevoBotonOperacion(String texto) {

        Button btn = new Button(texto);

        btn.setPrefSize(50, 50);

        btn.setStyle(
                "-fx-background-color: #458588;" +
                "-fx-text-fill: #FFFFFF;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"
        );

        btn.setOnMousePressed(e -> {
            btn.setStyle(
                    "-fx-background-color: #689D6A;" +
                    "-fx-text-fill: #FFFFFF;" +
                    "-fx-background-radius: 10px;"
            );

            btn.setTranslateY(2);
        });

        btn.setOnMouseReleased(e -> {
            btn.setStyle(
                    "-fx-background-color: #458588;" +
                    "-fx-text-fill: #FFFFFF;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-cursor: hand;"
            );

            btn.setTranslateY(0);
        });

        btn.setOnAction(e ->
                controlador.procesoDeEntrada(texto, pantalla)
        );

        return btn;
    }

    // Botones C e =
    private Button nuevoBotonOperacion2(String texto) {

        Button btn = new Button(texto);

        btn.setPrefSize(50, 50);

        btn.setStyle(
                "-fx-background-color: #D65D0E;" +
                "-fx-text-fill: #FFFFFF;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"
        );

        btn.setOnMousePressed(e -> {
            btn.setStyle(
                    "-fx-background-color: #FE8019;" +
                    "-fx-text-fill: #FFFFFF;" +
                    "-fx-background-radius: 10px;"
            );

            btn.setTranslateY(2);
        });

        btn.setOnMouseReleased(e -> {
            btn.setStyle(
                    "-fx-background-color: #D65D0E;" +
                    "-fx-text-fill: #FFFFFF;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-cursor: hand;"
            );

            btn.setTranslateY(0);
        });

        btn.setOnAction(e ->
                controlador.procesoDeEntrada(texto, pantalla)
        );

        return btn;
    }
}