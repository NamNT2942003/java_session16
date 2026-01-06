package Gioi2;

import java.util.ArrayList;
import java.util.List;

public class StoreManager {
    public static void main(String[] args) {
        List<Product> myProducts = new ArrayList<>();
        myProducts.add(new Product("Chuột Gaming", 50.0));
        myProducts.add(new Product("Bàn phím cơ", 150.0));
        myProducts.add(new Product("Tai nghe", 80.0));
        myProducts.add(new Product("Màn hình", 300.0));

        ProductProcessor processor = new ProductProcessorImpl();


        ProductProcessor.printProductList(myProducts);

        System.out.println("\n--- KẾT QUẢ XỬ LÝ ---");


        boolean hasExpensive = processor.hasExpensiveProduct(myProducts);
        if (hasExpensive) {
            System.out.println("Kiểm tra: Có sản phẩm giá > 100 trong danh sách.");
        } else {
            System.out.println("Kiểm tra: Không có sản phẩm đắt tiền.");
        }

        double total = processor.calculateTotalValue(myProducts);
        System.out.println("Tổng giá trị kho hàng: " + total);
    }
}
