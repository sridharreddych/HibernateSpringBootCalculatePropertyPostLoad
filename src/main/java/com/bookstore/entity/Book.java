package com.bookstore.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
 
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String title;
    private String isbn;
    private double price;

    @Transient
    private double discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Transient
    public double getDiscount() {
        return discount;
    }

    @PostLoad
    private void postLoad() {
        this.discount = this.price - this.price * 0.35; 
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" 
                + isbn + ", price=" + price + ", discount=" + discount + '}';
    }        
}
