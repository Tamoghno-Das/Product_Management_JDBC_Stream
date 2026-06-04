package com.example.main;

import com.example.dao.ProductDAO;
import com.example.dao.ProductDAOImpl;
import com.example.model.Product;
import com.example.service.ProductStreamService;

import java.util.List;
import java.util.Scanner;

public class ProductDashBoard {
    static void main() {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAOImpl();
        while (true) {
            System.out.println("""
                    
                    ===== PRODUCT MANAGEMENT =====
                    
                    1 Add Product
                    2 View Product
                    3 Update Product
                    4 Delete Product
                    5 View All Products
                    6 Search By Category
                    7 Search By Price Range
                    8 Stream API Practice
                    9 Exit
                    
                    Enter Choice
                    """);
            int choice = sc.nextInt();

            try
            {
                switch(choice)
                {
                    case 1 ->
                    {
                        Product p=
                                new Product(
                                        101,
                                        "Laptop",
                                        "Electronics",
                                        55000,
                                        5);
                        dao.addProduct(p);
                    }
                    case 2 ->
                    {
                        System.out.println(
                                dao.getProductById(101));
                    }
                    case 3 ->
                    {
                        Product p=
                                new Product(
                                        101,
                                        "Laptop",
                                        "Electronics",
                                        65000,
                                        10);
                        dao.updateProduct(p);
                    }

                    case 4 ->
                    {
                        dao.deleteProduct(101);
                    }
                    case 5 ->
                    {
                        dao.getAllProducts().forEach(IO::println);
                    }
                    case 6 ->
                    {
                        dao.searchByCategory("Electronics").forEach(IO::println);
                    }
                    case 7 ->
                    {
                        dao.searchByPriceRange(100,50000).forEach(IO::println);
                    }
                    case 8 ->
                    {
                        List<Product> products=
                                dao.getAllProducts();
                        ProductStreamService
                                .executeAllStreams(products);
                    }
                    case 9 ->
                    {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid Choice");
                    }

                }
                }
            catch (Exception e )
            {
                IO.println(e.getMessage());
            }


        }
    }
}
