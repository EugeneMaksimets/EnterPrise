package validation;

import entity.Book;
import service.BookService;

public class BookValidation {

    protected void bookStart() {
        String WELCOME = "--------------------------------------------------------------------------------------------\n" +
                "                                If you want SAVE new Join to Book pres '1'\n" +
                "                                If you want UPDATE some Join pres '2'\n" +
                "                                If you want DELETE some Join pres '3'\n" +
                "                                If you want READ all Join info pres '4'\n" +
                "                                If you want READ all Join ID '5'\n";
        System.out.println(WELCOME);
        Book book = new Book();
        BookService bookService = new BookService();
        int validation = StartValidation.scanner.nextInt();
        if (validation == 1 || validation == 2) {
            StartValidation.scanner.nextLine();
            System.out.println("write id Contact: ");
            book.setContact_id(StartValidation.scanner.nextLong());
            System.out.println("write id Address: ");
            book.setAddress_id(StartValidation.scanner.nextLong());
        }
        switch (validation) {
            case 1:
                bookService.save(book);
                break;
            case 2:
                book.setId(setIdForService());
                bookService.update(book);
                break;
            case 3:
                book.setId(setIdForService());
                bookService.delete(book);
                break;
            case 4:
                System.out.println(bookService.getAllContacts());
            case 5:
                System.out.println(bookService.getAll());
                break;
            default:
                System.out.println(StartValidation.INVALID);
                bookStart();
                break;
        }

    }

    private long setIdForService() {
        System.out.println("Write BOOK ID: ");
        return StartValidation.scanner.nextLong();
    }
}

