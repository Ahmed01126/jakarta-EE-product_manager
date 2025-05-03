package com.fawry.product_manager;

import jakarta.ws.rs.BadRequestException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService implements ProductServiceInterface {
    private final HashMap<Integer,Product> products = new HashMap<>();

    private ProductService(){}

    public static class singletonHolder {
        private static final ProductService INSTANCE = new ProductService();
    }

    public static ProductService getInstance() {
        return singletonHolder.INSTANCE;
    }

    public void addProduct(Product product) {
        int id = product.getId();
        String name = product.getName();
        double price = product.getPrice();
        int quantity = product.getQuantity();

        if(products.get(id) != null) {
            throw new BadRequestException("Product with ID " + id + " already exists");
        }
        if (id <= 0 || name == null || name.isEmpty() || price <= 0 || quantity < 0) {
            throw new BadRequestException("Invalid product details");
        }
        products.put(id, product);
    }

    public Product getProduct(int id) {
        if(products.get(id) == null) {
            throw new BadRequestException("Product with ID " + id + " not found for retrieval");
        }
        return products.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public void updateProduct(int id,Product product) {
        if(products.get(id) == null) {
            throw new BadRequestException("Product with ID " + id + " not found for update");
        }
        products.put(id, product);
    }

    public void deleteProduct(int id) {
        if(products.get(id) == null) {
            throw new BadRequestException("Product with ID " + id + " not found for deletion");
        }
        products.remove(id);
    }

}
