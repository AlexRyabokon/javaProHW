package homework21;

import homework21.enums.Type;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class App {

    public static List<Product> findTypeInList(List<Product> products, Type findType) {
        Objects.requireNonNull(products);
        Objects.requireNonNull(findType);
        return products.stream()
                .filter(product -> product.getType().equals(findType) && product.getPrice() > 250)
                .toList();

    }

    public static List<Product> setDiscontInList(List<Product> products, float discount) {
        Objects.requireNonNull(products);
        if (discount == 0 || discount > 99.9) {
            throw new RuntimeException("Discont cannot be null or 100%! Please check input parameters");
        }
        double discountFactor = 1 - (discount / 100.0);

        return products.stream()
                .peek(product -> {
                    if (product.isDiscount()) {
                        double originalPrice = product.getPrice();
                        double discountedPrice = originalPrice * discountFactor;
                        product.setPrice(discountedPrice);
                    }
                })
                .toList();
    }

    public static List<Product> getLastProducts(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .sorted(Comparator.comparing(Product::getLocalDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


    public static double getAllPrice(List<Product> products, Type findType, double targetPrice, LocalDate date) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.getType() == findType && product.getLocalDate().getYear() == date.getYear() && product.getPrice() <= targetPrice)
                .mapToDouble(Product::getPrice)
                .sum();

    }

    public static Map<Enum, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }


    public static void main(String[] args) {

        var prod1 = new Product(Type.BOOK, 100, false, LocalDate.now());
       var products = new ArrayList<Product>();
        products.add(new Product(Type.DISK, 200, true, LocalDate.now()));
        products.add(new Product(Type.BOOK, 100, false, LocalDate.now()));
        products.add(new Product(Type.NOTEBOOK, 300, false, LocalDate.now()));
        products.add(new Product(Type.LETTER, 2230, false, LocalDate.now()));
        products.add(new Product(Type.BOOK, 100, false, LocalDate.now()));
        products.add(prod1);


        System.out.println(products);
        System.out.println(prod1);
        System.out.println(getAllPrice(products, Type.BOOK, 100, LocalDate.now()));






    }
}
