/*
 * Copyright (C) 2021 Drc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any lter version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;
import static labs.pm.data.Rating.*;

/**
 * {@code Shop} class represents an application that manages Products
 *
 * @version 4.0
 * @author Drc
 */
public abstract class Product implements Rateable<Product>, Serializable{

    /**
     * A constant that defines a {@link java.math.BigDecimal} value of the
     * discount rate
     * <br>
     * Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

//    Product() {
//        this(0, "no name", BigDecimal.ZERO, NOT_RATED);
//    }

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public Rating getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

//    public void setId(final int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

//    public void setName(final String name) {
//        this.name = name;
//    }

    public BigDecimal getPrice() {
        return price;
    }

//    public void setPrice(final BigDecimal price) {
//        this.price = price;
//    }

    /**
     * Calculates discount amount
     *
     * @return
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + 
                ", price=" + price +", discount=" + getDiscount() + 
                ", rating=" + rating.getStars() + '}';
    }

    //public abstract Product applyRating(Rating newRating);

    public LocalDate getBestBefore(){
        return LocalDate.now();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }        
        if(obj instanceof Product){
            final Product other = (Product) obj;
            return this.id == other.id;
        }
        return false;
    }  
}
