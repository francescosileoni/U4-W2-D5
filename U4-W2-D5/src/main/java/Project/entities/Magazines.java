package Project.entities;

import java.util.Scanner;

public class Magazines extends CatalogElements {
    private final Frequency frequency;

    public Magazines(String title, int numberOfPage, int ISBN, int pubblicationDate, Frequency frequency) {
        super(title, numberOfPage, ISBN, pubblicationDate);
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return this.frequency;
    }

    public static Magazines insertMagazine(Scanner sc) {
        System.out.println();
        System.out.println("Write Title:");
        String title = sc.nextLine();
        System.out.println("Write the publication frequency (weekly, monthly, semiannually):");
        Frequency frequency1;
        do {
            try {
                frequency1 = Frequency.valueOf(sc.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException ex) {
                System.err.println("Error: frequency not available.");
            }
        } while (true);

        System.out.println("Write the publication date:");
        int publicationDate;
        while (true) {
            try {
                publicationDate = Integer.parseInt(sc.nextLine());

                break;
            } catch (NumberFormatException ex) {
                System.err.println("Error: not a valid publication date.");
            }
        }

        System.out.println("Write the number of pages:");
        int numberOfPages;
        while (true) {
            try {
                numberOfPages = Integer.parseInt(sc.nextLine());

                break;
            } catch (NumberFormatException ex) {
                System.err.println("Error: not a valid number of pages.");
            }
        }

        System.out.println("Write the ISBN:");
        int ISBN;
        while (true) {
            try {
                ISBN = Integer.parseInt(sc.nextLine());

                break;
            } catch (NumberFormatException ex) {
                System.err.println("Error: not a valid ISBN.");
            }
        }

        return new Magazines(title, numberOfPages, ISBN, publicationDate, frequency1);
    }
    @Override
    public String toString() {
        return "\nISBN: " + getISBN() +
                "\nTitle: " + getTitle() +
                "\nPubblication Date: " + getPubblicationDate() +
                "\nNumber Of Page: " + getNumberOfPage() +
                "\nfrequency: " + getFrequency() +

                "\n";
    }
}
