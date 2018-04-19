/*
 * Copyright (c) 2018.
 * MiniMarket application was made to demonstrate Java Fundamental 1 Syllabus.
 * Made using Intellij IDEA Community Edition version 2018.1
 */

package mitrais.inventory.product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class InputInventory {
    static Scanner userInput = new Scanner(System.in);
    private List<InstantNoodle> instantNoodles = new LinkedList<>();

    private void mainMenu() {
        System.out.println();
        System.out.println("Welcome to Mitrais IMS");
        System.out.println("======================");
        System.out.println("1. Insert inventory");
        System.out.println("2. Manage inventory");
        System.out.println("3. Exit");
    }

    private void insertInventory() {
        System.out.println();
        System.out.println("Insert inventory");
        System.out.println("================");
        System.out.println("1. Instant noodle");
        System.out.println("2. Back to main menu");
    }

    private void manageInventory(InputInventory ii) {
        int choice = 3;
        do {
            System.out.println();
            System.out.println("Manage inventory");
            System.out.println("================");
            int i = 1;
            for (InstantNoodle instantNoodle : instantNoodles) {
                System.out.printf("#%d %s\n", i++, instantNoodle.getName());
            }
            if (i == 1) {
                System.out.println("-No data available-");
                userInput.nextLine();
                choice = 3;
            } else {
                System.out.printf("%d items in total\n", instantNoodles.size());
                System.out.println("================");
                System.out.println("1. Update");
                System.out.println("2. Delete");
                System.out.println("3. Back to main menu");
                System.out.print("Your choice : ");
                try {
                    choice = userInput.nextInt();
                } catch (Exception e) {
                    choice = 0;
                } finally {
                    userInput.nextLine();
                }

                switch (choice) {
                    case 1:
                        ii.updateInventory();
                        break;
                    case 2:
                        ii.deleteInventory();
                        break;
                    default:
                        break;
                }
            }
        } while ((choice < 1 || choice > 3) || choice != 3);
    }

    private void updateInventory() {
        int number;

        do {
            try {
                System.out.print("Choose item # : ");
                number = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException nfe) {
                number = 0;
            }
        } while (number < 1 || number > instantNoodles.size());

        System.out.println("Item details :");
        System.out.printf("[%s, %s, %s, %s, %s, %.2f, %s, %s, %s]\n",
                instantNoodles.get(number - 1).getName(),
                instantNoodles.get(number - 1).getBrand(),
                instantNoodles.get(number - 1).getDescription(),
                instantNoodles.get(number - 1).getExpireDate().replace('/', '-'),
                (instantNoodles.get(number - 1).isHalal()) ? "Halal" : "Not halal",
                instantNoodles.get(number - 1).getPrice(),
                instantNoodles.get(number - 1).getProductType().getDescription() + " product",
                instantNoodles.get(number - 1).getTexture(),
                (instantNoodles.get(number - 1).isUtensils()) ? "Utensils included" : "No utensils");

        try {
            int sumPowder = instantNoodles.get(number - 1).getPowder().length;
            System.out.print("[");
            for (int i = 0; i < sumPowder; i++) {
                System.out.print(instantNoodles.get(number - 1).getPowder()[i]);
                if (i < sumPowder - 1) System.out.print(", ");
            }
            System.out.println("]");
        } catch (NullPointerException npe) {
            System.out.println();
            System.out.println("Powder");
            System.out.println("======");

            int totalPowder = 1;
            String[] powders;
            String[] temps = new String[1];
            String powder;

            char codePowder;
            do {
                do {
                    System.out.print("Input powder : ");
                    powder = userInput.nextLine();
                } while (powder.length() > 15);
                if (totalPowder == 1) {
                    powders = new String[totalPowder];
                    powders[totalPowder - 1] = powder;
                } else {
                    powders = new String[totalPowder];
                    System.arraycopy(temps, 0, powders, 0, totalPowder - 1);
                    powders[totalPowder - 1] = powder;
                }
                if (totalPowder == 1) {
                    temps[totalPowder - 1] = powder;
                } else {
                    temps = new String[totalPowder];
                    System.arraycopy(powders, 0, temps, 0, totalPowder);
                }

                do {
                    System.out.print("Add more powder (Y/N) : ");
                    codePowder = userInput.next().charAt(0);
                    userInput.nextLine();
                } while (codePowder != 'Y' && codePowder != 'N');
                if (codePowder == 'Y') totalPowder++;
            } while (codePowder == 'Y');

            instantNoodles.get(number - 1).setPowder(powders);
        }

        try {
            instantNoodles.get(number - 1).getNutritionFact().getServingPortionSize();
            System.out.printf("[%d %s, %d serving portion]\n",
                    instantNoodles.get(number - 1).getNutritionFact().getServingPortionSize(),
                    instantNoodles.get(number - 1).getNutritionFact().getServingPortionWeightScale().getDescription(),
                    instantNoodles.get(number - 1).getNutritionFact().getServingPortionAmount());
            for (Nutrition nutrition : instantNoodles.get(number - 1).getNutritionFact().getNutritions()) {
                System.out.printf("[%s %d %s, %d akg]\n",
                        nutrition.getName(),
                        nutrition.getAmount(),
                        nutrition.getWeightScale().getDescription(),
                        nutrition.getAkg());
            }
        } catch (NullPointerException npe) {
            System.out.println();
            System.out.println("Nutrition fact");
            System.out.println("==============");

            int servingPortionSize = 0;
            WeightScale servingPortionWeightScale;
            int servingPortionAmount = 0;

            Set<Nutrition> nutritions = new HashSet<>();
            String name;
            int amount = 0;
            WeightScale weightScale;
            int akg = 0;

            String code;
            boolean numberFormatException = false;
            char codeNutrition;

            do {
                System.out.print("Serving portion size : ");
                try {
                    servingPortionSize = Integer.parseInt(userInput.nextLine());
                    numberFormatException = false;
                } catch (NumberFormatException nfe) {
                    numberFormatException = true;
                }
            } while (numberFormatException);

            do {
                System.out.print("Serving portion weight scale (mg/g/kg/ml/l) : ");
                code = userInput.nextLine();
            }
            while (!code.equals("mg") && !code.equals("g") && !code.equals("kg") && !code.equals("ml") && !code.equals("l"));
            if (code.equals("mg")) servingPortionWeightScale = WeightScale.MILLIGRAM;
            else if (code.equals("g")) servingPortionWeightScale = WeightScale.GRAM;
            else if (code.equals("kg")) servingPortionWeightScale = WeightScale.KILOGRAM;
            else if (code.equals("ml")) servingPortionWeightScale = WeightScale.MILLILITER;
            else servingPortionWeightScale = WeightScale.LITER;

            do {
                System.out.print("Serving portion amount : ");
                try {
                    servingPortionAmount = Integer.parseInt(userInput.nextLine());
                    numberFormatException = false;
                } catch (NumberFormatException nfe) {
                    numberFormatException = true;
                }
            } while (numberFormatException);


            System.out.println();
            System.out.println("Nutrition detail");
            System.out.println("=========");
            do {
                do {
                    System.out.print("Name : ");
                    name = userInput.nextLine();
                } while (name.length() > 15);

                do {
                    System.out.print("Amount : ");
                    try {
                        amount = Integer.parseInt(userInput.nextLine());
                        numberFormatException = false;
                    } catch (NumberFormatException nfe) {
                        numberFormatException = true;
                    }
                } while (numberFormatException);

                do {
                    System.out.print("Weight scale (mg/g/kg/ml/l) : ");
                    code = userInput.nextLine();
                }
                while (!code.equals("mg") && !code.equals("g") && !code.equals("kg") && !code.equals("ml") && !code.equals("l"));
                if (code.equals("mg")) weightScale = WeightScale.MILLIGRAM;
                else if (code.equals("g")) weightScale = WeightScale.GRAM;
                else if (code.equals("kg")) weightScale = WeightScale.KILOGRAM;
                else if (code.equals("ml")) weightScale = WeightScale.MILLILITER;
                else weightScale = WeightScale.LITER;

                do {
                    System.out.print("Akg : ");
                    try {
                        akg = Integer.parseInt(userInput.nextLine());
                        numberFormatException = false;
                    } catch (NumberFormatException nfe) {
                        numberFormatException = true;
                    }
                } while (numberFormatException);

                Nutrition nutrition = new Nutrition(name, amount, weightScale, akg);
                nutritions.add(nutrition);

                do {
                    System.out.print("Add more nutrition (Y/N) : ");
                    codeNutrition = userInput.next().charAt(0);
                    userInput.nextLine();
                } while (codeNutrition != 'Y' && codeNutrition != 'N');
            } while (codeNutrition == 'Y');
            NutritionFact nutritionFact = new NutritionFact(servingPortionSize, servingPortionWeightScale, servingPortionAmount, nutritions);

            instantNoodles.get(number - 1).setNutritionFact(nutritionFact);
            System.out.print("Saved.");
            userInput.nextLine();
        }
    }

    private void deleteInventory() {
        int number;
        char code;

        do {
            try {
                System.out.print("Choose item # : ");
                number = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException nfe) {
                number = 0;
            }
        } while (number < 1 || number > instantNoodles.size());

        System.out.println("Item details :");
        System.out.printf("[%s, %s, %s, %s, %s, %.2f, %s, %s, %s]\n",
                instantNoodles.get(number - 1).getName(),
                instantNoodles.get(number - 1).getBrand(),
                instantNoodles.get(number - 1).getDescription(),
                instantNoodles.get(number - 1).getExpireDate().replace('/', '-'),
                (instantNoodles.get(number - 1).isHalal()) ? "Halal" : "Not halal",
                instantNoodles.get(number - 1).getPrice(),
                instantNoodles.get(number - 1).getProductType().getDescription() + " product",
                instantNoodles.get(number - 1).getTexture(),
                (instantNoodles.get(number - 1).isUtensils()) ? "Utensils included" : "No utensils");

        try {
            int sumPowder = instantNoodles.get(number - 1).getPowder().length;
            System.out.print("[");
            for (int i = 0; i < sumPowder; i++) {
                System.out.print(instantNoodles.get(number - 1).getPowder()[i]);
                if (i < sumPowder - 1) System.out.print(", ");
            }
            System.out.println("]");
        } catch (NullPointerException npe) {
        }

        try {
            instantNoodles.get(number - 1).getNutritionFact().getServingPortionSize();
            System.out.printf("[%d %s, %d serving portion]\n",
                    instantNoodles.get(number - 1).getNutritionFact().getServingPortionSize(),
                    instantNoodles.get(number - 1).getNutritionFact().getServingPortionWeightScale().getDescription(),
                    instantNoodles.get(number - 1).getNutritionFact().getServingPortionAmount());
            for (Nutrition nutrition : instantNoodles.get(number - 1).getNutritionFact().getNutritions()) {
                System.out.printf("[%s %d %s, %d akg]\n",
                        nutrition.getName(),
                        nutrition.getAmount(),
                        nutrition.getWeightScale().getDescription(),
                        nutrition.getAkg());
            }
        } catch (NullPointerException npe) {
        } finally {
            System.out.println();
            do {
                System.out.printf("Are you sure you want to delete '%s' (Y/N) : ", instantNoodles.get(number - 1).getName());
                code = userInput.next().charAt(0);
                userInput.nextLine();
            } while (code != 'Y' && code != 'N');

            if (code == 'Y') {
                instantNoodles.remove(number - 1);
                System.out.print("Deleted.");
                userInput.nextLine();
            }
        }
    }

    private void instantNoodle() {
        System.out.println();
        System.out.println("Insert instant noodle");
        System.out.println("====================");

        String name;
        String brand;
        String description;
        String expireDate;
        boolean halal;
        float price = 0;
        ProductType productType;
        String texture;
        boolean utensils;

        char code;
        boolean parseException = false;
        boolean numberFormatException = false;

        do {
            System.out.print("Name : ");
            name = userInput.nextLine();
        } while (name.length() > 15);

        do {
            System.out.print("Brand : ");
            brand = userInput.nextLine();
        } while (brand.length() > 15);

        do {
            System.out.print("Description : ");
            description = userInput.nextLine();
        } while (description.length() > 30);

        do {
            System.out.print("Expire date (MM/dd/yyyy) : ");
            expireDate = userInput.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate date = LocalDate.parse(expireDate, formatter);
                parseException = false;
            } catch (DateTimeParseException exc) {
                parseException = true;
            }
        } while (parseException);

        do {
            System.out.print("Halal (Y/N) : ");
            code = userInput.next().charAt(0);
            userInput.nextLine();
        } while (code != 'Y' && code != 'N');
        if (code == 'Y') halal = true;
        else halal = false;

        do {
            System.out.print("Price : ");
            try {
                price = Float.parseFloat(userInput.nextLine());
                numberFormatException = false;
            } catch (NumberFormatException nfe) {
                numberFormatException = true;
            }
        } while (numberFormatException);

        do {
            System.out.print("Product type (L/I) : ");
            code = userInput.next().charAt(0);
            userInput.nextLine();
        } while (code != 'L' && code != 'I');
        if (code == 'L') productType = ProductType.LOCAL;
        else productType = ProductType.IMPORT;

        do {
            System.out.print("Texture : ");
            texture = userInput.nextLine();
        } while (texture.length() > 15);

        do {
            System.out.print("Utensils (Y/N) : ");
            code = userInput.next().charAt(0);
            userInput.nextLine();
        } while (code != 'Y' && code != 'N');
        if (code == 'Y') utensils = true;
        else utensils = false;

        InstantNoodle instantNoodle = new InstantNoodle(name, brand, description, expireDate, halal, price, productType, texture, utensils);
        instantNoodles.add(instantNoodle);
        System.out.print("Saved.");
        userInput.nextLine();
    }

    public static void main(String[] args) {
        InputInventory ii = new InputInventory();

        int mainChoice;
        do {
            ii.mainMenu();
            System.out.print("Your choice : ");
            try {
                mainChoice = userInput.nextInt();
            } catch (Exception e) {
                mainChoice = 0;
            } finally {
                userInput.nextLine();
            }

            int choice;
            switch (mainChoice) {
                case 1:
                    do {
                        ii.insertInventory();
                        System.out.print("Your choice : ");
                        try {
                            choice = userInput.nextInt();
                        } catch (Exception e) {
                            choice = 0;
                        } finally {
                            userInput.nextLine();
                        }

                        switch (choice) {
                            case 1:
                                ii.instantNoodle();
                                break;
                            default:
                                break;
                        }
                    } while ((choice < 1 || choice > 2) || choice != 2);
                    break;
                case 2:
                    ii.manageInventory(ii);
                    break;
                default:
                    break;
            }
        } while ((mainChoice < 1 || mainChoice > 3) || mainChoice != 3);
        System.out.println("Program exited.");
    }
}
