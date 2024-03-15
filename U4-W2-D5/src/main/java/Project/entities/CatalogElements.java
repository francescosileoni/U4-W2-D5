package Project.entities;

public abstract class CatalogElements {

    private String title;
    private int numberOfPage;
    private int ISBN;
    private int pubblicationDate;

    public CatalogElements(String title, int numberOfPage, int ISBN, int pubblicationDate){
        this.title= title;
        this.numberOfPage= numberOfPage;
        this.ISBN= ISBN;
        this.pubblicationDate= pubblicationDate;
    }

    public String getTitle(){return this.title;}

    public int getNumberOfPage(){return this.numberOfPage;}
    public int getISBN() {
        return this.ISBN;
    }

    public int getPubblicationDate(){return this.pubblicationDate;}


}
