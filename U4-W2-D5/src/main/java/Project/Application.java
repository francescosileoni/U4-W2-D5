package Project;

import Project.entities.BookGenre;
import Project.entities.Books;
import Project.entities.Magazines;
import Project.entities.Frequency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Books> bookList = new ArrayList<>();
        List<Magazines> magazineList = new ArrayList<>();

        System.out.println("Benvenuti nel nostro store di libri e riviste!");
        System.out.println("-----------------------------------------");
        System.out.println("Scegliere la tua opzione:");
        System.out.println("1. Inserisci un nuovo libro");
        System.out.println("2. Inserisci una nuova rivista");
        System.out.println("3. Visualizza un libro");
        System.out.println("4. Visualizza una rivista");
        System.out.println("5. Visualizza tutti i libri");
        System.out.println("6. Visualizza tutte le riviste");
        System.out.println("7. Esci");
        System.out.println("-----------------------------------------");

        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("Inserire l'ISBN del libro:");
                int ISBN = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserire il titolo del libro:");
                String titolo = scanner.nextLine();
                System.out.println("Inserire l'anno di pubblicazione del libro:");
                int annoDiPubblicazione = scanner.nextInt();
                System.out.println("Inserire il numero di pagine del libro:");
                int numeroPagine = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Inserire l'autore del libro:");
                String autore = scanner.nextLine();
                System.out.println("Inserire il genere del libro:");
                String genere = scanner.nextLine();
                try {
                    BookGenre bookGenre = BookGenre.valueOf(genere.toUpperCase());
                    Books libro = new Books(titolo, numeroPagine, ISBN, annoDiPubblicazione, bookGenre, autore);
                    bookList.add(libro);
                    System.out.println("Libro aggiunto correttamente");
                } catch (IllegalArgumentException e) {
                    System.err.println("Errore: genere non disponibile.");
                }
                break;
            case 2:
                System.out.println("Inserire l'ISBN della rivista:");
                int ISBN2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserire il titolo della rivista:");
                String titolo2 = scanner.nextLine();
                System.out.println("Inserire l'anno di pubblicazione della rivista:");
                int annoDiPubblicazione2 = scanner.nextInt();
                System.out.println("Inserire il numero di pagine della rivista:");
                int numeroPagine2 = scanner.nextInt();
                System.out.println("Inserire la periodicità della rivista:");
                System.out.println("1 - MENSILE");
                System.out.println("2 - SETTIMANALE");
                System.out.println("3 - SEMIANNUALE");
                int sc = scanner.nextInt();
                Frequency frequency;
                switch (sc) {
                    case 1:
                        frequency = Frequency.MONTHLY;
                        break;
                    case 2:
                        frequency = Frequency.WEEKLY;
                        break;
                    case 3:
                        frequency = Frequency.SEMIANNUALLY;
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        return;
                }
                Magazines rivista = new Magazines(titolo2, numeroPagine2, ISBN2, annoDiPubblicazione2, frequency);
                magazineList.add(rivista);
                System.out.println("Rivista aggiunta correttamente");
                break;
            case 3:
                System.out.println("Inserire l'ISBN del libro da visualizzare:");
                int ISBN1 = scanner.nextInt();
                for (Books book : bookList) {
                    if (ISBN1 == book.getISBN()) {
                        System.out.println(book);
                        return;
                    }
                }
                System.out.println("Libro non trovato");
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }
}