package com.example.nutritionapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalorieninjasController {

    private static final String RAPID_API_KEY = "3fe421aa57mshdfd4147f4d4c319p1ba7f4jsnca7d59efce2d";
    private static final String RAPID_API_HOST = "calorieninjas.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/calorieninjas")
    public ResponseEntity<String> getData(@RequestParam(value = "query", required = false) String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", RAPID_API_KEY);
        headers.set("X-RapidAPI-Host", RAPID_API_HOST);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = "https://calorieninjas.p.rapidapi.com/v1/nutrition";
        if(query != null) {
            url += "?query=" + query;
        }
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}
