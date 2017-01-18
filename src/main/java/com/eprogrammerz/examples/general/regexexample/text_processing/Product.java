package com.eprogrammerz.examples.general.regexexample.text_processing;

import lombok.*;

import java.util.Map;

/**
 * Created by 542596 on 1/4/2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private String id;
    private Map<String, String> linkedProducts;
}
