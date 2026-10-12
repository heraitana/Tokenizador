
package org.example;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Tokenizador tokenizador = new Tokenizador();

        int opcionMenu = 0;

        while (opcionMenu != 1) {

            String[] opciones = {
                    "Salir",
                    "Analizar mensaje",
                    "Ingresar mensaje"
            };

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Analizador Léxico de Mensajes",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[1]
            );

            // Si se cierra la ventana, termina el programa.
            if (seleccion == JOptionPane.CLOSED_OPTION) {
                break;
            }

            opcionMenu = seleccion + 1;

            switch (opcionMenu) {

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Saliendo del sistema..."
                    );
                    break;

                case 2:
                    tokenizador.analizarCadena();
                    break;

                case 3:
                    tokenizador.ingresarCadena();
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Error: opción no válida."
                    );
                    break;
            }
        }
    }
}
