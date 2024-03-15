package Project.entities;

import java.util.Scanner;

public class Books extends CatalogElements {

    public final BookGenre bookGenre;
    public String author;

    public Books (String title, int numberOfPage, int ISBN, int pubblicationDate, BookGenre bookGenre, String author){
       super(title,numberOfPage,ISBN,pubblicationDate);
       this.bookGenre= bookGenre;
        this.author= author;
    }

    public BookGenre getBookGenre(){return this.bookGenre;}
    public String getAuthor(){return this.author;}

    public static Books insertBooks(Scanner sc) {
        System.out.println();
        System.out.println("Write title:");
        String title = sc.nextLine();

        System.out.println("Write authors name:");
        String author = sc.nextLine();

        System.out.println("Write the genre (Drama, Fantasy, Horror, Romance):");
        BookGenre bookGenre1;
        do {
            try {
                bookGenre1 = BookGenre.valueOf(sc.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException ex) {
                System.err.println("Error: genre not available.");
            }
        } while (true);

        int numberOfPage;
        int publicationDate;

        System.out.println("Enter the number of pages:");
        numberOfPage = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the publication year:");
        publicationDate = Integer.parseInt(sc.nextLine());

        return new Books(title, numberOfPage, 0, publicationDate, bookGenre1, author);
    }


    @Override
    public String toString() {
        return "\nISBN: " + getISBN() +
                "\nTitle: " + getTitle() +
                "\nPubblicatio Date: " + getPubblicationDate() +
                "\nNumber Of Page: " + getNumberOfPage() +
                "\nAuthors " + getAuthor() +
                "\nGenre: " + getBookGenre() +
                "\n";
    }

}
