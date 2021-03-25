/*
 * Copyright (C) 2021 Drc
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
package labs.pm.app;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Locale;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 * {@code Shop} class represents an application that manages Products
 *
 * @version 4.0
 * @author Drc
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProductManager pm = new ProductManager("en-GB");        
        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        //pm.printProductReport(101);
        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice cup of tea");
        pm.reviewProduct(101, Rating.TWO_STAR, "Nice cup of tea");
        pm.reviewProduct(101, Rating.ONE_STAR, "Amazing");
        pm.reviewProduct(101, Rating.TWO_STAR, "Meh!");       
        
        pm.parseReview("1012,Nicesuuuuuu"); 
        pm.printProductReport(101);
        
        //pm.changeLocal("ru-RU"); 
        pm.createProduct(102, "Coffe", BigDecimal.valueOf(3.99), Rating.FOUR_STAR);        
        pm.reviewProduct(102, Rating.FOUR_STAR, "Nice cup of tea");
        pm.reviewProduct(102, Rating.FOUR_STAR, "Nice cup of tea");
        pm.reviewProduct(102, Rating.FIVE_STAR, "Amazing");
        pm.printProductReport(102);
        
        pm.printProducts(p -> p.getPrice().floatValue() < 5, 
                (p1, p2)->p2.getRating().ordinal()-p1.getRating().ordinal());
        
        pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating+"\t"+discount));
        
        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
        
        
        
//        pm.printProducts(ratingSorter.thenComparing(priceSorter));
//        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
    }
}
