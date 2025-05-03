package com.fawry.product_manager;

import java.util.List;

public interface ProductServiceInterface {

    void addProduct(Product product);

    void updateProduct(int id, Product product);

    Product getProduct(int id);

    void deleteProduct(int id);

    List<Product> getAllProducts();
}
