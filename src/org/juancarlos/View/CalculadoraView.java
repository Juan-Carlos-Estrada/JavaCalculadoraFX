
package org.juancarlos.View;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
    
    public CalculadoraView(){
        controlador = new CalculadoraController();
        view = new VBox(15);
        view.setPadding(new Insets (15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #4A5D23;");
        
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);
        
        
        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);
        
        // primer boton
        Button btnPunto = nuevoBotonOperacion (".");
        Button btnCero = nuevoBoton("0");
        Button btnUno = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnMas = nuevoBotonOperacion ("+");
        Button btnIgual = nuevoBotonOperacion ("=");
        Button btnClear = nuevoBotonOperacion ("C");
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnMenos = nuevoBotonOperacion ("-");
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
       
        Button btnMultiplicacion = nuevoBotonOperacion ("*");
        Button btnNueve = nuevoBoton("9");
        Button btnDivision = nuevoBotonOperacion ("/");
        Button btnRaizCua = nuevoBotonOperacion ("√");
        
        
//agregarlo al cuadro botones

        cuadroBotones.add(btnPunto, 2, 4);
        cuadroBotones.add(btnCero, 1, 4);
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);
        cuadroBotones.add(btnIgual, 3, 4);
        cuadroBotones.add(btnClear, 0, 4 );
        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2); 
        cuadroBotones.add(btnMenos, 3, 2); 
        
        cuadroBotones.add(btnSiete, 0, 1); 
        cuadroBotones.add(btnOcho, 1, 1); 
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnMultiplicacion, 3, 1);
        cuadroBotones.add(btnDivision, 3, 0);
        cuadroBotones.add(btnRaizCua, 2, 0);
        view.getChildren().addAll(pantalla, cuadroBotones);
    }
    
    
    public VBox getView(){
        return view;
    }

    private Button nuevoBoton (String texto){
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color:#6BBE23; -fx-text-fill:white; -ft-background-radius:5px; -fx-cursor: hand;");
        
                    btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #4c700b; -fx-text-fill: white;");
            btn.setTranslateY(2);
    }); 

        btn.setOnMouseReleased(e -> {
         btn.setStyle("-fx-background-color:#6BBE23; -fx-text-fill: white;");
         btn.setTranslateY(0);
    });
        
       btn.setOnAction(e -> controlador.procesoDeEntrada(texto,  pantalla) );
        return btn;
    
    }    

     private Button nuevoBotonOperacion (String texto){
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color:#c9c53a; -fx-text-fill:white; -ft-background-radius:5px; -fx-cursor: hand;");
        
                    btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #8f8c28; -fx-text-fill: white;");
            btn.setTranslateY(2);
    }); 

        btn.setOnMouseReleased(e -> {
         btn.setStyle("-fx-background-color:#c9c53a; -fx-text-fill: white;");
         btn.setTranslateY(0);
    });
        
       btn.setOnAction(e -> controlador.procesoDeEntrada(texto,  pantalla) );
        return btn;
    
    }    
    
}
