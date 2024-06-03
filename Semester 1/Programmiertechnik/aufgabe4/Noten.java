package aufgabe4;

/**
 * Die Klasse Noten hilft bei der Handhabung von Schulnoten.
 * <p>
 * Sie stellt Methoden bereit, um zu überprüfen,
 * ob eine Note in einem gültigen Format vorliegt,
 * Noten von String zu Double umzuwandeln, und zu entscheiden,
 * ob eine Note ausreichend ist,
 * um als bestanden zu gelten. Auch kann man mit ihrer Hilfe herausfinden,
 * welche von zwei Noten
 * besser oder schlechter ist.
 * </p>
 * <p>
 * In dieser Klasse werden Noten zwischen 1,0 (sehr gut)
 * und 5,0 (ungenügend) verarbeitet.
 * Noten außerhalb dieses Bereichs oder in falschem Format werden
 * nicht akzeptiert und führen
 * zu einer Fehlermeldung.
 * </p>
 * <p>
 * Man verwendet diese Klasse, um z.B. die beste
 * und die schlechteste Note in einer Liste von Noten
 * zu bestimmen oder um zu prüfen, ob jemand eine Prüfung bestanden hat.
 * </p>
 * @author Sofie Boxberger
 * @version 03.06.2024
 */

public final class Noten {
    private Noten() { }

//---------------------------------------Beste und Schlechteste Note eingeben
/** Die bestemoeglich vergebe Note. */
    public static final double BESTE = 1.0;
/** Die schlechtestmoegliche Note, die vergeben werden kann. */
    public static final double SCHLECHTESTE = 5.0; //

/**
 * Überprüft, ob die gegebene Notenangabe in einem zulässigen Format ist.
 * @param note Die zu überprüfende Note als String.
 * @return true, wenn das Format zulässig ist, sonst false.
 */
    public static boolean istZulaessig(String note) {
        // Methode Logik...
        if (note.length() != 3
            || !Character.isDigit(note.charAt(0))          //
            || (note.charAt(1) != '.' && note.charAt(1) != ',')
            || !Character.isDigit(note.charAt(2))) {
            return false;
        }
        //---------------------------------------------------Überprüfen

        switch (note.charAt(0)) {
        case '1':
        case '2':
        case '3':
            if (note.charAt(2) == '0'
                || note.charAt(2) == '3'
                || note.charAt(2) == '7') {
                return true;
            }
            break;
        case '4':
        case '5':
            if (note.charAt(2) == '0') {
                return true;
            }
            break;
        default:
            return false;
        }
        return false;
    }

/**
 * Konvertiert eine gültige Notenangabe als String in einen Double-Wert.
 * @param note Die zu konvertierende Note.
 * @return Die Note als Double-Wert.
 * @throws IllegalArgumentException wenn die Note ungültig ist.
 */
    public static double toDouble(String note) {
         // Methode Logik...
        if (!istZulaessig(note)) {
            throw new IllegalArgumentException("Ungültige Note: " + note);
        }
        return Double.parseDouble(note.replace(',', '.'));
    }
/**
 * Gibt die String-Darstellung einer Note zurück.
 * @param note Die Note, die konvertiert werden soll.
 * @return Die formatierte Note als String.
 * @throws IllegalArgumentException wenn die Note
 * außerhalb des gültigen Bereichs liegt.
 */
    public static String toString(double note) {
        // Methode Logik...
        if (note < BESTE || note > SCHLECHTESTE) {
            throw new IllegalArgumentException("Ungültige Note: " + note);
        }
        return String.format("%.1f", note);
    }
/**
 * Überprüft, ob eine gegebene Note ein Bestehen darstellt.
 * @param note Die zu überprüfende Note.
 * @return true, wenn die Note ein Bestehen darstellt, sonst false.
 */
    public static boolean istBestanden(double note) {
        // Methode Logik...
        return note <= 4.0;
    }
/**
 * Ermittelt die bessere von zwei gegebenen Noten.
 * @param note1 Die erste Note.
 * @param note2 Die zweite Note.
 * @return Die bessere der beiden Noten.
 */
    public static double bessere(double note1, double note2) {
         // Methode Logik...
        if (note1 < note2) {
            return note1;
        } else {
            return note2;
        }
    }
/**
 * Ermittelt die schlechtere von zwei gegebenen Noten.
 * @param note1 Die erste Note.
 * @param note2 Die zweite Note.
 * @return Die schlechtere der beiden Noten.
 */
    public static double schlechtere(double note1, double note2) {
         // Methode Logik...
        if (note1 > note2) {
            return note1;
        } else {
            return note2;
        }
    }
}
