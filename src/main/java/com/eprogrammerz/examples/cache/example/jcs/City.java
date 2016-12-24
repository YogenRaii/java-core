package com.eprogrammerz.examples.cache.example.jcs;

import java.io.Serializable;

/**
 * Created by 542596 on 12/9/2016.
 */
public class City implements Serializable {
    public String name;
    public String country;
    public int population;

    public City( String name, String country, int population )
    {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString()
    {
        return String.format( "%s is a city in the country %s with a population of %d", name, country, population );
    }
}
