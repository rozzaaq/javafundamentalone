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
        purpose = "Enum weight scale"
)
public enum WeightScale {
    MILLIGRAM("miligram"),
    GRAM("gram"),
    KILOGRAM("kilogram"),
    MILLILITER("mililiter"),
    LITER("liter");

    private final String description;

    WeightScale(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
