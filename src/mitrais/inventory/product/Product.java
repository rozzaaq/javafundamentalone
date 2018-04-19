/*
 * Copyright (c) 2018.
 * MiniMarket application was made to demonstrate Java Fundamental 1 Syllabus.
 * Made using Intellij IDEA Community Edition version 2018.1
 */

package mitrais.inventory.product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@ClassInformation(
        author = "Ready Prima Rozzaaq",
        date = "04/16/2018",
        currentRevision = 1,
        lastModified = "04/16/2018",
        lastModifiedBy = "Ready Prima Rozzaaq",
        reviewers = {"Ready"},
        purpose = "Abstract class for all type of product"
)
public abstract class Product implements Expiration {
    //private state public method for encapsulation
    private static int totalProduct; //can only be accessed by this class only
    private String name;
    private String brand;
    private String description;
    private NutritionFact nutritionFact;
    private Map<Integer, String> categories; //will contained e.g. Best seller, Product of the day, Product of the month, etc
    private String expireDate;
    private boolean halal;
    private float price;
    private ProductType productType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NutritionFact getNutritionFact() {
        return nutritionFact;
    }

    public void setNutritionFact(NutritionFact nutritionFact) {
        this.nutritionFact = nutritionFact;
    }

    public Map<Integer, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<Integer, String> categories) {
        this.categories = categories;
    }

    @Override
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String getExpireDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(expireDate, formatter);
        date = date.plusYears(1).plusMonths(1).plusDays(1);
        return date.toString();
    }

    public boolean isHalal() {
        return halal;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Product() {
        totalProduct++;
    }

    //overload
    public Product(String name, String brand, String description, String expireDate, boolean halal, float price, ProductType productType) {
        this();
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.expireDate = expireDate;
        this.halal = halal;
        this.price = price;
        this.productType = productType;
    }
}
