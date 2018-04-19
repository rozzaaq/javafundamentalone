/*
 * Copyright (c) 2018.
 * MiniMarket application was made to demonstrate Java Fundamental 1 Syllabus.
 * Made using Intellij IDEA Community Edition version 2018.1
 */

package mitrais.inventory.product;

import java.util.List;
import java.util.Set;

@ClassInformation(
        author = "Ready Prima Rozzaaq",
        date = "04/16/2018",
        currentRevision = 1,
        lastModified = "04/16/2018",
        lastModifiedBy = "Ready Prima Rozzaaq",
        reviewers = {"Ready"},
        purpose = "Abstract class for all type of product"
)
public class NutritionFact {
    private int servingPortionSize;
    private WeightScale servingPortionWeightScale;
    private int servingPortionAmount;
    private Set<Nutrition> nutritions; //to demonstrate only, should be List, as Set will return unordered value, that it will randomize the printed text

    public int getServingPortionSize() {
        return servingPortionSize;
    }

    public void setServingPortionSize(int servingPortionSize) {
        this.servingPortionSize = servingPortionSize;
    }

    public WeightScale getServingPortionWeightScale() {
        return servingPortionWeightScale;
    }

    public void setServingPortionWeightScale(WeightScale servingPortionWeightScale) {
        this.servingPortionWeightScale = servingPortionWeightScale;
    }

    public int getServingPortionAmount() {
        return servingPortionAmount;
    }

    public void setServingPortionAmount(int servingPortionAmount) {
        this.servingPortionAmount = servingPortionAmount;
    }

    public Set<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Set<Nutrition> nutritions) {
        this.nutritions = nutritions;
    }

    public NutritionFact(int servingPortionSize, WeightScale servingPortionWeightScale, int servingPortionAmount, Set<Nutrition> nutritions) {
        this.servingPortionSize = servingPortionSize;
        this.servingPortionWeightScale = servingPortionWeightScale;
        this.servingPortionAmount = servingPortionAmount;
        this.nutritions = nutritions;
    }
}