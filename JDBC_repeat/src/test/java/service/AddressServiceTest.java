package service;

import database.Database;
import entity.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {
    private static final String TEST_DELETE_ADDRESS_QUERY = "DELETE from addresses WHERE id > ?";
    Address address = new Address();
    AddressService addressService = new AddressService();

    public void testDelete(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(TEST_DELETE_ADDRESS_QUERY)) {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        assertNotNull(addressService.getAll());
    }

    @Test
    void save() {
        address.setId(16);
        address.setStreet("Sapenoe Pole");
        address.setHouseNumber(12);
        address.setApartment(214);
        addressService.save(address);
        assertNotNull(addressService.getAll());
        assertEquals(address.getId(), 16);
        assertEquals(address.getApartment(), 214);
        assertEquals(address.getStreet(), "Sapenoe Pole");
        assertEquals(address.getHouseNumber(), 12);
    }

    @Test
    void update() {
        address.setId(41);
        address.setStreet("Shorsa");
        address.setHouseNumber(2);
        address.setApartment(55);
        addressService.update(address);
        assertEquals(address.getHouseNumber(), 2);
        assertEquals(address.getStreet(), "Shorsa");
        assertEquals(address.getApartment(), 55);
    }

    @AfterEach
    void down() {
        address.setId(0);
        testDelete(address);
    }
}