// Notenstatistik.java
package aufgabe3;

import java.util.Locale;
import java.util.Scanner;

/**
 * erstellt eine Notenstatistik.
 * Das Programm erwartet Pr&uuml;fungsnoten im Format
 * Ganze,Zehntel oder Ganze.Zehntel,
 * wobei <code>Ganze</code> und <code>Zehntel</code> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
 * ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestanden, nur die 5,0 als durchgefallen.
 * </p>
 *
 * @author Sofie Boxberger
 * @version 10.05.2024
 */
public final class Notenstatistik {
    private Notenstatistik() { }

    private static final Scanner INPUT = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        //Definieren der Werte, welche wir zur Ausgabe benötigen
        double worstGrade = 1.0;
        double bestGrade = 5.0;
        double averageGrade = 0.0;
        int validGrades = 0;
        int passedGrades = 0;

        //Noten einlesen
        System.out.println("Noten Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben"
                           + "(Ende mit Strg-D/Strg-Z):");

        //User Input auslesen
        while (INPUT.hasNext()) {
            String grade = INPUT.next();

            //Note richtig?
            if (grade.length() != 3
                    || !Character.isDigit(grade.charAt(0))
                    || (grade.charAt(1) != ',' && grade.charAt(1) != '.')
                    || !Character.isDigit(grade.charAt(2))) {
                System.out.println("Note " + grade
                                   + " wird wegen Formatfehler ignoriert!");
                continue;
            }

            final int beforeComma =
                Character.getNumericValue(grade.charAt(0));
            final int afterComma =
                Character.getNumericValue(grade.charAt(2));

            switch (afterComma) {
            case 3:
            case 7:
                if (beforeComma > 3) {
                    System.out.println("Note " + grade
                                        + " wird wegen Nachkommastelle "
                                        + afterComma
                                        + " ignoriert!");
                    continue;
                }
            case 0:
                if (beforeComma < 1
                        || beforeComma > 5) {
                    System.out.println("Note " + grade
                                        + " wird wegen Vorkommastelle "
                                        + afterComma
                                        + " ignoriert!");
                    continue;
                }

                break;
            default:
                System.out.println("Note " + grade
                                    + " wird wegen Nachkommastelle "
                                    + afterComma
                                    + " ignoriert!");
                continue;
            }



            //Daten
            final double transformed = beforeComma
                                       + (double) afterComma / 10.0;

            if (transformed > worstGrade) {
                worstGrade = transformed;
            }
            if (transformed < bestGrade) {
                bestGrade = transformed;
            }

            validGrades++;

            if (beforeComma < 5) {
                passedGrades++;
                averageGrade += transformed;
            }
        } // while
        //Ausgabe Notenstatistik

        final double failureRate =
            ((double) (validGrades - passedGrades)
             / (double) validGrades) * 100.0;

        averageGrade =
            averageGrade / (double) passedGrades;

        System.out.println("\nAnzahl beruecksichtigter Noten: "
                           + validGrades);
        System.out.println("Anzahl Bestandene: " + passedGrades);

        if (validGrades > 0) {
            System.out.println("Beste Note: "
                               + String.format("%.1f", bestGrade));
            System.out.println("Schlechteste Note: "
                               + String.format("%.1f", worstGrade));
            System.out.println("Durchschnitt Bestandene: "
                               + String.format("%.1f", averageGrade));
            System.out.println("Durchfallquote: "
                               + String.format("%.1f", failureRate) + "%");
        }
    } // main
}
