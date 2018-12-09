/**
 * Einfaches Streichhoelzerspiel
 * Es gibt eine Menge N an Streichhoelzern, abwechselnd nimmt der Computer und <br>
 * der menschliche Spieler jeweils 1-3 Hoelzer weg, bis keine uebigbleiben. <br>
 * Der Computer  gewinnt, wenn er N vorgeben oder selbst anfangen darf. <br>
 * @author Udo Rink @link{'mailto:udo.rink@th-brandenburg.de'}
 * @version 1.0
 *
 *
 */
package streichhoelzerspiel;
import java.util.Scanner;
public class Streichhoelzerspiel {
    Scanner scan = new Scanner(System.in);
    /**
     * Methode gibt zurueck, vielviel Streichhoelzer der Computer nimmt
     * @param anzahlStreichhoelzer Anzahl der Streichhoelzer
     * @return int Wert, vielviel Streichhoelzer der Computer nimmt
     */
    int computerZug( int anzahlStreichhoelzer) {
        int anzahlComputerNimmt;
        anzahlComputerNimmt = anzahlStreichhoelzer % 4;
        if (anzahlComputerNimmt == 0) {
            anzahlComputerNimmt = 1;
        }
        System.out.println( "Der Computer nimmt " + anzahlComputerNimmt + " Streichhoelzer." );
        return anzahlStreichhoelzer - anzahlComputerNimmt;
    }
    /**
     * Eingabedialog mit Rueckgabe eines int Wertes 1..3
     * @return int Wert, vielviel Streichhoelzer der Spieler nimmt
     */
    int spielerZug() {
        int anzahlSpielerNimmt = 0;
        while (anzahlSpielerNimmt > 3 || anzahlSpielerNimmt < 1) {
            System.out.println( "Wie viele Streichhoelzer nimmst du? ( 1, 2, oder 3) " );
            anzahlSpielerNimmt = scan.nextInt();
        }
        return anzahlSpielerNimmt;
    }
    /**
     * Spielelogik abwechselndes ziehen
     * @param startAnzahlStreichhoelzer Anzahl der verbleibenden Streichhoelzer
     * @param computerBeginnt Computer beginnt
     */
    void spielzugAusfuehren( int startAnzahlStreichhoelzer, boolean computerBeginnt) {
        int anzahlStreichhoelzer = startAnzahlStreichhoelzer;
        boolean computerGewinnt = false;
        boolean computerIstDran = computerBeginnt;
        do {
            System.out.println( "Es befinden sich noch " + anzahlStreichhoelzer + " Streichhoelzer im Spiel." );
            if (computerIstDran) {
                anzahlStreichhoelzer = computerZug(anzahlStreichhoelzer);
                if (anzahlStreichhoelzer == 0) {
                    computerGewinnt = true;
                }
            } else {
                anzahlStreichhoelzer -= spielerZug();
            }
            computerIstDran = !computerIstDran;
        } while (anzahlStreichhoelzer > 0);
        if (computerGewinnt) {
            System.out.println( "Der Computer gewinnt." );
        } else {
            System.out.println( "Du hast gewonnen." );
        }
    }
    /**
     * Initialisierung des Spiels, bestimmen wer anfaengt
     */
    private void spielBeginnen() {
        boolean computerBeginnt;
        System.out.println( "Wie viele Streichhoelzer werden im Spiel sein?" );
        int anzahlStreichhoelzer = scan.nextInt();
        System.out.println( "Wer zieht zuerst? \n Computer (c) oder Spieler (s)" );
        String startChoice = scan.next();
        if (startChoice.equals( "c" )) {
            computerBeginnt = true;
        } else {
            computerBeginnt = false;
        }
        spielzugAusfuehren(anzahlStreichhoelzer, computerBeginnt);
    }
    /**
     * Main Methode startet das Spiel
     * @param args standard arguments
     */
    public static void main(String[] args) {
        Streichhoelzerspiel spiel = new Streichhoelzerspiel();
        spiel.spielBeginnen();
    }
}