import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<MenuItem> items;
    private List<Integer> quantities;

    public Order() {
        items = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(MenuItem item, int quantity) {
        items.add(item);
        quantities.add(quantity);
    }

    public double calculateTotal() {
        double total = 0;
                for (int i = 0; i < items.size(); i++) {
                    total += items.get(i).getPrice() * quantities.get(i);
                }
        return total;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }
}

class Receipt {
    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println("-------- Nota Pemesanan --------");
        List<MenuItem> items = order.getItems();
        List<Integer> quantities = order.getQuantities();

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%s x %d = %.2f\n", items.get(i).getName(), quantities.get(i),
                    items.get(i).getPrice() * quantities.get(i));
        }
        double total = order.calculateTotal();
        System.out.printf("Total: %.2f\n", total);
        System.out.println("-------------------------------");
    }
}

public class RestaurantOrderApp {
    public static void main(String[] args) {
        // Membuat item menu
        MenuItem nasiGoreng = new MenuItem("Nasi Goreng", 20000);
        MenuItem ayamGoreng = new MenuItem("Ayam Goreng", 25000);
        MenuItem esTeh = new MenuItem("Es Teh", 5000);

        // Membuat pesanan
        Order order = new Order();
        order.addItem(nasiGoreng, 2);  // 2 Nasi Goreng
        order.addItem(ayamGoreng, 1);   // 1 Ayam Goreng
        order.addItem(esTeh, 3);        // 3 Es Teh

        // Mencetak nota
        Receipt receipt = new Receipt(order);
        receipt.printReceipt();
    }
}
