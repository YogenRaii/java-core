package com.eprogrammerz.examples.cache.example.springCache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by 542596 on 12/9/2016.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class City implements Serializable {
    public String name;
    public String country;
    public int population;
}
