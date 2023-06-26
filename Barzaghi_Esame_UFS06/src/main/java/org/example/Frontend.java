package org.example;
public class Frontend {

    private String up =
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

    private String down =
            "</table>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }
}
