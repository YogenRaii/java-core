package com.eprogrammerz.examples.java8.general.text_processing;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by 542596 on 1/4/2017.
 */
@Getter
@Setter
@ToString
public class BrandAndProduct {
    private Brand brand;
    private List<Product> products;
}
