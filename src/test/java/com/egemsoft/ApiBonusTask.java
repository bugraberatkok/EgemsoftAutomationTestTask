package com.egemsoft;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * EGEMSOFT Ekstra / Bonus Görev (İsteğe Bağlı)
 * 
 * API 1: Get All Products List
 * API URL: https://automationexercise.com/api/productsList
 * Request Method: GET
 * Response Code: 200
 * 
 * Görev: Yukarıdaki API uç noktasına GET isteği atarak dönen cevaptaki
 * ilk 10 ürünün adını (product name) konsola yazdıran kurguyu oluşturunuz.
 */
public class ApiBonusTask {

    String apiUrl = "https://automationexercise.com/api/productsList";

    @Test
    public void testGetFirstTenProducts() throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());

        System.out.println("Response Status Code: " + response.statusCode());
        String responseBody = response.body();

        Pattern productNamePattern = Pattern.compile("\"name\"\\s*:\\s*\"([^\"]+)\"");

        Matcher matcher = productNamePattern.matcher(responseBody);

        int productCount = 0;

        System.out.println("=== İlk 10 ürün ===");

        while (matcher.find() && productCount < 10) {
            productCount++;

            String productName = matcher.group(1);

            System.out.println(productCount + ". " + productName);
        }

        assertEquals(10, productCount, "Response içerisinde 10 ürün bulunamadı!");
    }
}
