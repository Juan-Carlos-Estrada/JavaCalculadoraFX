
package org.juancarlos.Controller;

import javafx.scene.control.Label;

public class CalculadoraController {
    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public CalculadoraController() {

    }

    public void procesoDeEntrada(String entrada, Label pantalla) {
        if (entrada.equals("C")) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
            pantalla.setText("");
            return; 
        }
    
        if (calculoTerminado && entrada.matches("[0-9]")) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
        }
        calculoTerminado = false;

        if (entrada.matches("[0-9]")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pantalla);
        } 
        else if (entrada.equals("+") || entrada.equals("-")) {
            operador = entrada;
            actualizarPantalla(pantalla);
        } 
        
        else if (entrada.equals("/") || entrada.equals("*")) {
            operador = entrada;
                    actualizarPantalla(pantalla);
        } 
        else if (entrada.equals("%") || entrada.equals("√")) {
            operador = entrada;
            actualizarPantalla(pantalla);
        } 
        else if (entrada.equals("^")) {
            operador = entrada;
            actualizarPantalla(pantalla);
        } 
        
        else if (entrada.equals("=")) {
            if (operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
            } else if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
            } else if (operador.equals("*")) {
                opcion1 = resultadoMulti(opcion1, opcion2);
            }
                        else if (operador.equals("/")) {
                opcion1 = resultadoDivision(opcion1, opcion2);
            }
            else if (operador.equals("√")) {
                opcion1 = resultadoRaizCuadrada(opcion1);
                String numeroParaRaiz = opcion1.isEmpty() ? opcion2 : opcion1;
                opcion1 = resultadoRaizCuadrada(numeroParaRaiz);
            }
                        }    
            else if (operador.equals("%")) {
                opcion1 = resultadoPorcentaje(opcion1, opcion2);
            }
            else if (operador.equals("^")) {
                opcion1 = resultadoPotencia(opcion1, opcion2);
            }
            operador = "";
            opcion2 = "";
            calculoTerminado = true;
            actualizarPantalla(pantalla);
    }
    
    
   
    private void actualizarPantalla(Label pantalla) {
        if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }

    private String resultadoSuma(String numeroUno, String numeroDos) {
        String resultado;
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        int suma = datoUno + datoDos;

        return resultado = String.valueOf(suma);
    }

     private String resultadoResta(String numeroUno, String numeroDos) {
        String resultado;
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        int resta = datoUno - datoDos;

        return resultado = String.valueOf(resta);
    }

 private String resultadoMulti(String numeroUno, String numeroDos) {
        String resultado;
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        int multiplicacion = datoUno * datoDos;

        return resultado = String.valueOf(multiplicacion);
    }

  private String resultadoDivision(String numeroUno, String numeroDos) {
        String resultado;
        double datoUno = Integer.parseInt(numeroUno);
        double datoDos = Integer.parseInt(numeroDos);
        double division = datoUno / datoDos;

        return resultado = String.valueOf(division);
    }

private String resultadoRaizCuadrada(String numeroUno) {
    if (numeroUno == null || numeroUno.isEmpty()) {
        return ""; 
    }
    double numero = Double.parseDouble(numeroUno);
    if (numero < 0) {
        return "Error";
    }
    if (numero == 0) {
        return "0.0";
    }
    double estimacion = numero;
    double estimacionAnterior = 0;
    double tolerancia = 0.000001;
    while (true) {
        estimacionAnterior = estimacion;
        estimacion = (estimacion + (numero / estimacion)) / 2.0;
        double diferencia = estimacion - estimacionAnterior;
        if (diferencia < 0) {
            diferencia = diferencia * -1; 
        }
        if (diferencia < tolerancia) {
            break;
        }
    }
    return String.valueOf(estimacion);
}

  private String resultadoPorcentaje(String numeroUno, String numeroDos) {
        String resultado;
        double datoUno = Integer.parseInt(numeroUno);
        double datoDos = Integer.parseInt(numeroDos);
        double porcentaje = datoUno * datoDos;
        double resultporcentaje = porcentaje / 100;
        return resultado = String.valueOf(resultporcentaje);
    }

   private String resultadoPotencia(String numeroUno, String numeroDos) {
        String resultado;
        double datoUno = Integer.parseInt(numeroUno);
        double datoDos = Integer.parseInt(numeroDos);
        double potencia = Math.pow(datoUno, datoDos);

        return resultado = String.valueOf(potencia);
    }
}




 
