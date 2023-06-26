package org.example;

import com.google.gson.Gson;

import java.util.*;

public class WineShop {
    private static WineShop INSTANCE;
    List<Wine> wineList = new ArrayList<>();
    private static final Gson gson = new Gson();


    private WineShop() {
        wineList.add(new Wine(1,125,"Ca del Bosco", "bollicine"));
        wineList.add(new Wine(2,80,"Val policella", "rosso"));
        wineList.add(new Wine(3,2.5,"Tavernello", "bianco"));
        wineList.add(new Wine(4,75,"Franciacorta", "bollicine"));
        wineList.add(new Wine(5,35,"A mano", "bianco"));
        wineList.add(new Wine(6,2.5,"Tavernello", "rosso"));
    }

    public static WineShop getInstance() {
        if (INSTANCE == null) INSTANCE = new WineShop();
        return INSTANCE;
    }

    public void add(Wine wine) {
        wineList.add(wine);
    }

    private String toJSON() {
        Frontend design = new Frontend();
        String responseString = design.getUp();
        for (Wine wine : wineList) {
            responseString += "<tr><td>" + wine.getId() + "</td> <td>"
                    + wine.getNome() + "</td> <td>"
                    + wine.getPrezzo() + "</td> <td>"
                    + wine.getTipo() + "</td> </tr>";
        }
        return responseString + design.getDown();
    }

    private String white() {
        Frontend design = new Frontend();
        List<Wine> whiteWines = new ArrayList<>();

        for (Wine wine : wineList) {
            if (wine.getTipo().equalsIgnoreCase("bianco")) {
                whiteWines.add(wine);
            }
        }

        String responseString = design.getUp();

        String jsonWine = "";
        Wine typeWine = null;
        for (Wine wine : whiteWines) {
            typeWine = wine;
            jsonWine = gson.toJson(wine);

            if (typeWine != null) {
                responseString += "<tr><td>" + typeWine.getId() + "</td> <td>"
                    + typeWine.getNome() + "</td> <td>"
                    + typeWine.getPrezzo() + "</td> <td>"
                    + typeWine.getTipo() + "</td> </tr>";
            }
        }
        return responseString + design.getDown();
    }


    private String red() {
        Frontend design = new Frontend();
        List<Wine> redWines = new ArrayList<>();

        for (Wine wine : wineList) {
            if (wine.getTipo().equalsIgnoreCase("rosso")) {
                redWines.add(wine);
            }
        }

        String responseString = design.getUp();
        String jsonWine = "";
        Wine typeWine = null;
        for (Wine wine : redWines) {
                typeWine = wine;
                jsonWine = gson.toJson(wine);

            if (typeWine != null) {
                responseString += "<tr><td>" + typeWine.getId() + "</td> <td>"
                    + typeWine.getNome() + "</td> <td>"
                    + typeWine.getPrezzo() + "</td> <td>"
                    + typeWine.getTipo() + "</td> </tr>";
            }
        }
        return responseString + design.getDown();
    }

    private String nameSorted() {
        Frontend design = new Frontend();
        String responseString = design.getUp();
        List<Wine> newwineList = new ArrayList<>(wineList);
        newwineList.sort(Comparator.comparing(Wine::getNome));
        for (Wine wine : newwineList) {
            responseString += "<tr><td>" + wine.getId() + "</td> <td>"
                    + wine.getNome() + "</td> <td>"
                    + wine.getPrezzo() + "</td> <td>"
                    + wine.getTipo() + "</td> </tr>";
        }
        return responseString + design.getDown();
    }

    private String priceSorted() {
        Frontend design = new Frontend();
        String responseString = design.getUp();
        List<Wine> newwineList = new ArrayList<>(wineList);
        newwineList.sort(Comparator.comparing(Wine::getPrezzo));
        for (Wine wine : newwineList) {
            responseString += "<tr><td>" + wine.getId() + "</td> <td>"
                    + wine.getNome() + "</td> <td>"
                    + wine.getPrezzo() + "</td> <td>"
                    + wine.getTipo() + "</td> </tr>";
        }
        return responseString + design.getDown();
    }

    String ShopActions(String command) {
        return switch (command.toLowerCase()) {
            case "all" -> toJSON();
            case "white" -> white();
            case "red" -> red();
            case "sorted_by_name" -> nameSorted();
            case "sorted_by_price" -> priceSorted();
            default -> "Comando Errato";
        };
    }
}