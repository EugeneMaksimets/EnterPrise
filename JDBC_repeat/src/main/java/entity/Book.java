package entity;

public class Book {
    private long id;
    private long contact_id;
    private long address_id;

    public Book() {

    }

    public Book(long id, long contact_id, long address_id) {
        this.id = id;
        this.contact_id = contact_id;
        this.address_id = address_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", contact_id=" + contact_id +
                ", address_id=" + address_id +
                '}';
    }
}
