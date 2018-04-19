/*
 * Copyright (c) 2018.
 * MiniMarket application was made to demonstrate Java Fundamental 1 Syllabus.
 * Made using Intellij IDEA Community Edition version 2018.1
 */

package mitrais.inventory.product;

@ClassInformation(
        author = "Ready Prima Rozzaaq",
        date = "04/16/2018",
        currentRevision = 1,
        lastModified = "04/16/2018",
        lastModifiedBy = "Ready Prima Rozzaaq",
        reviewers = {"Ready"},
        purpose = "Abstract class for all type of product"
)
public class Nutrition {
    private String name;
    private int amount;
    private WeightScale weightScale;
    private int akg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public WeightScale getWeightScale() {
        return weightScale;
    }

    public void setWeightScale(WeightScale weightScale) {
        this.weightScale = weightScale;
    }

    public int getAkg() {
        return akg;
    }

    public void setAkg(int akg) {
        this.akg = akg;
    }

    public Nutrition(String name, int amount, WeightScale weightScale, int akg) {
        this.name = name;
        this.amount = amount;
        this.weightScale = weightScale;
        this.akg = akg;
    }

}
