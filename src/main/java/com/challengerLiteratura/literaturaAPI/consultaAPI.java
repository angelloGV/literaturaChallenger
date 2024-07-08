package com.challengerLiteratura.literaturaAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consultaAPI {

    HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    HttpResponse<String> response = null;

    public consultaAPI(){};

    private final String BASE_URL = "https://gutendex.com/books";

    public String getDataAPI(String libro)
    {
        var busqueda = BASE_URL + "/?search="+  libro.replace(" ","+");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busqueda))
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        String json = response.body();

        return json;

    }
}
