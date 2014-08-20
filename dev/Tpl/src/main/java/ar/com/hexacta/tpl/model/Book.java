package ar.com.hexacta.tpl.model;

import java.io.Serializable;
import java.util.Set;

// @Entity
public class Book extends Entidad implements Serializable {

    private static final long serialVersionUID = 604529088687479075L;

    // @Id
    // @Column(name = "BOOK_ID")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    // @Version
    // @Column(name = "VERSION")
    // private Long version;

    // @Column(name = "NAME")
    private String name;

    // @Column(name = "DESCRIPTION")
    private String description;

    // @Column(name = "PUBLISHER")
    private String publisher;

    // @Column(name = "COUNTRY")
    private String country;
    
    private String isbn;
    
    private Boolean enabled;

    // @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @Column(name = "BOOK_CATEGORY")
    private Set<BookCategory> bookCategories;

    // @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @Column(name = "BOOK_COPY")
    private Set<BookCopy> bookCopies;


    /*
     * <list name="bookComments" table="COMENTARIOS"
     * cascade="all-delete-orphan"> <key column="BOOK_ID" /> <one-to-many
     * column="COMMENT_ID" class="ar.com.hexacta.tpl.model.Comment" /> </list>
     */
    // Hibernate needs this

    public Book() {
        super();
        this.enabled = new Boolean(true);
    }

    public Book(final String name) {
        super();
        this.name = name;
        this.enabled = new Boolean(true);
    }

    public Book(final String aName, final String aDescription, final String aPublisher, final String aCountry, final String isbn,

    final Set<BookCategory> bookCategories, final Set<BookCopy> bookCopies, final Set<Comment> bookComments) {

        super();
        name = aName;
        description = aDescription;
        publisher = aPublisher;
        country = aCountry;
        this.bookCategories = bookCategories;
        this.bookCopies = bookCopies;
        this.isbn = isbn;
        this.enabled = new Boolean(true);
    }

    public Set<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public String getDescription() {
        return description;
    }

    public BookCopy getBookCopies() {
        for (BookCopy bookCopy : bookCopies) {
            if (bookCopy.getState().equals(BookCopy.STATE_FREE))
                return bookCopy;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setBookCategories(final Set<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }

    public void setBookCopies(final Set<BookCopy> bookCopies){
    	this.bookCopies = bookCopies;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setISBN (final String isbn){
    	this.isbn = isbn;
    }
    
    public String getISBN (){
    	return this.isbn;
    }

    public void setEnabled(boolean enable){
    	this.enabled = new Boolean(enable);
    }
    
    public boolean getEnabled(){
    	return this.enabled;
    }
}
