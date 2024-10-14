package controller;

import java.util.Scanner;

public class RideShare {

    static final double VOORRIJDKOSTEN = 2.50; // Voorrijdkosten per rit
    static final double KOSTEN_PER_KM = 1.20; // Kosten per kilometer
    static final double KOSTEN_PER_MINUUT = 0.25; // Kosten per minuut
    static final double KORTING_THRESHOLD = 50;
    static final double KORTING = 0.10; // 10% korting voor ritten boven de €50

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vraag het aantal ritten
        System.out.print("Hoeveel ritten heb je gemaakt? ");
        int aantalRitten = scanner.nextInt();
        scanner.nextLine();  // Buffer leegmaken

        // Maak de arrays aan
        double[] ritAfstanden = new double[aantalRitten];
        int[] ritDuren = new int[aantalRitten];
        double[] ritKosten = new double[aantalRitten];

        // Vraag per rit de gegevens in
        for (int i = 0; i < aantalRitten; i++) {
            System.out.println("Rit " + (i + 1));
            System.out.print("Afstand in kilometers: ");
            ritAfstanden[i] = scanner.nextDouble();
            System.out.print("Duur in minuten: ");
            ritDuren[i] = scanner.nextInt();
            // Bereken de kosten voor deze rit
            ritKosten[i] = berekenRitkosten(ritAfstanden[i], ritDuren[i]);
        }

        // Druk het overzicht af
        System.out.println("\nRitoverzicht:");
        System.out.printf("%-10s%-10s%-10s%-10s\n", "Rit#", "Afstand", "Duur", "Kosten");
        for (int i = 0; i < aantalRitten; i++) {
            System.out.printf("%-10d%-10.2f%-10d%-10.2f\n", (i + 1), ritAfstanden[i], ritDuren[i], ritKosten[i]);
        }

        // Bereken het totaal van de ritkosten
        double totaalKosten = berekenTotaleRitkosten(ritKosten);
        System.out.printf("\nTotale kosten van alle ritten: %.2f euro.\n", totaalKosten);

        scanner.close();
    }

    // Methode om de ritkosten te berekenen
    public static double berekenRitkosten(double afstand, int duur) {
        double kosten = VOORRIJDKOSTEN + (afstand * KOSTEN_PER_KM) + (duur * KOSTEN_PER_MINUUT);
        if (kosten > KORTING_THRESHOLD) {
            kosten = kosten - (kosten * KORTING); // Toepassen van korting
        }
        return kosten;
    }

    // Methode om de totale ritkosten te berekenen
    public static double berekenTotaleRitkosten(double[] ritkosten) {
        double totaal = 0.0;
        for (double kosten : ritkosten) {
            totaal += kosten;
        }
        return totaal;
    }
}
