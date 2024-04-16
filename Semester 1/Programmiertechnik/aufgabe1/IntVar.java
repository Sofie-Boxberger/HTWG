// IntVar.java

package aufgabe1;

import java.util.Scanner;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Sofie Boxberger
 * @version 05.04.2024
 */
public final class IntVar {
    private IntVar() { }

    private static final Scanner INPUT = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        //Definieren von min und max
        final int min = Integer.MIN_VALUE;
        final int max = Integer.MAX_VALUE;

        //Definieren der beiden Rechenvariablen
        int x = 0;
        int y = 0;

        //Zahleneingabe
        while (true) {
            System.out.printf("Zwei ganze Zahlen zwischen "
                + "%d und %d eingeben:%n", min, max);

            x = INPUT.nextInt();

            y = INPUT.nextInt();

            break;
        }

        System.out.println(Integer.toBinaryString(x));

        //Ausgabe der zwei Zahlen als Oktal, Dezimal und Hex
        System.out.printf("%o ist oktal %d und hexadezimal %x%n", x, x, x);
        System.out.printf("%o ist oktal %d und hexadezimal %x%n", y, y, y);

        // Berechnung des Ergebnis

        System.out.println(Integer.toBinaryString(x + y));
        int result = 0;
        System.out.printf("%d + %d ist %d%n", x, y, x + y);
        System.out.printf("%d - %d ist %d%n", x, y, x - y);
        System.out.printf("%d * %d ist %d%n", x, y, x * y);
        System.out.printf("%d / %d ist %d%n", x, y, x / y);
        System.out.printf("%d %% %d ist %d%n", x, y, x % y);
        System.out.printf("%d == %d ist %b%n", x, y, x == y);
        System.out.printf("%d != %d ist %b%n", x, y, x != y);
        System.out.printf("%d < %d ist %b%n", x, y, x < y);
        System.out.printf("%d <= %d ist %b%n", x, y, x <= y);
        System.out.printf("%d > %d ist %b%n", x, y, x > y);
        System.out.printf("%d >= %d ist %b%n", x, y, x >= y);
    }
}