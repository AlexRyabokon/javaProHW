package homework21;

import homework21.enums.Type;

import java.time.LocalDate;
import java.util.*;



public class App {

    public static void main(String[] args) {

        var prod1 = new Product(Type.NOTEBOOK, 100, true, LocalDate.now());
       var products = new ArrayList<Product>();
        products.add(new Product(Type.NOTEBOOK, 100, true, LocalDate.now()));
        products.add(new Product(Type.NOTEBOOK, 100, true, LocalDate.now()));
        products.add(new Product(Type.NOTEBOOK, 100, true, LocalDate.now()));
        products.add(new Product(Type.NOTEBOOK, 100, true, LocalDate.now()));
        products.add(prod1);

        System.out.println(products);

        System.out.println(StreamUtils.getCheapestBook(products));







    }
}
