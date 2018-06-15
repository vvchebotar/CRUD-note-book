package org.vvchebotar.crud.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Book.
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title_clmn")
    private String title;

    @Column(name = "description_clmn")
    private String description;

    @Column(name = "author_clmn")
    private String author;

    @Column(name = "isbn_clmn")
    private String isbn;

    @Column(name = "print_year_clmn")
    private Integer printYear;

    @Column(name = "read_already_clmn")
    private Boolean readAlready;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Book title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Book description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public Book author(String author) {
        this.author = author;
        return this;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPrintYear() {
        return printYear;
    }

    public Book printYear(Integer printYear) {
        this.printYear = printYear;
        return this;
    }

    public void setPrintYear(Integer printYear) {
        this.printYear = printYear;
    }

    public Boolean isReadAlready() {
        return readAlready;
    }

    public Book readAlready(Boolean readAlready) {
        this.readAlready = readAlready;
        return this;
    }

    public void setReadAlready(Boolean readAlready) {
        this.readAlready = readAlready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        if (book.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + "'" +
                ", description='" + getDescription() + "'" +
                ", author='" + getAuthor() + "'" +
                ", isbn=" + getIsbn() +
                ", printYear='" + getPrintYear() + "'" +
                ", readAlready='" + isReadAlready() + "'" +
                "}";
    }
}

