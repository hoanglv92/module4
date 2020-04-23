package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long area;
    private String name;
    @ManyToOne
    private Country country;
    private Long population;
    private Long gdp;
    @Column(length = 3000)
    private String description;

    public City() {
    }

    public City(Long id,String name, Long area, Country country, Long population, Long gdp, String description) {
        this.id = id;
        this.area = area;
        this.name=name;
        this.country = country;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City(String name,Long area, Country country, Long population, Long gdp, String description) {
        this.name=name;
        this.area = area;
        this.country = country;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGdp() {
        return gdp;
    }

    public void setGdp(Long gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
