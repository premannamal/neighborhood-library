import java.util.*;

public class Book {
/* This is an application for neighborhood library. The library is a free service to anyone in my neighborhood
and is based on the honor system. Anyone can check out a book by entering their name and the application
will track who checked it out.*/

    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    //gettor method for id
    public int getid() {
        return this.id;
    }

    // Setter method (optional, included for context) for id
    public void setid(int id) {
        this.id = id;
    }

    //gettor method for isbn
    public String getisbn() {
        return this.isbn;
    }

    // Setter method (optional, included for context) for isbn
    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    //gettor method for title
    public String gettitle() {
        return this.title;
    }

    // Setter method (optional, included for context) for title
    public void settitle(String title) {
        this.title = title;
    }

    //gettor method for isCheckedOut
    public boolean getisCheckedOut() {
        return this.isCheckedOut;
    }

    // Setter method (optional, included for context) for isCheckedOut
    public void setisCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    //gettor method for checkedOutTo
    public String getcheckedOutTo() {
        return this.checkedOutTo;
    }

    // Setter method (optional, included for context) for checkedOutTo
    public void setcheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }


    public static void main(String[] args) {
        //array size set to 20
        Book[] bk = new Book[20];
        Scanner scanner = new Scanner(System.in);
        // use constructor to initialize the values of array elements
        bk[0] = new Book(1, "978-81-88479-95-5", "Silence of the Heart", false, null);
        bk[1] = new Book(2, "988-81-88479-95-5", "Rabbit's of the Wild", false, null);
        bk[2] = new Book(3, "979-81-88479-95-5", "Dogs on the Prairie", false, null);
        bk[3] = new Book(4, "978-11-88479-95-5", "Cats off the Corner", false, null);
        bk[4] = new Book(5, "978-82-88479-95-5", "Pigs off the Barn", false, null);
        bk[5] = new Book(6, "978-81-38479-95-5", "Rooftops in the Street", false, null);
        bk[6] = new Book(7, "978-81-84479-95-5", "Cavaliers in the Outdoors", false, null);
        bk[7] = new Book(8, "978-81-88579-95-5", "A Court of Thorns", false, null);
        bk[8] = new Book(9, "978-81-88469-95-5", "Everything I know about Dolly", false, null);
        bk[9] = new Book(10, "978-81-88489-95-5", "Funny Story", false, null);
        bk[10] = new Book(11, "978-81-88409-95-5", "Heaven and Earth Grocery Store", true, null);
        bk[11] = new Book(12, "978-81-88471-95-5", "Crying In H Mart", true, "Matt Price");
        bk[12] = new Book(13, "978-81-88479-25-5", "Living in the Sticks", true, "John Smith");
        bk[13] = new Book(14, "978-81-88479-93-5", "The Midnight Library", true, "Steve Gyan");
        bk[14] = new Book(15, "978-81-88479-95-4", "Dog Man", true, "Amanda Gorris");
        bk[15] = new Book(16, "178-81-88479-95-5", "The Hundred Years of War on Palestine", true, "Arya Patel");
        bk[16] = new Book(17, "928-81-88479-95-5", "North Woods", true, "Amy Walton");
        bk[17] = new Book(18, "973-81-88479-95-5", "A little life", true, "Rebecca Helmwood");
        bk[18] = new Book(19, "978-41-88479-95-5", "Night at the museum", true, "Beatriz Raca");
        bk[19] = new Book(20, "978-85-88479-95-5", "A court of mist and fury", true, "John Doe");

        int command = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println(" 1 - Show available books");
            System.out.println(" 2 - Show checked out books");
            System.out.println(" 3 - Exit");

            command = scanner.nextInt();
            switch (command) {
                case 1:
                    showAvailableBooks(bk);
                    break;
                case 2:
                    showCheckedOutBooks(bk);
                    break;
            }
        } while (command != 3);

    }

    public static void showAvailableBooks(Book[] bk) {
        // this method shows the available Books that are available for check out
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < bk.length; i = i + 1) {
            if (bk[i].isCheckedOut == false) {
                System.out.println(bk[i].id + "," + bk[i].isbn + "," + bk[i].title + "," + bk[i].isCheckedOut + "," + bk[i].checkedOutTo);
            }
        }
        System.out.println("Do you want to check out a book ? (yes/no):");
        String response = scanner.nextLine();

        if (response.equals("yes")) {
            System.out.println("Enter the name of the book you want to check out:");
            String bookName = scanner.nextLine();
            System.out.println("Please enter your first and last name:");
            String name = scanner.nextLine();

            for (int j = 0; j < bk.length; j = j + 1) {
                if (bookName.equals(bk[j].title)) {
                    bk[j].isCheckedOut = true;
                    bk[j].checkedOutTo = name;
                    System.out.println("Thanks for checking out this book!   " + bookName);
                }
            }
        }

    }


    public static void showCheckedOutBooks(Book[] bk) {
        //this method is used to show checked out books to the user and check in books as well
        Scanner scanner = new Scanner(System.in);
        String bookTitle;
        for (int j = 0; j < bk.length; j = j + 1) {
            if (bk[j].isCheckedOut == true) {
                System.out.println(bk[j].id + "," + bk[j].isbn + "," + bk[j].title + "," + bk[j].checkedOutTo);
            }
        }
        System.out.println("Do you want to check-in a book (C) or go back to the home screen (X):");
        String response = scanner.nextLine();

        if (response.equals("C")) {
            System.out.println("Enter the title of the book you want to check in:");
            bookTitle = scanner.nextLine();
            checkIn(bookTitle, bk);
        } else if (response.equals("X")) {
            return;
        }
    }

    public static void checkIn(String bookTitle, Book[] bk) {
        //this method is used to check in the book
        for (int j = 0; j < bk.length; j = j + 1) {
            if (bookTitle.equals(bk[j].title)) {
                bk[j].isCheckedOut = false;
                bk[j].checkedOutTo = null;
                System.out.println("Thanks for returning this book!   " + bookTitle);
            }
        }
    }

}