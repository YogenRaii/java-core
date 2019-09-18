package com.eprogrammerz.examples.ds.custom.trie;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class ProductService {
    List<Product> findByCategory(List<Product> products, String categoryName) {
        if (categoryProducts == null) {
            createCategoryProductsMap(products);
        }
        List<Product> cProducts = categoryProducts.get(categoryName);

        List<Product> result = new ArrayList<>();

        if (cProducts != null && cProducts.size() > 0) {
            result.addAll(cProducts);
        }
        Category category = categoryMap.get(categoryName);
        if (category != null) {
            List<Category> subCategories = category.getSubCategories();
            if (subCategories != null) {
                for (Category c : subCategories) {
                    List<Product> subProducts = findByCategory(products, c.getName());
                    result.addAll(subProducts);
                }
            }
        }
        return result;
    }

    private void createCategoryProductsMap(List<Product> products) {
        this.categoryProducts = new HashMap<>();
        this.categoryMap = new HashMap<>();

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
            populateCategoryMap(category);
        }

    }

    private void populateCategoryMap(Category category) {
        if (!categoryMap.containsKey(category.getName())) {
            categoryMap.put(category.getName(), category);

            List<Category> subCategories = category.getSubCategories();

            if (subCategories != null) {
                for (Category subCategory: subCategories) {
                    populateCategoryMap(subCategory);
                }
            }
        }
    }

    private Map<String, List<Product>> categoryProducts = null;
    private Map<String, Category> categoryMap = null;
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
     *            Jersey            Footware  TV              Phone  Shirts     Pants             Athletic
     *                                                                                             |
     *                                                                                    ------------------------
     *                                                                                   |                        |
     *                                                                                 Yoga                     Outdoor
     */
    @Test
    public void testProductsByCategory() {
        Category jersey = new Category(10, "Jersey", null);
        Category footware = new Category(11, "Footware", null);
        Category sports = new Category(1, "Sports", Arrays.asList(jersey, footware));

        Category tv = new Category(12, "TV", null);
        Category phone = new Category(13, "Phone", null);
        Category electronics = new Category(3, "Electronics", Arrays.asList(tv, phone));


        Category shirts = new Category(14, "Shirts", null);
        Category pants = new Category(15, "Panys", null);
        Category yoga = new Category(20, "Yoga", null);
        Category outdoor = new Category(21, "Outdoor", null);
        Category athletic = new Category(16, "Athletic", Arrays.asList(yoga, outdoor));
        Category apparel = new Category(2, "Apparel", Arrays.asList(shirts, pants, athletic));

        Product p1 = new Product(1, "Nike Air Max 97", sports);
        Product p2 = new Product(2, "Nike T-Shirt", apparel);
        Product p3 = new Product(3, "Jordon 97", sports);
        Product p4 = new Product(4, "Iphone 97", electronics);
        Product p5 = new Product(5, "Samsung Washer and Dryer", electronics);
        Product pJersey = new Product(6, "Barcelan", jersey);
        Product pFootware = new Product(7, "Nike Air", footware);
        Product luluman = new Product(8, "Yoga Pants", yoga);

        List<Product> products = Arrays.asList(p1, p2, p3, p4, p5, pJersey, pFootware, luluman);


        ProductService pc = new ProductService();

        List<Product> apparels = pc.findByCategory(products, apparel.getName());
        System.out.println(apparels);
        assertEquals(2, apparels.size());

        List<Product> sportsProducts = pc.findByCategory(products, sports.getName());
        System.out.println(sportsProducts);

        assertEquals(4, sportsProducts.size());
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