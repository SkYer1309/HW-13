import java.util.Objects;

public class Product {
    private  int id;
    private  String name;
    private  int price;
    private  String category;

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

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    public static void main(String[] args) {

        System.out.println("=== Тестирование класса Product ===\n");

        Product product1 = new Product(1, "Ноутбук", 50000, "Электроника");
        Product product2 = new Product(1, "Smart TV", 60000, "Электроника");
        Product product3 = new Product(2, "Ноутбук", 50000, "Электроника");
        Product product4 = new Product(1, "Смартфон", 25000, "Гаджеты");
        Product product5 = new Product(1, "Товар", 50000, null);


        System.out.println("Товары:");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product4);
        System.out.println(product5);

        System.out.println("\nСравнение товаров:");
        System.out.println("product1.equals(product2): " + product1.equals(product2));
        System.out.println("product1.equals(product3): " + product1.equals(product3));
        System.out.println("product1.equals(product4): " + product1.equals(product4));
        System.out.println("product1.equals(product5): " + product1.equals(product5));
        System.out.println("product1.equals(null): " + product1.equals(null));

    }
}
