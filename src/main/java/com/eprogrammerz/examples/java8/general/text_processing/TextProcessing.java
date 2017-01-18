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
        productLinks.put("image5", "/path/to/image3.png");
        Product product = new Product("NewProduct", productLinks);
        brandAndProduct.setBrand(brand);
        brandAndProduct.setProducts(Arrays.asList(product));
    }

    public static void main(String[] args) {
        //to verify String is immutable
//        String string = "Delta offered solution, not obstruction, for Qatar inaugural gate access";
//        String newString = string.replace("access", "great access");
//        System.out.println(string);
//        System.out.println(newString);

//need to find the texts with image urls ex. /path/to/image.jpg, /path/to/image1.jpg etc
        System.out.println(brandAndProduct);
        String brandAndProductString = brandAndProduct.toString();
        Pattern pattern = Pattern.compile("([^=.*]+\\.(?:jpg|png))", CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(brandAndProductString);
        String result = null;
        while (matcher.find()){
            result = brandAndProductString.replaceAll("([^=.*]+\\.(?:jpg|png))", "delta.com"+matcher.group());
        }
        System.out.println(result);
    }
}
