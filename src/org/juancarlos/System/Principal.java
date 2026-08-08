/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.juancarlos.System;

import org.juancarlos.View.CalculadoraView;

/**
 *
 * @author informatica
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) {
        CalculadoraView calculadora = new CalculadoraView();

        Pane raiz = new Pane(calculadora.getView());

        Scene escena = new Scene(raiz, 266, 390);

        escenarioPrincipal.setTitle("Calculadora de Juan Carlos");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
