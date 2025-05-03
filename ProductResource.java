package com.fawry.product_manager;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product-manager")
public class ProductResource {

    public ProductService productService = ProductService.getInstance();

    @POST
    @Path("/add-product")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addProduct(Product newProduct) {
        productService.addProduct(newProduct);
        return "Product with ID " + newProduct.getId() + " added successfully.";
    }

    @GET
    @Path("/get-product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int id) {
        return productService.getProduct(id);
    }

    @GET
    @Path("/get-all-products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PUT
    @Path("/update-product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateProduct(@PathParam("id") int id ,Product product) {
        productService.updateProduct(id,product);
        return "Product with ID " + product.getId() + " updated successfully.";
    }

    @DELETE
    @Path("/delete-product")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProduct(@QueryParam("id") int id) {
        productService.deleteProduct(id);
        return "Product with ID " + id + " deleted successfully.";
    }

}