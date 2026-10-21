package com.mbtec.staffnoc.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbtec.staffnoc.domain.Team;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TeamAPIClient {

    private static final String BASE_URL = "http://localhost:8080/team";

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // GET /team/list
    public List<Team> list() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/list"))
                .GET()
                .build();

        return mapper.readValue(send(request), new TypeReference<List<Team>>() {});
    }

    // POST /team/create
    public String create(Team team) throws Exception {
        String json = mapper.writeValueAsString(team);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/create"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return send(request);
    }

    // PUT /team/update/{id}
    public String update(int id, Team team) throws Exception {
        String json = mapper.writeValueAsString(team);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/update/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return send(request);
    }

    // DELETE /team/delete/{id}
    public String delete(int id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/delete/" + id))
                .DELETE()
                .build();

        return send(request);
    }

    // GET /team/search/{text}
    public List<Team> search(String text) throws Exception {
        String encoded = URLEncoder.encode(text, StandardCharsets.UTF_8).replace("+", "%20");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/search/" + encoded))
                .GET()
                .build();

        return mapper.readValue(send(request), new TypeReference<List<Team>>() {});
    }

    // Envia o pedido e devolve o corpo da resposta; lança erro se a API falhar
    private String send(HttpRequest request) throws Exception {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();

        if (status < 200 || status >= 300) {
            throw new RuntimeException("API error " + status + ": " + response.body());
        }
        return response.body();
    }
}
