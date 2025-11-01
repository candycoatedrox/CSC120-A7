import java.util.Hashtable;
import java.util.Set;

public class Library extends Building implements LibraryRequirements {

    private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<>();

        System.out.println("You have built a library: 📖");
    }

    public void addTitle(String title) {
        if (this.containsTitle(title)) {
            throw new RuntimeException("Title already in collection");
        }

        this.collection.put(title, true);
    }

    public String removeTitle(String title) {
        if (!this.containsTitle(title)) {
            throw new RuntimeException("Title not in collection");
        }

        this.collection.remove(title);
        return title;
    }

    public void checkOut(String title) {
        if (!this.isAvailable(title)) {
            throw new RuntimeException("Title already checked out");
        }

        this.collection.put(title, false);
    }

    public void returnBook(String title) {
        if (this.isAvailable(title)) {
            throw new RuntimeException("Title is not checked out");
        }

        this.collection.put(title, true);
    }

    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    public boolean isAvailable(String title) {
        if (!this.containsTitle(title)) {
            throw new RuntimeException("Title does not exist in collection");
        }

        return this.collection.get(title);
    }

    public void printCollection() {
        int n = 1;
        Set<String> titles = this.collection.keySet();

        for (String title : titles) {
            if (this.isAvailable(title)) {
                System.out.println(n + ". " + title + " (available)");
            } else {
                System.out.println(n + ". " + title + " (checked out)");
            }

            n += 1;
        }
    }

    public static void main(String[] args) {
        Library myLibrary = new Library("Neilson Library", "1 Chapin Way", 4);
        myLibrary.addTitle("The Great Gatsby");
        myLibrary.addTitle("Calling In");
        myLibrary.addTitle("The House in the Cerulean Sea");
        myLibrary.printCollection();

        myLibrary.checkOut("The Great Gatsby");
        System.out.println("The Great Gatsby is available: " + myLibrary.isAvailable("The Great Gatsby"));
        System.out.println("The Great Gatsby is in the library: " + myLibrary.containsTitle("The Great Gatsby"));
        System.out.println("Gideon the Ninth is in the library: " + myLibrary.containsTitle("Gideon the Ninth"));
        myLibrary.printCollection();
        myLibrary.returnBook("The Great Gatsby");

        myLibrary.removeTitle("The Great Gatsby");
        myLibrary.printCollection();
    }

}