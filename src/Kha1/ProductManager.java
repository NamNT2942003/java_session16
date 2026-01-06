package Kha1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {
    private static Map<Integer, Product> products = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ SẢN PHẨM ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị tất cả");
            System.out.println("5. Tìm sản phẩm giá > 100 (Streams)");
            System.out.println("6. Tính tổng giá trị (Streams)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1: addProduct(); break;
                case 2: editProduct(); break;
                case 3: deleteProduct(); break;
                case 4: showAll(); break;
                case 5: filterProducts(); break;
                case 6: calculateTotal(); break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default: System.out.println("Chức năng không hợp lệ!");
            }
        }
    }
    private static void addProduct() {
        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (products.containsKey(id)) {
                System.out.println("Lỗi: ID này đã tồn tại!");
                return;
            }

            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();

            System.out.print("Nhập giá: ");
            double price = Double.parseDouble(scanner.nextLine());

            Product p = new Product(id, name, price);
            products.put(id, p);
            System.out.println("Đã thêm thành công!");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Nhập sai định dạng số.");
        }
    }
    private static void editProduct() {
        System.out.print("Nhập ID cần sửa: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (products.containsKey(id)) {
                Product p = products.get(id);
                System.out.println("Thông tin cũ: " + p);

                System.out.print("Nhập tên mới: ");
                String newName = scanner.nextLine();
                System.out.print("Nhập giá mới: ");
                double newPrice = Double.parseDouble(scanner.nextLine());

                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Không tìm thấy sản phẩm có ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Nhập sai định dạng.");
        }
    }
    private static void deleteProduct() {
        System.out.print("Nhập ID cần xóa: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (products.containsKey(id)) {
                products.remove(id);
                System.out.println("Đã xóa sản phẩm ID " + id);
            } else {
                System.out.println("Không tìm thấy ID này.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi nhập liệu.");
        }
    }
    private static void showAll() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("--- Danh sách sản phẩm ---");
            for (Product p : products.values()) {
                System.out.println(p);
            }
        }
    }
    private static void filterProducts() {
        System.out.println("--- Các sản phẩm có giá > 100 ---");
        products.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }
    private static void calculateTotal() {
        double total = products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.printf("Tổng giá trị tất cả sản phẩm: %,.2f\n", total);
    }
}
