package aufgabe4;

public final class Noten {
    private Noten() { } 

//---------------------------------------------------Beste und Schlechteste Note eingeben
    public static final double BESTE = 1.0;
    public static final double SCHLECHTESTE = 5.0;

    public static boolean istZulaessig(String note) { 
      
        if (note.length() != 3
            || !Character.isDigit(note.charAt(0))          //
            || (note.charAt(1) != '.' && note.charAt(1) != ',')
            || !Character.isDigit(note.charAt(2))) {
            return false;
        }
        //---------------------------------------------------Überprüfen

        switch (note.charAt(0)) {
        case 1:
        case 2:
        case 3:
            if (note.charAt(2) == '0'
                || note.charAt(2) == '3'
                || note.charAt(2) == '7') {
                return true;
            }
            break;
        case 4:
        case 5:
            if (note.charAt(2) == '0') {
                return true;
            }
            break;
        default:
            return false;
        }
        return false;
    }

    public static double toDouble(String note) {
        if (!istZulaessig(note)) {
            throw new IllegalArgumentException("Ungültige Note: " + note);
        }
        return Double.parseDouble(note.replace(',', '.'));
    }

    public static String toString(double note) {
        if (note < BESTE || note > SCHLECHTESTE) {
            throw new IllegalArgumentException("Ungültige Note: " + note);
        }
        return String.format("%.1f", note);
    }

    public static boolean istBestanden(double note) {
        return note <= 4.0; 
    }

    public static double bessere(double note1, double note2) {
        if (note1 < note2) {
            return note1;
        } else {
            return note2;
        }
    }

    public static double schlechtere(double note1, double note2) {
        if (note1 > note2) {
            return note1;
        } else {
            return note2;
        }
    }
}