
package org.juancarlos.View;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    
    public CalculadoraView(){
        view = new VBox(15);
        view.setPadding(new Insets (15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #4A5D23;");
        
        pantalla = new Label("0");
        cuadroBotones = new GridPane();
                
        view.getChildren().addAll(pantalla, cuadroBotones);
        
        
    }
    
    public VBox getView(){
        return view;
    }
}
