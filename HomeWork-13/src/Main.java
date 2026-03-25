import java.util.Arrays;
import java.util.Objects;

public class Main {
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


        System.out.println("\n=== Тестирование класса Order ===\n");

        // Создание заказов
        Product[] basket1 = {product1, product4};
        Product[] basket2 = {product1, product4};
        Product[] basket3 = {product4, product1};
        Product[] basket4 = {product4, product5};
        Product[] basket5 = null;

        Order o1 = new Order("Иван", basket1);
        Order o2 = new Order("Иван", basket2);
        Order o3 = new Order("Иван", basket3);
        Order o4 = new Order("Иван", basket4);
        Order o5 = new Order("Петр", basket1);
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

        Product[] basket8 = {product4, product1};
        Product[] basket9 = {product4, product3};
        Product[] basket10 = {product4, null};

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


