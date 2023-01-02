package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        // RestTemplate is the utility object which makes this call
        RestTemplate restTemplate = new RestTemplate();


        // Get all rated movie IDs (used the same Rating model)
        // Hardcoded the ratings
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 5),
                new Rating("5678", 4)
        );

        // for each rating creating a catalog element with hardcoded name and desc and making it as List
        return ratings.stream().map(rating -> {
            Movie movie =  restTemplate.getForObject("http://localhost:8082/movies/" +rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Test", rating.getRating());
        }).collect(Collectors.toList());


        // For each movie ID call movie infoService and get details

        // Put them all together
    }
}
