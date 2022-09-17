package main.java;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class mooksController {
    @GetMapping("/")
    public String index() {
        return "Greetings from SpringBoot!";
    }

    @GetMapping("/movies/popular")
    public String getMovieByTitle(){
        String uri = "https://imdb-api.com/en/API/MostPopularMovies/k_0w8gobka";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
