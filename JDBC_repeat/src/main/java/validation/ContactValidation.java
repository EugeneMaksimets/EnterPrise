package validation;

import entity.Contact;
import service.ContactService;


public class ContactValidation {

    protected void contactStart() {
        String WELCOME = "--------------------------------------------------------------------------------------------\n" +
                "                                If you want SAVE new Contact pres '1'\n" +
                "                                If you want UPDATE Contact pres '2'\n" +
                "                                If you want DELETE Contact pres '3'\n" +
                "                                If you want READ all Contact pres '4'\n";
        System.out.println(WELCOME);
        Contact contact = new Contact();
        ContactService contactService = new ContactService();
        int validation = StartValidation.scanner.nextInt();
        if (validation == 1 || validation == 2) {
            StartValidation.scanner.nextLine();
            System.out.println("write Name: ");
            contact.setName(StartValidation.scanner.nextLine());
            System.out.println("write Surname: ");
            contact.setSurname(StartValidation.scanner.nextLine());
        }
        switch (validation) {
            case 1:
                contactService.save(contact);
                break;
            case 2:
                contact.setId(setIdForService());
                contactService.update(contact);
                break;
            case 3:
                contact.setId(setIdForService());
                contactService.delete(contact);
                break;
            case 4:
                System.out.println(contactService.getAll());
                break;
            default:
                System.out.println(StartValidation.INVALID);
                contactStart();
                break;
        }

    }

    private long setIdForService() {
        System.out.println("Write Contact ID: ");
        return StartValidation.scanner.nextLong();
    }
}
