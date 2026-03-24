import java.util.Arrays;
import java.util.Objects;

class Product {
    private int id;
    private String name;
    private int price;
    private String category;

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Товар[артикул=" + id + ", название=" + name + ", цена="
                + price + ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id &&
                Objects.equals(category, product.category);
    }
}

class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    public String getCustomer() {
        return customer;
    }

    public Product[] getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        return "Order[customer= " + customer +
                ", basket=" + Arrays.toString(basket) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;

        if (!Objects.equals(customer, order.customer)) return false;

        if (basket == null && order.basket == null) return true;
        if (basket == null || order.basket == null) return false;
        if (basket.length != order.basket.length) return false;

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null && order.basket[i] == null) continue;
            if (basket[i] == null || order.basket[i] == null) return false;
            if (!basket[i].equals(order.basket[i])) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, Arrays.hashCode(basket));
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование класса Product ===\n");

        Product produkt1 = new Product(1, "Ноутбук", 50000, "Электроника");
        Product produkt2 = new Product(1, "Smart TV", 60000, "Электроника");
        Product produkt3 = new Product(2, "Ноутбук", 50000, "Электроника");
        Product produkt4 = new Product(1, "Смартфон", 25000, "Гаджеты");
        Product produkt5 = new Product(1, "Товар", 50000, null);

        System.out.println("Товары:");
        System.out.println(produkt1);
        System.out.println(produkt2);
        System.out.println(produkt3);
        System.out.println(produkt4);
        System.out.println(produkt5);

        System.out.println("\nСравнение товаров:");
        System.out.println("produkt1.equals(produkt2): " + produkt1.equals(produkt2)); // true (id и category совпадают)
        System.out.println("produkt1.equals(produkt3): " + produkt1.equals(produkt3)); // false (разный id)
        System.out.println("produkt1.equals(produkt4): " + produkt1.equals(produkt4)); // true (id и category совпадают)
        System.out.println("produkt1.equals(produkt5): " + produkt1.equals(produkt5)); // false (разная category)
        System.out.println("produkt1.equals(null): " + produkt1.equals(null)); // false

        System.out.println("\n=== Тестирование класса Order ===\n");

        Product[] basket1 = {produkt1, produkt4};
        Product[] basket2 = {produkt1, produkt4};
        Product[] basket3 = {produkt4, produkt1}; // другой порядок
        Product[] basket4 = {produkt4, produkt5}; // другой товар
        Product[] basket5 = null;
        Product[] basket6 = {};

        Order o1 = new Order("Иван", basket1);
        Order o2 = new Order("Иван", basket2);
        Order o3 = new Order("Иван", basket3);
        Order o4 = new Order("Иван", basket4);
        Order o5 = new Order("Петр", basket1); // другой клиент
        Order o6 = new Order("Иван", basket5);


        System.out.println("Заказы:");
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);
        System.out.println(o6);


        System.out.println("\nСравнение заказов:");
        System.out.println("o1.equals(o2): " + o1.equals(o2)); // true (полное совпадение)
        System.out.println("o1.equals(o3): " + o1.equals(o3)); // false (разный порядок)
        System.out.println("o1.equals(o4): " + o1.equals(o4)); // false (разные товары)
        System.out.println("o1.equals(o5): " + o1.equals(o5)); // false (разный клиент)
        System.out.println("o1.equals(o6): " + o1.equals(o6)); // false (null массив)
        System.out.println("o1.equals(null): " + o1.equals(null)); // false

        System.out.println("\n=== Дополнительные тесты с null в товарах ===\n");

        Product[] basket8 = {produkt4, produkt1};
        Product[] basket9 = {produkt4, produkt3};
        Product[] basket10 = {produkt4, null};

        Order o8 = new Order("Анна", basket8);
        Order o9 = new Order("Анна", basket9);
        Order o10 = new Order("Анна", basket10);

        System.out.println(o8);
        System.out.println(o9);
        System.out.println(o10);

        System.out.println("\nСравнение заказов с null товарами:");
        System.out.println("o8.equals(o9): " + o8.equals(o9)); // true
        System.out.println("o8.equals(o10): " + o8.equals(o10)); // false (null в массиве)
    }
}