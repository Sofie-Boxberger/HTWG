// Klausurergebnis.java
package aufgabe4;

import java.util.Locale;
import java.util.Scanner;

/**
 * Klausurergebnis erstellt eine Notenstatistik.
 * <p>
 * Das Programm liest Noten als Strings ein und bestimmt die beste und
 * die schlechteste Note, den Durchschnitt der Bestandenen sowie
 * die Durchfallquote in Prozent.
 * Das Programm ber&uuml;cksichtigt dabei nur die laut Noten.istZulaessig
 * erlaubten Noten. Andere Noten werden unter Ausgabe einer Warnung ignoriert.
 * Welche Noten besser und schlechter sind, welche als bestanden oder
 * durchgefallen gelten und wie die String-Darstellung der Noten aussieht,
 * wird mit Methoden der Klasse Noten bestimmt.
 * </p>
 * Das Programm gibt als Klausurergebnis folgende Werte aus:
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote</li>
 * </ul>
 *
 * @author Sofie Boxberger
 * @version 28.05.2024
 */
public final class Klausurergebnis {
    private Klausurergebnis() {
    }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);

        int passed = 0;
        int failed = 0;
        int noteSum = 0;
        final double x = 100.0;
        double average = 0.0;
        double best = Noten.SCHLECHTESTE;
        double worst = Noten.BESTE;

    //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();

        //---------------------------------------------- Eingabe pruefen
            if (!Noten.istZulaessig(note)) {
                System.out.println("Unzulaessige Note " + note + " wird "
                                   + "ignoriert!");
                continue;
            }
            //------------------------------------------------ Note erfassen

            double noteCurrent = Noten.toDouble(note);

            if (Noten.istBestanden(noteCurrent)) {
                passed++;
                average += noteCurrent;
            } else {
                failed++;
            }

            best = Noten.bessere(best, noteCurrent);
            worst = Noten.schlechtere(worst, noteCurrent);
        } // while

        //------------------------------------------ Notenstatistik ausgeben

        double averagePassed = (double) average / (double) passed;
        double averageFailed = (double) failed / (passed + failed) * x;

        System.out.println("Anzahl beruecksichtigter Noten: "
                           + (passed + failed));
        System.out.println("Anzahl Bestandene: " + passed);
        System.out.println("Beste Note: " + Noten.toString(best));
        System.out.println("Schlechteste Note: " + Noten.toString(worst));
        System.out.println("Durchschnitt Bestandene: " + String.format("%.1f",
                averagePassed));
        System.out.println("Durchfallquote: " + String.format("%.1f%%",
                averageFailed));
    } // main
}
