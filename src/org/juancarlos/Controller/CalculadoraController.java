
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

        // Botón C
        if (entrada.equals("C")) {

            opcion1 = "";
            operador = "";
            opcion2 = "";

            pantalla.setText("0");

            calculoTerminado = false;

            return;
        }

        // Si terminó un cálculo y se introduce un número
        if (calculoTerminado && (entrada.matches("[0-9]") || entrada.equals("."))) {

            opcion1 = "";
            operador = "";
            opcion2 = "";

            calculoTerminado = false;
        }

        // Números y punto decimal
        if (entrada.matches("[0-9]") || entrada.equals(".")) {

            if (operador.isEmpty()) {

                // Evitar dos puntos decimales
                if (entrada.equals(".") && opcion1.contains(".")) {
                    return;
                }

                // Si empieza con punto, agregar 0
                if (opcion1.isEmpty() && entrada.equals(".")) {
                    opcion1 = "0";
                }

                opcion1 += entrada;

            } else {

                if (entrada.equals(".") && opcion2.contains(".")) {
                    return;
                }

                if (opcion2.isEmpty() && entrada.equals(".")) {
                    opcion2 = "0";
                }

                opcion2 += entrada;
            }

            actualizarPantalla(pantalla);
        }

        // Operadores
        else if (entrada.equals("+")
                || entrada.equals("-")
                || entrada.equals("*")
                || entrada.equals("/")
                || entrada.equals("%")
                || entrada.equals("^")) {

            if (opcion1.isEmpty()) {
                return;
            }

            operador = entrada;

            actualizarPantalla(pantalla);
        }

        // Raíz cuadrada
        else if (entrada.equals("√")) {

            if (opcion1.isEmpty()) {
                return;
            }

            operador = "√";

            actualizarPantalla(pantalla);
        }

        // Igual
        else if (entrada.equals("=")) {

            if (opcion1.isEmpty()) {
                return;
            }

            String resultado = "";

            try {

                if (operador.equals("+")) {

                    if (opcion2.isEmpty()) {
                        return;
                    }

                    resultado = resultadoSuma(opcion1, opcion2);

                } else if (operador.equals("-")) {

                    if (opcion2.isEmpty()) {
                        return;
                    }

                    resultado = resultadoResta(opcion1, opcion2);

                } else if (operador.equals("*")) {

                    if (opcion2.isEmpty()) {
                        return;
                    }

                    resultado = resultadoMulti(opcion1, opcion2);

                } else if (operador.equals("/")) {

                    if (opcion2.isEmpty()) {
                        return;
                    }

                    resultado = resultadoDivision(opcion1, opcion2);

                } else if (operador.equals("%")) {

                    if (opcion2.isEmpty()) {
                        return;
                    }

                    resultado = resultadoPorcentaje(opcion1, opcion2);

                } else if (operador.equals("^")) {

                    if (opcion2.isEmpty()) {
                        return;
                    }

                    resultado = resultadoPotencia(opcion1, opcion2);

                } else if (operador.equals("√")) {

                    resultado = resultadoRaizCuadrada(opcion1);

                } else {

                    return;
                }

                opcion1 = resultado;
                opcion2 = "";
                operador = "";

                calculoTerminado = true;

                actualizarPantalla(pantalla);

            } catch (Exception e) {

                opcion1 = "";
                opcion2 = "";
                operador = "";

                pantalla.setText("Error");

                calculoTerminado = true;
            }
        }
    }

    // Actualizar pantalla
    private void actualizarPantalla(Label pantalla) {

        if (opcion1.isEmpty()) {

            pantalla.setText("0");

        } else if (operador.isEmpty()) {

            pantalla.setText(opcion1);

        } else {

            pantalla.setText(
                    opcion1 + " " + operador + " " + opcion2
            );
        }
    }

    // SUMA
    private String resultadoSuma(String numeroUno, String numeroDos) {

        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);

        double suma = datoUno + datoDos;

        return formatearResultado(suma);
    }

    // RESTA
    private String resultadoResta(String numeroUno, String numeroDos) {

        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);

        double resta = datoUno - datoDos;

        return formatearResultado(resta);
    }

    // MULTIPLICACIÓN
    private String resultadoMulti(String numeroUno, String numeroDos) {

        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);

        double multiplicacion = datoUno * datoDos;

        return formatearResultado(multiplicacion);
    }

    // DIVISIÓN
    private String resultadoDivision(String numeroUno, String numeroDos) {

        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);

        if (datoDos == 0) {
            return "Error";
        }

        double division = datoUno / datoDos;

        return formatearResultado(division);
    }

    // RAÍZ CUADRADA
    private String resultadoRaizCuadrada(String numeroUno) {

        if (numeroUno == null || numeroUno.isEmpty()) {
            return "Error";
        }

        double numero = Double.parseDouble(numeroUno);

        if (numero < 0) {
            return "Error";
        }

        double raiz = Math.sqrt(numero);

        return formatearResultado(raiz);
    }

    // PORCENTAJE
    private String resultadoPorcentaje(String numeroUno, String numeroDos) {

        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);

        double porcentaje = datoUno * datoDos / 100;

        return formatearResultado(porcentaje);
    }

    // POTENCIA
    private String resultadoPotencia(String numeroUno, String numeroDos) {

        double datoUno = Double.parseDouble(numeroUno);
        double datoDos = Double.parseDouble(numeroDos);

        double potencia = Math.pow(datoUno, datoDos);

        return formatearResultado(potencia);
    }

    // Formatear resultados
    private String formatearResultado(double resultado) {

        if (Double.isNaN(resultado) || Double.isInfinite(resultado)) {
            return "Error";
        }

        // Si es un número entero, no mostrar .0
        if (resultado == Math.floor(resultado)) {
            return String.valueOf((long) resultado);
        }

        return String.valueOf(resultado);
    }
}




 
