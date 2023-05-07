package homework21;

import homework21.enums.Type;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamUtils {

    public static List<Product> getExpensiveBooks(List<Product> products, Type findType) {
        Objects.requireNonNull(products);
        Objects.requireNonNull(findType);
        return products.stream()
                .filter(product -> product.getType() == findType && product.getPrice() > 250)
                .toList();

    }

    public static List<Product> getBooksWithDiscount(List<Product> products, float discount) {
        Objects.requireNonNull(products);

        return products.stream()
                .map(product -> {
                    if (product.isDiscount() && product.getType() == Type.BOOK) {
                        double originalPrice = product.getPrice();
                        double discountedPrice = originalPrice * 1 - (discount / 100.0);
                        return new Product(product.getType(), discountedPrice, true, product.getLocalDate());
                    } else {
                        return product;
                    }
                })
                .collect(Collectors.toList());
    }


    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Product " + Type.BOOK +" not found"));
    }



    public static List<Product> getLastThreeProducts(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .skip(products.size() - 3)
                .toList();
    }


    public static double calculateTotalPrice(List<Product> products, Type type, double targetPrice, LocalDate date) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.getType() == type && product.getLocalDate().getYear() == date.getYear() && product.getPrice() <= targetPrice)
                .mapToDouble(Product::getPrice)
                .sum();

    }

    public static Map<Enum, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }


}
