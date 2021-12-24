package service;

import database.Database;
import entity.Address;
import entity.Book;
import entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    private static final String SELECT_ALL_BOOK_QUERY = "SELECT * FROM book";
    private static final String SAVE_BOOK_QUERY = "INSERT INTO book (contacts_id, addresses_id) VALUES (?,?)";
    private static final String UPDATE_BOOK_QUERY = "UPDATE book SET contacts_id = ?, addresses_id = ? WHERE id = ?";
    private static final String DELETE_BOOK_QUERY = "DELETE from book WHERE id = ?";
    private static final String SELECT_CONTACT_BOOK_QUERY = "select a.id, a.street, a.house_number, a.apartment, c.id, c.name, c.surname " +
            "FROM contacts c INNER JOIN book b ON b.contacts_id = c.id INNER JOIN addresses a ON b.addresses_id = a.id;";

    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_BOOK_QUERY);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setContact_id(resultSet.getLong("contacts_id"));
                book.setAddress_id(resultSet.getLong("addresses_id"));
                books.add(book);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void save(Book book) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_BOOK_QUERY)) {
            preparedStatement.setLong(1, book.getContact_id());
            preparedStatement.setLong(2, book.getAddress_id());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(UPDATE_BOOK_QUERY)) {
            preparedStatement.setLong(1, book.getContact_id());
            preparedStatement.setLong(2, book.getAddress_id());
            preparedStatement.setLong(3, book.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Book book) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(DELETE_BOOK_QUERY)) {
            preparedStatement.setLong(1, book.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Contact, Address> getAllContacts() {
        Map<Contact, Address> clientStatusMap = new HashMap<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_CONTACT_BOOK_QUERY);
            while (resultSet.next()) {
                Address address = new Address();
                Contact contact = new Contact();
                address.setId(resultSet.getLong("id"));
                address.setStreet(resultSet.getString("street"));
                address.setHouseNumber(resultSet.getInt("house_number"));
                address.setApartment(resultSet.getInt("apartment"));
                contact.setId(resultSet.getLong("id"));
                contact.setName(resultSet.getString("name"));
                contact.setSurname(resultSet.getString("surname"));
                clientStatusMap.put(contact, address);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientStatusMap;
    }
}
