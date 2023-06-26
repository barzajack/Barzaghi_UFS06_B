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
        if (INSTANCE == null) {
            INSTANCE = new WineShop();
        }

        return INSTANCE;
    }

    public void add(Wine wine) {
        wineList.add(wine);
    }

    private String toJSON() {
        String responseString = "<!DOCTYPE html>" +
                "<html>" +
                "<style>" +
                " body{ " +
                " background-color: lightblue" +
                "}" +
                "table, th, td {" +
                "  border:1px solid black;" +
                "}" +
                "</style>" +
                "<body>" + "<h2>HTML Response Table</h2>" +
                "<table style=\"width:100%\">" +
                "<tr>" +
                "<th>ID</th>" +
                "<th>Nome</th>" +
                "<th>Prezzo</th>" +
                "<th>Tipo</th>" +
                "</tr>";
        for (Wine wine : wineList) {
            responseString += "<tr><td>" + wine.getId() + "</td> <td>"
                    + wine.getNome() + "</td> <td>"
                    + wine.getPrezzo() + "</td> <td>"
                    + wine.getTipo() + "</td> </tr>";

        }
        responseString += "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return responseString;
    }

    private String white() {
        List<Wine> whiteWines = new ArrayList<>();

        for (Wine wine : wineList) {
            if (wine.getTipo().equalsIgnoreCase("bianco")) {
                whiteWines.add(wine);
            }
        }

        String responseString = "<!DOCTYPE html>" +
                "<html>" +
                "<style>" +
                " body{ " +
                " background-color: lightblue" +
                "}" +
                "table, th, td {" +
                "  border:1px solid black;" +
                "}" +
                "</style>" +
                "<body>" + "<h2>HTML Response Table</h2>" +
                "<table style=\"width:100%\">" +
                "<tr>" +
                "<th>ID</th>" +
                "<th>Nome</th>" +
                "<th>Prezzo</th>" +
                "<th>Quantita</th>" +
                "</tr>";

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

        return responseString +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }



    private String red() {
        List<Wine> redWines = new ArrayList<>();

        for (Wine wine : wineList) {
            if (wine.getTipo().equalsIgnoreCase("rosso")) {
                redWines.add(wine);
            }
        }

        String responseString = "<!DOCTYPE html>" +
                "<html>" +
                "<style>" +
                " body{ " +
                " background-color: lightblue" +
                "}" +
                "table, th, td {" +
                "  border:1px solid black;" +
                "}" +
                "</style>" +
                "<body>" + "<h2>HTML Response Table</h2>" +
                "<table style=\"width:100%\">" +
                "<tr>" +
                "<th>ID</th>" +
                "<th>Nome</th>" +
                "<th>Prezzo</th>" +
                "<th>Quantita</th>" +
                "</tr>";
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

        return responseString +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    private String nameSorted() {
        String responseString =
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<style>" +
                        " body{ " +
                        " background-color: lightblue" +
                        "}" +
                        "table, th, td {" +
                        "  border:1px solid black;" +
                        "}" +
                        "</style>" +
                        "<body>" + "<h2>HTML Response Table</h2>" +
                        "<table style=\"width:100%\">" +
                        "<tr>" +
                        "<th>ID</th>" +
                        "<th>Nome</th>" +
                        "<th>Prezzo</th>" +
                        "<th>Quantita</th>" +
                        "</tr>";
        List<Wine> newwineList = new ArrayList<>(wineList);
        newwineList.sort(Comparator.comparing(Wine::getNome));
        for (Wine wine : newwineList) {
            responseString += "<tr><td>" + wine.getId() + "</td> <td>"
                    + wine.getNome() + "</td> <td>"
                    + wine.getPrezzo() + "</td> <td>"
                    + wine.getTipo() + "</td> </tr>";
        }
        responseString += "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return responseString;
    }

    private String priceSorted() {
        String responseString =
                "<!DOCTYPE html>" +
                "<html>" +
                    "<style>" +
                        " body{ " +
                        " background-color: lightblue" +
                        "}" +
                        "table, th, td {" +
                        "  border:1px solid black;" +
                    "}" +
                    "</style>" +
                    "<body>" + "<h2>HTML Response Table</h2>" +
                        "<table style=\"width:100%\">" +
                        "<tr>" +
                            "<th>ID</th>" +
                            "<th>Nome</th>" +
                            "<th>Prezzo</th>" +
                            "<th>Quantita</th>" +
                        "</tr>";
        List<Wine> newwineList = new ArrayList<>(wineList);
        newwineList.sort(Comparator.comparing(Wine::getPrezzo));
        for (Wine wine : newwineList) {
            responseString += "<tr><td>" + wine.getId() + "</td> <td>"
                    + wine.getNome() + "</td> <td>"
                    + wine.getPrezzo() + "</td> <td>"
                    + wine.getTipo() + "</td> </tr>";
        }
        responseString += "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return responseString;
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