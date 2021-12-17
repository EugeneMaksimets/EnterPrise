package validation;

import entity.Address;
import service.AddressService;

public class AddressValidation {
    protected void addressStart() {
        String WELCOME = "--------------------------------------------------------------------------------------------\n" +
                "                                If you want SAVE new Address pres '1'\n" +
                "                                If you want UPDATE Address pres '2'\n" +
                "                                If you want DELETE Address pres '3'\n" +
                "                                If you want READ all Address pres '4'\n";
        System.out.println(WELCOME);
        Address address = new Address();
        AddressService addressService = new AddressService();
        int validation = StartValidation.scanner.nextInt();
        if (validation == 1 || validation == 2) {
            StartValidation.scanner.nextLine(); // Нашел решение в инете, раньше не сталкивался, как я понял сканер иногда
            // считывапет ранее нажатый ентер как строку и может проскочить запрос где он нужен, по этому тут костыль :)
            System.out.println("write Street: ");
            address.setStreet(StartValidation.scanner.nextLine());
            System.out.println("write House Number: ");
            address.setHouseNumber(StartValidation.scanner.nextInt());
            System.out.println("write Apartment: ");
            address.setApartment(StartValidation.scanner.nextInt());
        }
        switch (validation) {
            case 1:
                addressService.save(address);
                break;
            case 2:
                address.setId(setIdForService());
                addressService.update(address);
                break;
            case 3:
                address.setId(setIdForService());
                addressService.delete(address);
                break;
            case 4:
                System.out.println(addressService.getAll());
                break;
            default:
                System.out.println(StartValidation.INVALID);
                addressStart();
                break;
        }

    }

    private long setIdForService() {
        System.out.println("Write Address ID: ");
        return StartValidation.scanner.nextLong();
    }
}
