package homework21;

import java.time.LocalDate;
import java.util.Random;


public class Product {

    private Enum type;
    private double price;
    private boolean isDiscont;
    private LocalDate productDate;
    private final long id;

    public Product(Enum type, double price, boolean isDiscont, LocalDate localDate) {
        this.type = type;
        this.price = price;
        this.isDiscont = isDiscont;
        this.productDate = localDate;
        this.id = new Random().nextLong(50000);
    }

    public boolean isDiscont() {
        return isDiscont;
    }

    public void setDiscont(boolean discont) {
        isDiscont = discont;
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
        return isDiscont;
    }

    public void setDiscount(boolean discont) {
        isDiscont = discont;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", price=" + price +
                ", isDiscont=" + isDiscont +
                ", ProductDate=" + productDate +
                ", Product ID=" + id +
                '}';
    }
}
