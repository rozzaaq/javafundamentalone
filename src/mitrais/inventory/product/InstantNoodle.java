/*
 * Copyright (c) 2018.
 * MiniMarket application was made to demonstrate Java Fundamental 1 Syllabus.
 * Made using Intellij IDEA Community Edition version 2018.1
 */

package mitrais.inventory.product;

import java.util.Map;

@ClassInformation(
        author = "Ready Prima Rozzaaq",
        date = "04/16/2018",
        currentRevision = 1,
        lastModified = "04/16/2018",
        lastModifiedBy = "Ready Prima Rozzaaq",
        reviewers = {"Ready"},
        purpose = "Final sub class instant noodle"
)
public final class InstantNoodle extends Food {
    private boolean utensils;
    private String[] powder;

    public boolean isUtensils() {
        return utensils;
    }

    public void setUtensils(boolean utensils) {
        this.utensils = utensils;
    }

    public String[] getPowder() {
        return powder;
    }

    public void setPowder(String[] powder) {
        this.powder = powder;
    }

    @Override
    public String getTexture() {
        return super.getTexture() + " texture";
    }

    public InstantNoodle(String name, String brand, String description, String expireDate, boolean halal, float price, ProductType productType, String texture, boolean utensils) {
        super(name, brand, description, expireDate, halal, price, productType, texture);
        this.utensils = utensils;
    }
}
