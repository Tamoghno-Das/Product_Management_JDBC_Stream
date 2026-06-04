package com.example.dao;

import com.example.exception.ProductException;
import com.example.model.Product;

import java.util.List;

public interface ProductDAO
{
    void addProduct(Product product)
            throws ProductException;
    void updateProduct(Product product)
            throws ProductException;
    void deleteProduct(int id)
            throws ProductException;
    Product getProductById(int id)
            throws ProductException;
    List<Product> getAllProducts()
            throws ProductException;
    List<Product> searchByCategory(String category)
            throws ProductException;
    List<Product> searchByPriceRange(double min,double max)
            throws ProductException;

}
