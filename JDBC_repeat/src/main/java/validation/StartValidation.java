package validation;

import java.util.Scanner;

public class StartValidation {
    protected static Scanner scanner = new Scanner(System.in);
    protected final static String INVALID = "Invalid, please select valid number: ";

    public void start() {
        String WELCOME = "---------------------------------------Welcome to Phone Book-----------------------------------------------------\n" +
                "                                If you want work with Address '1'\n" +
                "                                If you want work with Contact press '2'\n" +
                "                                If you want work with Book press '3'";
        System.out.println(WELCOME);
        int validation = scanner.nextInt();
        switch (validation) {
            case 1:
                AddressValidation addressValidation = new AddressValidation();
                addressValidation.addressStart();
                break;
            case 2:
                ContactValidation contactValidation = new ContactValidation();
                contactValidation.contactStart();
                break;
            case 3:
                BookValidation bookValidation = new BookValidation();
                bookValidation.bookStart();
                break;
            default:
                System.out.println(INVALID);
                start();
                break;
        }
    }
}
