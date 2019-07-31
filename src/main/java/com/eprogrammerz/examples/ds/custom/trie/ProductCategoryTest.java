package com.eprogrammerz.examples.ds.custom.trie;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class ProductCategory {
    List<Product> findByCategory(List<Product> products, String categoryName) {
        if (categoryProducts == null) {
            createCategoryProductsMap(products);
        }
        return categoryProducts.get(categoryName);
    }

    private void createCategoryProductsMap(List<Product> products) {
        this.categoryProducts = new HashMap<>();

        for (Product product: products) {
            Category category = product.getCategory();

            List<Product> existing = this.categoryProducts.get(category.getName());

            if (existing == null) {
                List<Product> newList = new ArrayList<>();
                newList.add(product);

                this.categoryProducts.put(category.getName(), newList);
            } else {
                existing.add(product);
            }
        }

    }

    private Map<String, List<Product>> categoryProducts = null;
}

public class ProductCategoryTest {


    /**
     *                                              Category
     *                                                  |
     *                              ------------------------------------------
     *                             |                    |                     |
     *                          Sports              Electronics             Apparel
     *                             |                    |                     |
     *               ----------------------     ---------------       -----------------------------
     *              |                      |   |               |     |             |               |
     *            Jersey            Footware  TV              Phone  Shirts     Pants             Atheltic
     *                                                                                             |
     *                                                                                    ------------------------
     *                                                                                   |                        |
     *                                                                                 Yoga                     Outdoor
     */
    @Test
    public void testProductsByCategory() {
        Category jersey = new Category(10, "Jersey", null);
        Category footware = new Category(11, "Footware", null);
        Category c1 = new Category(1, "Sports", Arrays.asList(jersey, footware));

        Category tv = new Category(12, "TV", null);
        Category phone = new Category(13, "Phone", null);
        Category c3 = new Category(3, "Electronics", Arrays.asList(tv, phone));


        Category c2 = new Category(2, "Apparel", null);

        Product p1 = new Product(1, "Nike Air Max 97", c1);
        Product p2 = new Product(2, "Nike T-Shirt", c2);
        Product p3 = new Product(3, "Jordon 97", c1);
        Product p4 = new Product(4, "Iphone 97", c3);
        Product p5 = new Product(5, "Samsung Washer and Dryer", c3);
        Product pJersey = new Product(6, "Barcelan", jersey);
        Product pFootware = new Product(7, "Nike Air", footware);

        List<Product> products = Arrays.asList(p1, p2, p3, p4, p5, pJersey, pFootware);


        ProductCategory pc = new ProductCategory();

        List<Product> apparels = pc.findByCategory(products, c2.getName());
        System.out.println(apparels);

        List<Product> sports = pc.findByCategory(products, c1.getName());
        System.out.println(sports);

        assertEquals(4, sports.size());
    }
}


@Data
@AllArgsConstructor
class Product {
    private int id;
    private String name;
    private Category category;
}

@Data
@AllArgsConstructor
class Category {
    private int id;
    private String name;

    List<Category> subCategories;
}