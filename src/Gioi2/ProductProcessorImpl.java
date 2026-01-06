package Gioi2;

import java.util.List;

class ProductProcessorImpl implements ProductProcessor {
    @Override
    public double calculateTotalValue(List<Product> products) {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    @Override
    public boolean hasExpensiveProduct(List<Product> products) {
        return ProductProcessor.super.hasExpensiveProduct(products);
    }


}