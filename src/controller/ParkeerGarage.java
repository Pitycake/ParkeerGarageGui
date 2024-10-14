/*
 * Doel van het programma: Een applicatie die parkeerkosten berekent voor auto’s in een parkeergarage.
 * Naam: Berndt Woest
 * Studentnummer: 500625617
 */
package controller;

import java.util.Scanner;

public class ParkeerGarage {

    static final int MAX_PARKEERDUUR = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vraag de gebruiker om het aantal auto’s dat heeft geparkeerd
        System.out.println("Dit programma is geschreven door Berndt Woest, studentnummer 500625617");
        System.out.print("Hoeveel auto's hebben geparkeerd? ");
        int aantalAutos = scanner.nextInt();

        // Maak drie arrays aan om de gegevens over auto’s in op te slaan: één voor de kentekens,
        // één voor de parkeerduur (in gehele uren) en één voor de parkeerkosten. Kies voor elke
        // array het juiste datatype en zorg dat de arrays precies groot genoeg zijn om het door de
        // gebruiker opgegeven aantal auto’s in op te slaan.
        String[] kentekens = new String[aantalAutos];
        int[] parkeerduur = new int[aantalAutos];
        double[] parkeerkosten = new double[aantalAutos];

        // Vraag gegevens per auto
        for (int i = 0; i < aantalAutos; i++) {
            System.out.println("Auto " + (i + 1)); // kan ook Systemout.printf("Auto %d", i + 1); System.out.println("Auto " + (i + 1));
            //Vraag kenteken
            System.out.print(    "Kenteken: "); //4 spaties gebruikt om inspringing te verwezenlijken
            kentekens[i] = scanner.next(); // De [i] verwijst naar de iteratie die draait op dat moment
            //Vraag geparkeerde uren
            do {
                System.out.printf("    Geparkeerde uren (max. %d): ", MAX_PARKEERDUUR); //een tab gebruik om inspringing te verwezenlijken1
                parkeerduur[i] = scanner.nextInt(); // De [i] verwijst wederom naar de iteratie van de array die draait op dat moment
                if (parkeerduur[i] > MAX_PARKEERDUUR) {
                    System.out.printf("    De parkeerduur kan maximaal %d uur zijn.\n", MAX_PARKEERDUUR);
                }
            } while (parkeerduur[i] > MAX_PARKEERDUUR);
            // Controleer op minder dan 1 uur
            if (parkeerduur[i] < 1) {
                // Validatie voor invoer van minder dan 1
                System.out.print("Ongeldige invoer. Voer een waarde in van 1 of meer: ");
                parkeerduur[i] = scanner.nextInt();
            }

            // Stap 4: Bereken de parkeerkosten
            parkeerkosten[i] = berekenParkeergeld(parkeerduur[i]);
        }

        // Stap 5: Druk een overzicht af
        System.out.println("\nParkeeroverzicht");
        System.out.println("kenteken\t\turen\tbedrag");
        for (int i = 0; i < aantalAutos; i++) {
            System.out.printf("%s\t\t%d\t\t%.2f\n", kentekens[i], parkeerduur[i], parkeerkosten[i]);
            // %s geeft een string weer, \t is een tab, %d geeft een decimale integer aan en %.2f rondt een double af op twee getallen na de komma.
        }

        // Stap 6: Bereken het totaal van alle parkeerkosten
        double totaalKosten = berekenTotaleParkeerKosten(parkeerkosten);
        System.out.printf("Totaal van alle parkeergelden: %.2f euro.\n", totaalKosten);

        scanner.close();
    }

    // Methode om parkeerkosten te berekenen
    public static double berekenParkeergeld(int mpParkeerduur) {
        double kosten;

        if (mpParkeerduur <= 3) {
            kosten = mpParkeerduur * 3.75; //De leraar gebruikt hier BASIS_TARIEF_UREN ofwel constanten, gebruik ook constanten
        } else { //Definieer de constanten bovenaan
            kosten = (3 * 3.75) + ((mpParkeerduur - 3) * 2.75);
        }

        // Controleer op de maximum kosten
        if (kosten > 25.00) { //De leraar gebruikt hier Math.min
            kosten = 25.00; // Maximaal dagtarief
        }

        return kosten;
    }

    // Methode om totale parkeerkosten te berekenen
    public static double berekenTotaleParkeerKosten(double[] mpParkeerKosten) {
        double totaal = 0.0;
        for (double kosten : mpParkeerKosten) {
            totaal += kosten;
        }
        return totaal;

//Leraar doet eerst
//  public static double berekenTotaleParkeerkosten(Double[] mpParkeerKosten) {
//        double totaal = 0.0;
//        for (int i= 0; i < mpParkeerkosten.length; i++) {
//            totaal = totaal + mpParkeerkosten[i];
//        }
    }
}
