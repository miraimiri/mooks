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


    @GetMapping("/movie/keyword/{keyword}")
    public String getMovieByKeyword(@PathVariable String keyword) {
        String uri = String.format("https://imdb-api.com/en/API/SearchKeyword/k_0w8gobka/%s", keyword);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/movie/genre/{genre}")
    public String getMovieByGenre(@PathVariable String genre) {
        String uri = String.format("https://imdb-api.com/en/API/AdvancedSearch/k_0w8gobka/?genres=%s", genre);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/book/title/{title}")
    public String getBookByTitle(@PathVariable String title) {
        String uri = String.format("https://www.googleapis.com/books/v1/volumes?q=%s&key=AIzaSyA3tiLLRdj5eELisHHxRdFR_p2NBAUPPS0", title);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }


    @GetMapping("/book/author/{author}")
    public String getBookByAuthor(@PathVariable String author) {
        String uri = String.format("https://www.googleapis.com/books/v1/volumes?q=%s&key=AIzaSyA3tiLLRdj5eELisHHxRdFR_p2NBAUPPS0", author);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

}
