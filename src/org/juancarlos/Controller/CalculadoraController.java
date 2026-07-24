
package org.juancarlos.Controller;

import javafx.scene.control.Label;

public class CalculadoraController {
   private String opcion1 = "";
   private String operador = "";
   private String opcion2 = "";
   private boolean calculoTerminado = true;
   
   public CalculadoraController(){
  
   
   
   }
  
public void procesoDeEntrada(String entrada, Label pantalla){
    if (entrada.matches("[0-9]")){
        if(operador.isEmpty()){
            opcion1 += entrada; 
        } else {
            opcion2 += entrada; 
        }
    } 
    else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*")) {
        if (!opcion1.isEmpty()) {
            operador = entrada;
        }
    }
        actualizarPantalla(pantalla);
}
   
private void actualizarPantalla(Label pantalla){
    if (operador.isEmpty()){
        pantalla.setText(opcion1);
    } else {
        pantalla.setText(opcion1 + " " + operador + " " + opcion2);
    }
}
   
}
