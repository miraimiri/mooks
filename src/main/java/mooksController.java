package main.java;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class mooksController {
    @GetMapping("/")
    public String index() {
        return "Greetings from SpringBoot!";
    }

    @GetMapping("/movies/popular")
    public String getPopularMovies(){
        String uri = "https://imdb-api.com/en/API/MostPopularMovies/k_0w8gobka";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/movie/title/{title}")
    public String getMovieByTitle(@PathVariable String title) {
        String uri = String.format("https://imdb-api.com/en/API/SearchTitle/k_0w8gobka/%s", title);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }


    @GetMapping("/movie/actor/{name}")
    public String getMovieByActor(@PathVariable String name) {
        String uri = String.format("https://imdb-api.com/en/API/SearchName/k_0w8gobka/%s", name);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }


}
