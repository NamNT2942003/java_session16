package Gioi2;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {
    double calculateTotalValue(List<Product> products);
    static void printProductList(List<Product> products) {
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        if (products == null || products.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }
    default boolean hasExpensiveProduct(List<Product> products) {
        Predicate<Product> isExpensive = p -> p.getPrice() > 100;
        for (Product p : products) {
            if (isExpensive.test(p)) {
                return true;
            }
        }
        return false;
    }
}
