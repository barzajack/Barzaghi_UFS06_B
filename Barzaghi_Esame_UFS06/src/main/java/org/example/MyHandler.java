package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        URI uri = exchange.getRequestURI();
        System.out.println(uri);

        String query = uri.getQuery();
        String command = "";
        if (query != null && query.startsWith("cmd=")) {
            command = query.substring(4);
        }

        String response = WineShop.getInstance().ShopActions(command);

        String requestBody = read(is);
        System.out.println(requestBody);

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String read(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("\n");
        StringBuilder received = new StringBuilder();
        while (true) {
            String s = "";
            try {
                if ((s = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s);
            received.append(s);
        }
        return received.toString();
    }
}
