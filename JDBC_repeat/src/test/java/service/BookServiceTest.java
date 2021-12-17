package service;

import database.Database;
import entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    private static final String TEST_DELETE_BOOK_QUERY = "DELETE from book WHERE id > ?";

    public void testDelete(Book book) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(TEST_DELETE_BOOK_QUERY)) {
            preparedStatement.setLong(1, book.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Book book = new Book();
    BookService bookService = new BookService();

    @Test
    public void getAll() {
        assertNotNull(bookService.getAll());
    }

    @Test
    public void save() {
        book.setContact_id(231);
        book.setAddress_id(122);
        bookService.save(book);
        assertEquals(book.getContact_id(), 231);
        assertEquals(book.getAddress_id(), 122);
    }

    @Test
    public void update() {
        book.setAddress_id(43);
        book.setContact_id(43);
        book.setId(22);
        bookService.update(book);
        assertEquals(book.getId(), 22);
    }

    @Test
    public void getAllContacts() {
        assertNotNull(bookService.getAllContacts());
    }

    @AfterEach
    public void down() throws Exception {
        book.setId(0);
        testDelete(book);
    }
}