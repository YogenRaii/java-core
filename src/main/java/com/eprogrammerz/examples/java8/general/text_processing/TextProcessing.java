package com.eprogrammerz.examples.java8.general.text_processing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

/**
 * Created by 542596 on 1/9/2017.
 */
public class TextProcessing {

    private static BrandAndProduct brandAndProduct;

    static {
        brandAndProduct = new BrandAndProduct();
        Brand brand = new Brand("NewBrand");
        Map<String, String> productLinks = new HashMap<>();
        productLinks.put("iphone", "Delta offered solution, not obstruction, for Qatar inaugural gate access");
        productLinks.put("image1", "/path/to/image.jpg");
        productLinks.put("image2", "/path/to/image1.jpg");
        productLinks.put("image3", "/path/to/image2.jpg");
        productLinks.put("image4", "/path/to/image3.jpg");
        Product product = new Product("NewProduct", productLinks);
        brandAndProduct.setBrand(brand);
        brandAndProduct.setProducts(Arrays.asList(product));
    }

    public static void main(String[] args) {

        System.out.println(brandAndProduct);

        //need to find the texts with image urls ex. /path/to/image.jpg, /path/to/image1.jpg etc
//        Pattern pattern = Pattern.compile("(/.*\\.(?:png|jpg))", CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("(?:/[^/#?]+)+\\.(?:jpg|gif|png)", CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(brandAndProduct.toString());
        if(matcher.find()){
            System.out.println("Matched....");
            System.out.println(matcher.group());
        }
    }
}
