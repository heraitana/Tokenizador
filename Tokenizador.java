
package org.example;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Tokenizador {

    private String cadenaImpresion;

    public Tokenizador() {
        cadenaImpresion = "";
    }

    public void ingresarCadena() {

        String entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese un mensaje normal:\n\n"
                        + "Ejemplo: Felicidades María, tienes 20 años!"
        );

        if (entrada == null) {
            return;
        }

        if (entrada.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se ingresó ningún mensaje."
            );
            return;
        }

        cadenaImpresion = entrada;

        JOptionPane.showMessageDialog(
                null,
                "Mensaje guardado correctamente:\n\n"
                        + cadenaImpresion
        );
    }

    public ArrayList<Nodo> tokenizar() {

        ArrayList<Nodo> tokens = new ArrayList<>();

        int i = 0;

        while (i < cadenaImpresion.length()) {

            char caracterActual = cadenaImpresion.charAt(i);
            //1
            // Ignorar espacios "isWhitespace
            if (Character.isWhitespace(caracterActual)) {
                i++;
            }

            //2
            // Identificar palabras.
            else if (Character.isLetter(caracterActual)) {

                StringBuilder palabra = new StringBuilder();

                while (i < cadenaImpresion.length()
                        && Character.isLetter(
                        cadenaImpresion.charAt(i))) {

                    palabra.append(cadenaImpresion.charAt(i));
                    i++;
                }

                tokens.add(new Nodo(
                        palabra.toString(),
                        "PALABRA"
                ));
            }
            //3
            // Identificar números.
            else if (Character.isDigit(caracterActual)) {

                StringBuilder numero = new StringBuilder();

                while (i < cadenaImpresion.length()
                        && Character.isDigit(
                        cadenaImpresion.charAt(i))) {

                    numero.append(cadenaImpresion.charAt(i));
                    i++;
                }

                tokens.add(new Nodo(
                        numero.toString(),
                        "NUMERO"
                ));
            }

            // Identificar signos de puntuación.
            else if (esPuntuacion(caracterActual)) {

                tokens.add(new Nodo(
                        String.valueOf(caracterActual),
                        "PUNTUACION"
                ));

                i++;
            }

            // Avanzar si el carácter no pertenece a ninguna de las cuatro categorías.
            else {
                i++;
            }
        }

        return tokens;
    }

    private boolean esPuntuacion(char caracterActual) {

        int tipo = Character.getType(caracterActual);

        return tipo == Character.CONNECTOR_PUNCTUATION
                || tipo == Character.DASH_PUNCTUATION
                || tipo == Character.START_PUNCTUATION
                || tipo == Character.END_PUNCTUATION
                || tipo == Character.INITIAL_QUOTE_PUNCTUATION
                || tipo == Character.FINAL_QUOTE_PUNCTUATION
                || tipo == Character.OTHER_PUNCTUATION;
    }

    public void analizarCadena() {

        if (cadenaImpresion.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Primero ingrese un mensaje."
            );
            return;
        }

        ArrayList<Nodo> tokens = tokenizar();

        if (tokens.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se encontraron tokens."
            );
            return;
        }

        // Guardar los tokens en la pila.
        Pila pila = new Pila();

        for (Nodo token : tokens) {
            pila.push(token.getValor(), token.getTipo());
        }

        // Extraer los tokens de la pila.
        ArrayList<Nodo> tokensInvertidos = new ArrayList<>();

        while (!pila.estaVacia()) {
            tokensInvertidos.add(pila.pop());
        }

        StringBuilder resultado = new StringBuilder();

        resultado.append("Mensaje: ")
                .append(cadenaImpresion)
                .append("\n\nTokens identificados:\n\n");

        // Mostrar los tokens en el orden original.
        for (int i = tokensInvertidos.size() - 1; i >= 0; i--) {

            Nodo token = tokensInvertidos.get(i);

            resultado.append(token.getValor())
                    .append(" -> ")
                    .append(token.getTipo())
                    .append("\n");
        }

        resultado.append("\nTotal de tokens: ")
                .append(tokens.size());

        JOptionPane.showMessageDialog(
                null,
                resultado.toString(),
                "Resultado del análisis léxico",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
