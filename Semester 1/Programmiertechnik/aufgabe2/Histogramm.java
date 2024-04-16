// Histogramm.java
package aufgabe2;

import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author TODO: Name eintragen
 * @version TODO: Datum eintragen
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {

        /* TODO: (1) hier ein Feld von Zaehlern definieren */
        final int arraySize = 6;
        final int replace = 5;
        int[]counter = {0, 0, 0, 0, 0, 0};

        //---------------------------------------------------- Zahlen einlesen
        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D/Strg-Z):");

        while (EINGABE.hasNextInt()) {
            int number = EINGABE.nextInt();

            /* TODO: (2) hier Anweisungen fuer das
                         Pruefen und Zaehlen der Eingabe schreiben */
            if (number > 0 && number <= arraySize) {
             ++counter[number - 1];
            } else {
            System.out.println("Ungültig. Versuchs nochmal");
            }
                    


        }

        //------------------------------------------------ Histogramm ausgeben

        /* TODO: (3) hier Anweisungen fuer die Histogrammausgabe schreiben */
        System.out.println("Histogramm:");
        for (int i = 0; i < counter.length; ++i) {
            for (int j = 1; j < counter[i] + 1; ++j) {
                if (j % replace == 0) {
                    System.out.print("$");
                } else {
                    System.out.printf("%d", i + 1);
                }
            }
            System.out.printf(" (%d)%n", counter[i]);
        }
    }
}    


