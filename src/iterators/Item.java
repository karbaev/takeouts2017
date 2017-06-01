package iterators;

/**
 * Created by Danila on 29.05.2017.
 */
public class Item extends MenuComponent {
    String name;
    double price;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }


}
