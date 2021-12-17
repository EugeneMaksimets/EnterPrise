package service;

import database.Database;
import entity.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private static final String TEST_DELETE_CONTACT_QUERY = "DELETE from contacts WHERE id > ?";
    Contact contact = new Contact();
    ContactService contactService = new ContactService();

    public void testDelete(Contact contact) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(TEST_DELETE_CONTACT_QUERY)) {
            preparedStatement.setLong(1, contact.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        assertNotNull(contactService.getAll());
    }

    @Test
    void save() {
        contact.setId(67);
        contact.setName("Eugene");
        contact.setSurname("Maksimets");
        contactService.save(contact);
        assertEquals(contact.getName(), "Eugene");
        assertEquals(contact.getSurname(), "Maksimets");
    }

    @Test
    void update() {
        contact.setId(42);
        contact.setName("Katya");
        contact.setSurname("Sirotyuk");
        assertEquals(contact.getName(), "Katya");
        assertEquals(contact.getSurname(), "Sirotyuk");
    }

    @AfterEach
    void down() {
        contact.setId(0);
        testDelete(contact);
    }
}