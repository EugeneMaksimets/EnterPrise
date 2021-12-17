package service;

import database.Database;
import entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private static final String SELECT_ALL_CONTACTS_QUERY = "SELECT * FROM contacts";
    private static final String SAVE_CONTACT_QUERY = "INSERT INTO contacts (name, surname) VALUES (?,?)";
    private static final String UPDATE_CONTACT_QUERY = "UPDATE contacts SET name = ?, surname = ? WHERE id = ?";
    private static final String DELETE_CONTACT_QUERY = "DELETE from contacts WHERE id = ?";

    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CONTACTS_QUERY);
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("id"));
                contact.setName(resultSet.getString("name"));
                contact.setSurname(resultSet.getString("surname"));
                contacts.add(contact);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void save(Contact contact) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_CONTACT_QUERY)) {
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getSurname());

            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Contact contact) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(UPDATE_CONTACT_QUERY)) {
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getSurname());
            preparedStatement.setLong(3, contact.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Contact contact) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(DELETE_CONTACT_QUERY)) {
            preparedStatement.setLong(1, contact.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}