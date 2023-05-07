package homework21;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;


public class Product {

    private Enum type;
    private double price;
    private boolean discount;
    private LocalDate productDate;
    private final long id;

    public Product(Enum type, double price, boolean discount, LocalDate localDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.productDate = localDate;
        this.id = new Random().nextLong(50000);
    }



    public LocalDate getLocalDate() {
        return productDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.productDate = localDate;
    }



    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discont) {
        discount = discont;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", price=" + price +
                ", isDiscont=" + discount +
                ", ProductDate=" + productDate +
                ", Product ID=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && discount == product.discount && id == product.id && Objects.equals(type, product.type) && Objects.equals(productDate, product.productDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, discount, productDate, id);
    }
}
