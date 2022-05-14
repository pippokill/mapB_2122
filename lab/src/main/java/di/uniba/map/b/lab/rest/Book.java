/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.rest;

import java.util.Objects;

/**
 *
 * @author pierpaolo
 */
public class Book {
    
    private String title;
    
    private String isbn;
    
    private String[] authors;
    
    private double price;

    /**
     *
     * @param title
     * @param isbn
     * @param price
     */
    public Book(String title, String isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    /**
     *
     * @param title
     * @param isbn
     * @param authors
     * @param price
     */
    public Book(String title, String isbn, String[] authors, double price) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     *
     * @param authors
     */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", isbn=" + isbn + ", authors=" + authors + ", price=" + price + '}';
    }
    
    
    
}
