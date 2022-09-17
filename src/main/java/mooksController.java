package main.java;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import main.java.MovieResult;
import main.java.MovieResultMovie;
import main.java.Movie;

import java.net.HttpURLConnection;
import java.net.URL;

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
    public Movie getMovieByTitle(@PathVariable String title) {
        Movie movie = new Movie();
        String uri = String.format("https://imdb-api.com/en/API/SearchTitle/k_0w8gobka/%s", title);
        RestTemplate restTemplate = new RestTemplate();
        MovieResult movieResult = restTemplate.getForObject(uri, MovieResult.class);
        movie.setTitle(movieResult.results.get(0).getTitle());
        movie.setImageUrl(movieResult.results.get(0).getImage());
        movie.setYear(movieResult.results.get(0).getDescription());
        return movie;
    }

    @GetMapping("/movie/actor/{name}")
    public Movie getMovieByActor(@PathVariable String name) {
        Movie movie = new Movie();
        String uri = String.format("https://imdb-api.com/en/API/SearchName/k_0w8gobka/%s", name);
        RestTemplate restTemplate = new RestTemplate();
        MovieResult movieResult = restTemplate.getForObject(uri, MovieResult.class);
        movie.setTitle(movieResult.results.get(0).getTitle());
        movie.setImageUrl(movieResult.results.get(0).getImage());
        movie.setYear(movieResult.results.get(0).getDescription());
        return movie;
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
